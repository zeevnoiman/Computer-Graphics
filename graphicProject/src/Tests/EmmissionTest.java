package Tests;
import primitives.*;
import Geometries.*;
import Elements.*;
import scene.*;
import java.awt.Color;

import org.junit.Test;

import renderer.*;


public class EmmissionTest {

	@Test
	public void emmissionSemple() {
		/*
		Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
		//Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(new Point3D(5,5,5), new Vector(1,3,2), new Vector(1,5,2)), 100);
		ImageWriter imageWriter = new ImageWriter("PointLightTest", 500, 500, 500, 500);
		Sphere sph1 = new Sphere(400, new Point3D(100,50,-1000));
		Sphere sph2 = new Sphere(300, new Point3D(500,-300,-700));
		Sphere sph3 = new Sphere(200, new Point3D(0,-10,-100));
		Triangle tri = new Triangle(new Point3D(400, 2400,-1200), new Point3D(1101,200,-1300), new Point3D(300,-300,-1101));
		Triangle tri5 = new Triangle(new Point3D(-400, 2000,-1100), new Point3D(200,-100,-1200), new Point3D(-500,-700,-900));
		Triangle tri3 = new Triangle(new Point3D(-700, 4000,-1500), new Point3D(200,-100,-1200), new Point3D(-500,-700,-900));
		sph1.setShininess(35);
		sph1.setEmmission(new Color(10,15,250));
		sph2.setShininess(20);
		sph2.setEmmission(new Color(17,200,200));
		sph3.setShininess(0);
		sph3.setEmmission(new Color(100,20,56));
		tri3.setShininess(200);
		tri3.setEmmission(new Color(255,0,0));
		tri.setShininess(10);
		tri.setEmmission(new Color(30,12,255));
		tri5.setShininess(10);
		tri5.setEmmission(new Color(30,144,255));
		PointLight pointLight = new PointLight(new Color(255,50,50),
				              new Point3D(220,200,-20), 0.002, 0.002, 0.001);
		scene.addGeometry(sph1);
		scene.addGeometry(sph2);
		scene.addGeometry(sph3);
		scene.addGeometry(tri);
		scene.addGeometry(tri3);
		scene.addGeometry(tri5);
		scene.addLight(pointLight);
		
		
		Render render = new Render(imageWriter, scene);
		render.renderImage1();
		render.writeToImage();
		
	
		*/
//---------------------------------------------------------------------//

		//========================================================================================================//
/*
		
		Scene scene1 = new Scene(new AmbientLight(255,255,255), 
    			new Color(0,0,0), 
    			new Camera(), 100);
		 Sphere sphere = new Sphere(9000, new Point3D(0.0, 0.0, -6000));
		 sphere.setShininess(20);
		 sphere.setEmmission(new Color(255, 0, 0));
		// sphere.setKt(1);
	        
		 Plane plane = new Plane(new Vector(0, 1, 0), new Point3D(0, -130, 0));
		 plane.setKd(0);
		 plane.setShininess(200);
		 plane.setEmmission(new Color(0, 10, 0));
		 
		 Triangle triangle = new Triangle(new Point3D( 1000, -200, -600),
                 new Point3D(  -100, -200, -1000),
                 new Point3D( 400, 1000, -800));
		 triangle.setKs(0);
		 triangle.setKd(0);
		// triangle.setKr(1);
		 triangle.setShininess(1);
		 triangle.setEmmission(new Color(0, 5, 0));
		 
		 
		 
	    
		
		scene1.addGeometry(sphere);
		scene1.addGeometry(triangle);
		scene1.addGeometry(plane);
	
		
		Color color = new Color(255,255,0);
		Point3D point3d = new Point3D(200,200,-20);
		Vector vector = new Vector(200,-200,-1280);
		
		PointLight pointLight2 = new PointLight(color, point3d, 0.02, 0.02,0.01);
		
		SpotLight spotLight = new SpotLight(color, point3d, vector, 0.01, 0.01, 0.02);

		DirectionalLight sun = new DirectionalLight(color, vector);
		
		scene1.addLight(sun);
		scene1.addLight(spotLight);
		
		ImageWriter imageWriter1 = new ImageWriter("spotLight Test", 500, 500, 500, 500);

		Render render1 = new Render(imageWriter1, scene1);

		render1.renderImage1();
		render1.printGrid(50);
		render1.writeToImage();
	
		*/
		//========================================================================================================//

         // */
		
		/*
		Scene scene2 = new Scene(new AmbientLight(255,20,255), 
				new Color(255,255,100), 
				new Camera(), 200);

		Sphere sphere2 = new Sphere(50, new Point3D(0.0, 0.0, -50));
		
		Triangle triangle21 = new Triangle(new Point3D( 150, 0, -50),
				new Point3D(  0, 150, -50),
				new Point3D( 150, 150, -50));

		Triangle triangle22 = new Triangle(new Point3D( 150, 0, -50),
				new Point3D(  0, -150, -50),
				new Point3D( 150,-150, -50));

		Triangle triangle23 = new Triangle(new Point3D(-150, 0, -50),
				new Point3D(  0, 150, -50),
				new Point3D(-150, 150, -50));

		Triangle triangle24 = new Triangle(new Point3D(-150, 0, -50),
				new Point3D(  0,  -150, -50),
				new Point3D(-150, -150, -50));

		sphere.setEmmission(new Color (0, 255, 255));
		
		triangle21.setEmmission(new Color (0, 255, 255));
		triangle22.setEmmission(new Color (255, 0, 255));
		triangle23.setEmmission(new Color (255, 255, 0));
		triangle24.setEmmission(new Color (50, 100,100));
             
		scene2.addGeometry(sphere2);
		scene2.addGeometry(triangle21);
		scene2.addGeometry(triangle22);
		scene2.addGeometry(triangle23);
		scene2.addGeometry(triangle23);

		ImageWriter imageWriter2 = new ImageWriter("MY test", 500, 500, 500, 500);

		Render render2 = new Render(imageWriter2, scene2);

		render2.renderImage1();
		render2.printGrid(50);
		render2.writeToImage();
		
		*/
		//========================================================================================================//
		
		//  /*
	//------------------------------------------------------------------------------//
		/*
		Scene scene3 = new Scene(new AmbientLight(255,255,255), 
				new Color(255,255,255), 
				new Camera(), 200);

		Sphere sphere3 = new Sphere(900, new Point3D(0.0, 0.0, -1000));
		
		Triangle triangle13 = new Triangle(new Point3D( 150, 0, -50),
				new Point3D(  0, 150, -50),
				new Point3D( 150, 150, -50));

		Triangle triangle32 = new Triangle(new Point3D( 150, 0, -50),
				new Point3D(  0, -150, -50),
				new Point3D( 150,-150, -50));

		Triangle triangle33 = new Triangle(new Point3D(-150, 0, -50),
				new Point3D(  0, 150, -50),
				new Point3D(-150, 150, -50));

		Triangle triangle43 = new Triangle(new Point3D(-150, 0, -50),
				new Point3D(  0,  -150, -50),
				new Point3D(-150, -150, -50));

		sphere.setEmmission(new Color (255, 255, 255));
		triangle.setEmmission(new Color (255, 255, 255));
		triangle23.setEmmission(new Color (255, 255, 255));
		triangle33.setEmmission(new Color (255, 255, 255));
		triangle43.setEmmission(new Color (255, 255, 255));

		scene3.addGeometry(sphere3);
		scene3.addGeometry(triangle13);
		scene3.addGeometry(triangle32);
		scene3.addGeometry(triangle33);
		scene3.addGeometry(triangle43);

		ImageWriter imageWriter3 = new ImageWriter("Emmission test", 500, 500, 500, 500);

		Render render3 = new Render(imageWriter3, scene3);

		render3.renderImage1();
		render3.printGrid(50);
		render3.writeToImage();
*/
		
		//---------------------------------------------------//
		Scene scene4 = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 1000);
		ImageWriter imageWriter4 = new ImageWriter("PointLightTestmy42", 500, 500, 500, 500);
		
		Sphere sph4 = new Sphere(400, new Point3D(0,0,-2000));
		sph4.setShininess(600);
		sph4.setEmmission(new Color(150,100,0));
		
		PointLight pointLight4 = new PointLight(new Color(0,0,128), new Point3D(2500,-2000,-1500), 0.0002, 0.002, 0.0001);
		
		scene4.addGeometry(sph4);		
		scene4.addLight(pointLight4);
		Render render4 = new Render(imageWriter4, scene4);
		render4.renderImage1();
		render4.writeToImage();

		
		
		
		//========================================================================================================//


			

		Scene scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 200);
       	Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.setShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		
		scene.addGeometry(sphere);
		
		Triangle triangle1 = new Triangle(new Point3D(  180,  -150, -700),
							 new Point3D( 220, 200, -500),
				 						 new Point3D(  450, -170, -700));

		Triangle triangle2 = new Triangle(new Point3D(  350,  350, -2000),
				  						  new Point3D( -3490,  350, -1000),
				  						  new Point3D( -340, -350, -1000));
		triangle1.setEmmission(new Color(70, 50, 36));
		scene.addGeometry(triangle1);
		//scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(55, 0, 76), new Point3D(200, 200, -100), 
				   new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
	
		
			
			ImageWriter imageWriter = new ImageWriter("Shadow test", 500, 500, 500, 500);
			
			Render render = new Render(imageWriter, scene);
			
			render.renderImage1();
			render.writeToImage();
			
		
	



		
	}
}
