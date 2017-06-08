package renderer;

import Geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import scene.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by daniel on 5/23/2017.
 */
public class Render {
    Scene scene;
    ImageWriter imageWriter;

    public Render(Scene _scene, ImageWriter _imageWriter) {
        this.scene = _scene;
        this.imageWriter = _imageWriter;
    }
    public Render()
    {
        scene = new Scene();
        imageWriter = new ImageWriter("myImage", 500, 500, 500, 500);
    }

    //---------functions------------------//
    public void renderImage()
    {
        int i = 0;
        int j = 0;
        double NY = imageWriter.getNy();
        double NX = imageWriter.getNx();

        for(; i < imageWriter.getHeight() - 1; i++)
        {
            for(; j < imageWriter.getWidth() - 1; j++)
            {
            Ray ray = scene.getCamera().constructRayThroughPixel(NX, NY, j, i, scene.getScreenDistance(), imageWriter.getWidth(), imageWriter.getHeight());
            List<Point3D> intersectionPoints = getSceneRayIntersections(ray);
            if (intersectionPoints.isEmpty()){
                imageWriter.writePixel(j, i, scene.getBackground());
                imageWriter.writeToimage();
            }
            else{
                Point3D closestPoint = getClosestPoint(intersectionPoints);
                imageWriter.writePixel(j, i, calcColor(closestPoint));
                imageWriter.writeToimage();
                }
            }
            j = 0;
        }
    }
    public void printGrid(int interval)
    {
        int y = 0;
        int x = 0;

        y = y + interval;

        for (; y < 500; ) {
            for (; x < 500; ) {
                imageWriter.writePixel(x, y, new Color(255, 255, 255));
                x = x + 1;
                imageWriter.writeToimage();
            }
            y = y + interval;
            x = 0;
        }
        for (; x < 500; ) {
            for (; y < 500; ) {
                imageWriter.writePixel(x, y, new Color(255, 255, 255));
                y = y + 1;
                imageWriter.writeToimage();
            }
            y = 0;
            x = x + 50;
        }

    }
    private Color calcColor(Point3D point) {
        return scene.getAmbientLight().getIntensity();
    }
    private Point3D getClosestPoint(List<Point3D> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = scene.getCamera().getP0();
        Point3D minDistancePoint = null;
        for (Point3D point : intersectionPoints){
            if (P0.distance(point) < distance) {
                minDistancePoint = new Point3D(point);
                distance = P0.distance(point);
            }
        }
        return minDistancePoint;
    }
    private List<Point3D> getSceneRayIntersections(Ray ray) {
        Iterator<Geometry> geometries = scene.getGeometriesIterator();
        List<Point3D> intersectionPoints = new ArrayList<Point3D>();

        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);
            for (Point3D p : geometryIntersectionPoints) {
                intersectionPoints.add(p);
            }
        }
        return intersectionPoints;
    }
}

/*
package renderer;

import Geometries.*;
import primitives.*;
//import Elements.LightSource;
import scene.Scene;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Render {
	
	//render for rendering a scene with all the elements we have such as  geometries and lights etc.
	private Scene _scene;
	private ImageWriter _imageWriter;
	

	// Constructor
	public Render(ImageWriter imageWriter, Scene scene) {

		_scene = new Scene(scene);
		_imageWriter = new ImageWriter(imageWriter);

	}

	
	//building the image pixel by pixel 
	public void renderImage(){
		
		for (int i = 0; i < this._imageWriter.getNx(); i++)
			
			for (int j = 0; j < this._imageWriter.getNy(); j++) {
				
				Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), j, i,
						_scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
				
				Map<Geometry, List<Point3D>> interSectionPoints = getSceneRayIntersections(ray);
				
				if (interSectionPoints.isEmpty())
					_imageWriter.writePixel(j, i, _scene.getBackground());
				
				else {
					
					Map<Geometry, Point3D> closetPoint = getClosetPoint(interSectionPoints);
					
					Set<Geometry> v = closetPoint.keySet();
					
					Geometry firstGeo = v.iterator().next();
					
					_imageWriter.writePixel(i, j, calcColor(firstGeo, closetPoint.get(firstGeo)));
					
				}
			}
	}
	
	
	// services for the render-image operation
		private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {
			
			Iterator<Geometry> geometries = _scene.getGeometriesIterator();
			
			Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
			
			Geometry geometry = null;
			
			while (geometries.hasNext()) {
				
				geometry = geometries.next();
				
				List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);
				
				intersectionPoints.put(geometry, geometryIntersectionPoints);
			}
			return intersectionPoints;
		}

		
		// calculate point color
		
		private Color calcColor(Geometry geometry, Point3D point) {
			Color ambientLight = _scene.getAmbientLight().getIntensity();
			Color emissionLight = geometry.getEmmission();
			
			//we need to check here it is not finished
			int r = ambientLight.getRed() + emissionLight.getRed();
			int g = ambientLight.getGreen() + emissionLight.getGreen();
			int b = ambientLight.getBlue() + emissionLight.getBlue();
			
			if (r>255){r=255;}
			if (g>255){g=255;}
			if (b>255){b=255;}
			
			Color I0 = new Color(r,g,b);
			return I0;
		}

		
		// get the closest point to calculate the color for our image
		
		private Map<Geometry, Point3D> getClosetPoint(Map<Geometry, List<Point3D>> intersectionPoints) {
			double distance = Double.MAX_VALUE;
			Point3D P0 = _scene.getCamera().getP0();
			Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
			for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()) {
				for (Point3D point : entry.getValue()) {
					if (P0.distance(point) < distance) {
						minDistancePoint.clear();
						minDistancePoint.put(entry.getKey(), new Point3D(point));
					}
				}
			}
			return minDistancePoint;
		}
		
		
		public void printGrid(int interval)
		{
			for(int i = 0; i<_imageWriter.getWidth(); i++)
			{
				for(int j = 0; i<_imageWriter.getHeight(); j++)
				{
					if(i % interval == 0 ||i==(_imageWriter.getWidth() -1)|| j % interval ==0 ||j==(_imageWriter.getHeight() -1))					//maybe to add : " || i=_imageWriter.getWidth() -1"
						_imageWriter.writePixel(i, j, new Color(255,25,255));
				}
			  }
			}
		

		// write the scene to image
		public void writeToImage()
		{
			_imageWriter.writeToimage();
		}

	}

/*
 * //calcColor = ambientLight+EmissionLight
public void printGrid(int interval){}

private Color calcColor(Point3D p){return null;};

private Point3D getClosestPoint(List<Point3D> g){return null;}

//private List<Point3D> getSceneRayIntersections(Ray ray){return null;};

private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray){return null;};

private Color calcColor(Geometry geometry, Point3D point, Ray inRay){//(Returns ambient light + emission light)
	return null;};
	
private Color addColors(Color a, Color b){return null;};
	
}

*/
	




