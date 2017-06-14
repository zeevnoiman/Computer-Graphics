package Tests;
import primitives.*;
import Geometries.*;
import Elements.*;
import scene.*;
import java.awt.Color;

import org.junit.Test;

import renderer.*;


public class MyTest {

	@Test
	public void emmissionSemple() {
		

		//========================================================================================================//

		
		
	
			
		Color color = new Color(255,0,0);
		Point3D point3d = new Point3D(200,200,-20);
		Vector vector = new Vector(200,-200,-1280);
		
	
		
		//========================================================================================================//

         // */    
		
		Scene scene2 = new Scene(new AmbientLight(255,255,255), 
				new Color(50,0,0), 
				new Camera(), 100);

		Sphere sphere2 = new Sphere(200, new Point3D(800,-800,-600));
		
		Triangle triangle21 = new Triangle(new Point3D(200,70, -300),
				new Point3D(400,-100,-1200),
				new Point3D(200, -50, -15));

		Triangle triangle22 = new Triangle(new Point3D( 350, 0, -50),
				new Point3D(  0, -150, -50),
				new Point3D( 150,-150, -50));

		Triangle triangle23 = new Triangle(new Point3D(-600, 3000,-1500),
				new Point3D(400,-100,-1200), 
				new Point3D(-800,-801,-600));
				//new Point3D(-500,-700,-900));

		Triangle triangle24 = new Triangle(new Point3D(-600, 3000,-1500),
				new Point3D(400,-100,-1200),
				new Point3D(200, -150, -15));

		sphere2.setEmmission(new Color (10,15,250));
		
		triangle21.setEmmission(new Color (70, 220, 200));
		triangle22.setEmmission(new Color (255, 0, 255));
		triangle23.setEmmission(new Color (255, 255, 0));
		triangle24.setEmmission(new Color (50, 100,100));
		
		triangle21.setShininess(10);
		triangle22.setShininess(10);
		triangle23.setShininess(10);
		triangle24.setShininess(10);
		
		
		
		Plane plane2 = new Plane(new Vector(0, 1, 0), new Point3D(0, -130, 0));
		plane2.setKd(0);
		plane2.setShininess(200);
		plane2.setEmmission(new Color(0, 10, 0));
             
		
		PointLight pointLight2 =  new PointLight(new Color(200,50,50),
	              new Point3D(220,200,-20), 0.001, 0.001, 0.011);
		
		SpotLight spotLight2 = new SpotLight(color, point3d, vector, 0.01, 0.01, 0.02);

		DirectionalLight sun2 = new DirectionalLight(color, vector);
		
		scene2.addLight(sun2);
		scene2.addLight(spotLight2);
		scene2.addLight(pointLight2);
		
		scene2.addGeometry(sphere2);
		
		scene2.addGeometry(triangle21);
		//scene2.addGeometry(triangle22);
		scene2.addGeometry(triangle23);
		scene2.addGeometry(triangle24);
		//scene2.addGeometry(plane2);
		
		
		 
		 

		ImageWriter imageWriter2 = new ImageWriter("MY test2", 500, 500, 500, 500);

		Render render2 = new Render(imageWriter2, scene2);

		render2.renderImage1();
		//render2.printGrid(50);
		render2.writeToImage();
		
		//========================================================================================================//
		

	}
}
