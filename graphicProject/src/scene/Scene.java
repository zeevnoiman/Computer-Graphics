
package scene;

import Elements.AmbientLight;
import Elements.Camera;
import Geometries.Geometry;

import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Created by daniel on 5/22/2017.
 */
public class Scene {
    String sceneName;
    Color background;
    AmbientLight ambientLight;
    java.util.List<Geometry> geometries;
    Camera camera;
    double screenDistance;
//----------------constructors------------------------//
    public Scene(String sceneName, Color background, AmbientLight ambientLight, List<Geometry> geometries, Camera camera, double screenDistance) {
        this.sceneName = sceneName;
        this.background = new Color(background.getRGB());
        this.ambientLight = new AmbientLight(ambientLight.getColor(), ambientLight.getKa());
        this.geometries = geometries;
        this.camera = camera;
        this.screenDistance = screenDistance;
    }
    public Scene() {
        sceneName = "sceneName";
        background = new Color(55, 25, 3);
        ambientLight = new AmbientLight();
        geometries = new ArrayList<Geometry>(0);
        camera = new Camera();
        screenDistance = 1;
    }
//-------------------------getters and setters-------------------------//
    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public AmbientLight getAmbientLight() {
        return ambientLight;
    }

    public void setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
    }

    public List<Geometry> getGeometries() {
        return geometries;
    }

    public void setGeometries(List<Geometry> geometries) {
        this.geometries = geometries;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public double getScreenDistance() {
        return screenDistance;
    }

    public void setScreenDistance(double screenDistance) {
        this.screenDistance = screenDistance;
    }

    //-----------------------function----------------------//
    public void addGeometry(Geometry myGeometry)
    {
        geometries.add(myGeometry);
    }
    public Iterator<Geometry> getGeometriesIterator(){
        return geometries.iterator();
    }
}


/*
 * package scene;
 

import java.awt.Color;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import Elements.Camera;
import Elements.AmbientLight;
import Elements.LightSource;
import Geometries.*;

//scene is a class that includes everything (background, light, camera, geometries etc.
public class Scene {
	
	private Color _background;
	private AmbientLight _ambientLight;
	private List<Geometry> _geometries = new ArrayList<Geometry>();
	private Camera _camera;
	private double _screenDistance;
	private List<LightSource> _lights = new ArrayList<LightSource>();
	private String _sceneName = "scene";
	
	
	//default cons
	public Scene()
	{
		_background=new Color(0, 0, 0);
		_ambientLight=new AmbientLight();
		_camera=new Camera();
		_screenDistance=100;
		this._geometries = null;
	}
	
	//copy cons
	public Scene (Scene scene)
	{
		_background=new Color(scene._background.getRGB());
		_ambientLight=new AmbientLight(scene._ambientLight);
		_camera=new Camera(scene._camera);
		_screenDistance=scene._screenDistance;
		_geometries.addAll(scene._geometries);
		
	}
	
	public Scene(AmbientLight aLight, Color background,
			Camera camera, double screenDistance)
			{
				_background=new Color(background.getRGB());
				_ambientLight=new AmbientLight(aLight);
				_camera=new Camera(camera);
				_screenDistance=screenDistance;
						
			}
	
	//full cons
	public Scene(AmbientLight aLight, Color background,
	Camera camera, List<Geometry> geometries ,double screenDistance)
	{
		_background=new Color(background.getRGB());
		_ambientLight=new AmbientLight(aLight);
		_camera=new Camera(camera);
		_screenDistance=screenDistance;
		_geometries = new ArrayList<Geometry>(geometries);
		
	}
	

	//getters and setters
	public Color getBackground()
	{
		return _background;
	}
	public AmbientLight getAmbientLight()
	{
		return _ambientLight;
	}
	public Camera getCamera()
	{
		
		return _camera;
	}
	public String getSceneName()
	{
		return _sceneName;
	}
	public double getScreenDistance(){
		return _screenDistance;
		
	}
	public void setBackground(Color _background)
	{
		_background=new Color(_background.getRGB());
		
	}
	public void setAmbientLight(AmbientLight ambientLight){
		_ambientLight=new AmbientLight(ambientLight);
	}
	public void setCamera(Camera camera){
		_camera=new Camera(camera);
	}
	public void setSceneName(String sceneNAme){
		_sceneName=sceneNAme;
	}
	public void setScreenDistance(double screenDistance){
		_screenDistance=screenDistance;
		
	}
	
	//operations
	public void addGeometry(Geometry geometry)
	{
		_geometries.add(geometry);
	}
	//get iterator for geometric
	public Iterator<Geometry> getGeometriesIterator()
	{
		return _geometries.iterator();
	}
	public void addLight(LightSource light){
		_lights.add(light);
	}


}
*/
