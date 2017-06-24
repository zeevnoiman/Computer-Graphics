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

public class LightTest {

	@Test
	public void spotLightTest2(){

		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Sphere sphere = new Sphere(500, new Point3D(0.5, 0.0, -1050));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(100, 0, 100));
		scene.addGeometry(sphere);

		Triangle triangle = new Triangle(new Point3D(-155, -225, -250),
				new Point3D(-225, -150, -260),
				new Point3D(-210, -255, -270));

		triangle.setEmmission(new Color (0, 0, 100));
		triangle.setShininess(40);
		scene.addGeometry(triangle);

		scene.addLight(new SpotLight(new Color(255, 150, 100), new Point3D(-200, -250, -150), 
				new Vector(2, 2, -3), 0.1, 0.0001, 0.0005));
		
		ImageWriter imageWriter = new ImageWriter("Spot lighting test 2!!!!!!!!!", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}


	@Test
	public void spotLightTest(){

		Scene scene = new Scene();
		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1050));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
				new Vector(2, 2, -3), 0, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("Spot lighting test@@@@@@@@@", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}


	@Test
	public void pointLightTest(){

		Scene scene = new Scene();
		Sphere sphere = new Sphere (800, new Point3D(0.0, 0.0, -1050));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
				0.0002, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("Point lighting testYYY", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();


	}

	@Test
	public void spotLightTest3(){

		Scene scene = new Scene();

		Triangle triangle =new Triangle(new Point3D(-155, -225, -250),
				new Point3D(-225, -150, -260),
				new Point3D(-210, -255, -270));

		Triangle triangle2 = new Triangle(new Point3D(  3505,  3505, -500),
				new Point3D( -3500,  350, -999),
				new Point3D( -350, -300, -105));
		
		Triangle triangle3 = new Triangle(new Point3D(-155, -225, -250),
				new Point3D(-225, -150, -260),
				new Point3D(-210, -255, -270));
		triangle2.setEmmission(new Color(200, 220, 100));
		triangle2.setShininess(200);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(250, 250, -100), 
				new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("Spot lighting test 333333333333", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
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


		ImageWriter imageWriter = new ImageWriter("Point lighting test 2666666666666", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}

	@Test
	public void shadowTest(){

		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere(500, new Point3D(0.0, 5.0, -1005));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(100, 0, 100));

		scene.addGeometry(sphere);

		Triangle triangle = new Triangle(new Point3D(  1503,  1502, -1005),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  3500, -3500, -2500));

		Triangle triangle2 = new Triangle(new Point3D(  1550,  1500, -1000),
				new Point3D( -1503,  3503, -900),
				new Point3D( -3503, -3503, -900));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				new Vector(-2, -2, -3), 0, 0.001, 0.0005));


		ImageWriter imageWriter = new ImageWriter("shadow lighting test77777777", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}


	@Test
	public void pointLightTest3(){

		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Sphere sphere = new Sphere(100, new Point3D(6.0, 9.0, -900));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);

		Triangle triangle = new Triangle(new Point3D(-1055, -252, -250),
				new Point3D(-222, -152, -265),
				new Point3D(-222, -252, -275));

		triangle.setEmmission(new Color (0, 0, 100));
		triangle.setShininess(1);
		scene.addGeometry(triangle);

		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				 0.1, 0.00001, 0.000005));
		/*scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				new Vector(2, 2, -3), 0.001, 0.000001, 0.000005));*/

		ImageWriter imageWriter = new ImageWriter("shadow point lighting test 38888888888", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}

}