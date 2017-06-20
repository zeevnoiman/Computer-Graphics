package Tests;

import java.awt.Color;

import org.junit.Test;

import Elements.PointLight;
import Elements.SpotLight;
import Geometries.Plane;
import Geometries.Sphere;
import Geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class Testim {

	/*
	
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
		//render.printGrid(50);
		render.writeToImage();
	}
	
	
	
	@Test
	public void spotLightTest2(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(255, 0, 100));
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
										 new Point3D(-2253, -1253, -3263),
										 new Point3D(-223, -223, -273));
		
		triangle.setEmmission(new Color (255, 0, 100));
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
		
		//Triangle triangle = new Triangle(new Point3D(  353,  353, -203),
		//		 						 new Point3D( -503, -303, -103),
		//		 						 new Point3D(  353, -353, -203));

		Triangle triangle2 = new Triangle(new Point3D(  903,  3000, -1093),
				 new Point3D( -3500, -3000, -1909),
				 new Point3D(  1300, -3500, -2009));
		
		//scene.addGeometry(triangle);
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
		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -900));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		
		Triangle triangle = new Triangle(new Point3D(  3503,  3533, -2030),
				 						 new Point3D( -3500, -3503, -100),
				 						 new Point3D(  3500, -3503, -203));

		Triangle triangle2 = new Triangle(new Point3D(  350,  3503, -2003),
				  						  new Point3D( -350,  3533, -1030),
				  						  new Point3D( -350, -3530, -100));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					   0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage1();
		render.writeToImage();
		
	}
	/*
	@Test
	public void shadowTest(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -900));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Point3D(  3003,  3500, -1093),
				 						 new Point3D( -3500, -3500, -909),
				 						 new Point3D(  300, -3500, -2009));

		Triangle triangle2 = new Triangle(new Point3D(  3500,  3523, -9033),
				  						  new Point3D( -5003,  3527, -9003),
				  						  new Point3D( -5023, -5023, -950));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				   new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage1();
		render.writeToImage();
		
	}
		
	*/
	
	@Test
	public void HouseTest(){
		
		Scene scene = new Scene();
		scene.setBackground(new Color(100,100,220));
		
		
		Sphere sphere = new Sphere(500, new Point3D(-1501,2501, -2100));
		sphere.setEmmission(new Color(230, 213, 49));
		
		
		
		Triangle triangle = new Triangle(new Point3D(  0,  0, -900),
				 						 new Point3D( 650, 0, -900),
				 						 new Point3D(  650, 651, -900));

		Triangle triangle2 = new Triangle(new Point3D(  0,  0, -900),
				 						 new Point3D( 0, 650, -900),
				 						 new Point3D( 650, 651, -900));
		
		Triangle triangle3 = new Triangle(new Point3D(  0,  650, -900),
				 							new Point3D( 650, 651, -900),
				 							new Point3D( 325, 1001, -900));
		
		Triangle triangle4 = new Triangle(new Point3D( 251, 0, -900),
										new Point3D( 401, 0, -900),
										new Point3D( 401, 200, -900));
		
		Triangle triangle5 = new Triangle(new Point3D(  251, 0, -900),
										new Point3D( 251, 200, -900),
										new Point3D( 401, 200, -900));
		/*
		Triangle triangle6 = new Triangle(new Point3D( 650, 0, -900),
											new Point3D( 650, 651, -900),
											new Point3D( 901, 650, -900));
		
		Triangle triangle7 = new Triangle(new Point3D( 651, 651, -900),
				new Point3D( 901, 651, -900),
				new Point3D( 901, 1300, -900));
		*/
		
		Triangle triangle66 = new Triangle(new Point3D( 651, 0, -900),
				new Point3D( 651, 651, -900),
				new Point3D( 1801, 800, -1200));
		
		
		
		Triangle triangle77 = new Triangle(new Point3D( 651, 0, -900),
				new Point3D( 1801, 800, -1200),
				new Point3D( 1801,0, -1200));
		
		Triangle triangle8 = new Triangle(new Point3D(651, 651, -900),
				 new Point3D( 325, 1000, -900),
				 new Point3D(  1801, 800, -1200));
		
		
		
		Plane plane = new Plane(new Vector(0,1,1),new Point3D(0,0,-900));
		
		
		triangle77.setEmmission(new Color(100, 0, 00));
		triangle66.setEmmission(new Color(100, 0, 00));
		triangle.setEmmission(new Color(0, 0, 100));
		triangle2.setEmmission(new Color(100, 0,0));
		triangle3.setEmmission(new Color(0, 100, 0));
		triangle4.setEmmission(new Color(0, 0, 0));
		triangle5.setEmmission(new Color(0, 0, 0));
		triangle8.setEmmission(new Color(0, 100,0));
		plane.setEmmission(new Color(0, 200, 20));
		
		
		//scene.addGeometry(triangle7);//converting to real 3d...
		//scene.addGeometry(triangle6);
		scene.addGeometry(triangle8);
		scene.addGeometry(triangle77);
		scene.addGeometry(triangle66);
		scene.addGeometry(triangle5);
		scene.addGeometry(triangle4);
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(plane);
		scene.addGeometry(sphere);
		
		
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(2000, 2000, -100), 
				   0.00005, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("House test 1", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage1();
		render.writeToImage();

}
	}