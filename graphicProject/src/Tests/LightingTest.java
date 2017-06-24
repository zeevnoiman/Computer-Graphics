package Tests;



import java.awt.Color;

import org.junit.Test;

import Elements.PointLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class LightingTest {

	
	@Test 
	public void emmissionTest(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(50);
		scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -50)));
		
		Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
				 						 new Point3D(  0, 100, -49),
				 						 new Point3D( 100, 100, -49));
		
		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
				 			 			  new Point3D(  0, -100, -49),
				 			 			  new Point3D( 100,-100, -49));
		triangle2.setEmmission(new Color (50, 200, 50));
		
		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
				 						  new Point3D(  0, 100, -49),
				 						  new Point3D(-100, 100, -49));
		triangle3.setEmmission(new Color (50, 50, 200));
		
		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
				 			 			  new Point3D(  0,  -100, -49),
				 			 			  new Point3D(-100, -100, -49));
		triangle4.setEmmission(new Color (200, 50, 50));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage1();
		render.printGrid(50);
		render.writeToImage();
	}
	
	
	
	@Test
	public void spotLightTest2(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
										 new Point3D(-225, -120, -260),
										 new Point3D(-235, -225, -280));
		
		triangle.setEmmission(new Color (0, 0, 100));
		triangle.setShininess(4);
		scene.addGeometry(triangle);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage1();
		render.writeToImage();
		
	}
	
	
	@Test
	public void spotLightTest(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
					   new Vector(2, 2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage1();
		render.writeToImage();
		
	}

	 
	@Test
	public void pointLightTest(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere (800, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
					   0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage1();
		render.writeToImage();
		
		
	}
	
	@Test
	public void spotLightTest3(){
		
		Scene scene = new Scene();
		
		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					   new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage1();
		render.writeToImage();
		
	}
	
	@Test
	public void pointLightTest2(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		
		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					   0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage1();
		render.writeToImage();
		
	}
	
	@Test
	public void shadowTest(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				   new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage1();
		render.writeToImage();
		
	}
		
	

}