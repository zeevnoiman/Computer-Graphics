package Tests;




import java.awt.Color;
import org.junit.Test;

import Elements.*;
import Geometries.*;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;


public class RecursiaTest {

	@Test
	public void reflectionPointTest() {
		Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		ImageWriter imageWriter = new ImageWriter("Reflections Point Test1", 500, 500, 500, 500);
		
		
		Triangle triangle1 = new Triangle(new Point3D(100,-350,-3000), 
				 new Point3D(-600, 1000, -1900),new Point3D(-1800,-350,-1300));
		Plane plane = new Plane(new Vector(0, 1, 0), new Point3D(0, -350, -1600));
		Sphere sphere1 = new Sphere(350, new Point3D(0, 0, -800));
		Sphere sphere2 = new Sphere(200, new Point3D(300, 0, -1200));
		Sphere sphere3 = new Sphere(200, new Point3D(0, 0, -800));
		sphere1.setShininess(35);
		sphere2.setShininess(35);
		sphere3.setShininess(35);
		sphere1.setEmmission(new Color(17, 15, 116));
		sphere2.setEmmission(new Color(17, 116, 15));
		sphere3.setEmmission(new Color(116, 15, 17));
		triangle1.setEmmission(new Color(0, 0, 0));
		triangle1.setShininess(1);
		triangle1.setKd(0);
		triangle1.setKs(0);
		triangle1.setKr(1);
		plane.setEmmission(new Color(0, 0, 0));
		plane.setShininess(200);
		plane.setKd(0.5);
		plane.setKs(0.5);
		plane.setKr(1);
		

		triangle1.setEmmission(new Color(0,0,0));
		triangle1.setShininess(1);
		
		sphere1.setKd(0.5);
		sphere1.setKs(0.5);
		sphere1.setKr(0);
		sphere1.setKt(0.5);
		sphere2.setKt(1);
		sphere3.setKt(1);


		triangle1.setEmmission(new Color(0, 0, 0));
		scene.addGeometry(triangle1);
		scene.addGeometry(sphere1);
		scene.addGeometry(sphere2);
		scene.addGeometry(sphere3);
		scene.addGeometry(plane);

		PointLight pointLight = new PointLight(new Color(255, 50, 50), new Point3D(300, 100,-50), 0.00000056, 0.00000056, 0.000032);	
		
		scene.addLight(pointLight);
		
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();
	}
	
	@Test
	public void reflectionSpotTest() {
		Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		ImageWriter imageWriter = new ImageWriter("Reflections Spot Test1", 500, 500, 500, 500);
		
		
		Triangle triangle1 = new Triangle(new Point3D(100,-350,-3000), 
				 new Point3D(-600, 1000, -1900),new Point3D(-1800,-350,-1300));
		Plane plane = new Plane(new Vector(0, 1, 0), new Point3D(0, -350, -1600));
		Sphere sphere1 = new Sphere(350, new Point3D(0, 0, -800));
		Sphere sphere2 = new Sphere(200, new Point3D(300, 0, -1200));
		Sphere sphere3 = new Sphere(200, new Point3D(0, 0, -800));
		sphere1.setShininess(35);
		sphere2.setShininess(35);
		sphere3.setShininess(35);
		sphere1.setEmmission(new Color(17, 15, 116));
		sphere2.setEmmission(new Color(17, 116, 15));
		sphere3.setEmmission(new Color(116, 15, 17));
		triangle1.setEmmission(new Color(0, 0, 0));
		triangle1.setShininess(1);
		triangle1.setKd(0);
		triangle1.setKs(0);
		triangle1.setKr(1);
		plane.setEmmission(new Color(0, 0, 0));
		plane.setShininess(200);
		plane.setKd(0.5);
		plane.setKs(0.5);
		plane.setKr(1);
		

		triangle1.setEmmission(new Color(0,0,0));
		triangle1.setShininess(1);
		
		sphere1.setKd(0.5);
		sphere1.setKs(0.5);
		sphere1.setKr(0);
		sphere1.setKt(0.5);
		sphere2.setKt(1);
		sphere3.setKt(1);


		triangle1.setEmmission(new Color(0, 0, 0));
		scene.addGeometry(triangle1);
		scene.addGeometry(sphere1);
		scene.addGeometry(sphere2);
		scene.addGeometry(sphere3);
		scene.addGeometry(plane);

		
		SpotLight spotLight = new SpotLight(new Color(255, 50, 50), new Point3D(50, 100,-50), new Vector(0, -1, -1), 0.00056, 0.00056, 0.0000032);
		
		scene.addLight(spotLight);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();
	}
	
	@Test
	public void test() {
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
              sphere.setKt(0.5);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
		sphere2.setShininess(20);
		sphere2.setEmmission(new Color(100, 20, 20));
		sphere2.setKt(0);
		scene.addGeometry(sphere2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					   new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 1", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
	}
	
	
	@Test
	public void recursiveTest2(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
		Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		sphere.setKt(0.5);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000));
		sphere2.setShininess(20);
		sphere2.setEmmission(new Color(100, 20, 20));
		sphere2.setKt(0);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
				 						 new Point3D( -1500,  1500, -1500),
				 						 new Point3D(  200,  200, -375));
		
		Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
										  new Point3D( -1500,  1500, -1500),
										  new Point3D( -1500, -1500, -1500));
		
		triangle.setEmmission(new Color(20, 20, 20));
		triangle2.setEmmission(new Color(20, 20, 20));
		triangle.setKr(1);
		triangle2.setKr(0.5);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
		
	}
	
	@Test
	public void recursiveTest3(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
		Sphere sphere = new Sphere(300, new Point3D(0, 0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		sphere.setKt(0.5);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(150, new Point3D(0, 0, -1000));
		sphere2.setShininess(20);
		sphere2.setEmmission(new Color(100, 20, 20));
		sphere2.setKt(0);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Point3D(  2000, -1000, -1500),
				 						 new Point3D( -1000,  2000, -1500),
				 						 new Point3D(  700,  700, -375));
		
		Triangle triangle2 = new Triangle(new Point3D(  2000, -1000, -1500),
										  new Point3D( -1000,  2000, -1500),
										  new Point3D( -1000, -1000, -1500));
		
		triangle.setEmmission(new Color(20, 20, 20));
		triangle2.setEmmission(new Color(20, 20, 20));
		triangle.setKr(1);
		triangle2.setKr(0.5);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 3", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.writeToImage();
	}

}
