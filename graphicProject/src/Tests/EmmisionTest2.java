package Tests;
import primitives.*;
import Geometries.*;
import Elements.*;
import scene.*;
import java.awt.Color;

import org.junit.Test;

import renderer.*;


public class EmmisionTest2 {
	
	@Test 
	public void emmissionTest(){

		Scene scene = new Scene();
		scene.setScreenDistance(38);
		
		scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -50)));

		Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
				new Point3D(  0, 100, -49),
				new Point3D( 100, 100, -49));

		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
				new Point3D(  0, -100, -49),
				new Point3D( 100,-100, -49));
		triangle2.setEmmission(new Color (200, 200, 150));

		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
				new Point3D(  0, 100, -49),
				new Point3D(-100, 100, -49));
		triangle3.setEmmission(new Color (50, 250, 200));

		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
				new Point3D(  0,  -100, -49),
				new Point3D(-100, -100, -49));
		triangle4.setEmmission(new Color (200, 50, 50));

		
		PointLight pointLight4 = new PointLight(new Color(255,50,50), new Point3D(220,0,-100), 0.001, 0.001, 0.001);
		PointLight spotLight1 = new PointLight(new Color(200, 0, 0), new Point3D(600, 0, -200), 0.002, 0.002, 0.002);
		
		scene.addLight(pointLight4);
		scene.addLight(spotLight1);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);

		ImageWriter imageWriter = new ImageWriter("Emmission testXX", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		//render.printGrid(50);
		render.writeToImage();
	}



}