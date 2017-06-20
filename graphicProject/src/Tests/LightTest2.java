package Tests;



	import primitives.*;
	import Geometries.*;
	import Elements.*;
	import scene.*;
	import java.awt.Color;

	import org.junit.Before;
	import org.junit.Test;

	import renderer.*;



	public class LightTest2 {

		Scene scene;
		ImageWriter imageWriter;
		Triangle triangle1;
		Triangle triangle2;
		Sphere sphere;
		Sphere sph1;
		PointLight pointLight;
		SpotLight spotLight;
		Render render;
		
		@Before
		public void forTest() {
			
			triangle1 = new Triangle(new Point3D(401, -400,-150), 
					new Point3D(-399,-400,-150), new Point3D(401, 400,-200));
			triangle2 = new Triangle(new Point3D(-401, -400, -150), 
					new Point3D(399,400,-200), new Point3D(-401, 400, -200));
			
			triangle1.setEmmission(new Color(255,0,0));
			triangle2.setEmmission(new Color(0,255,0));
			triangle1.setShininess(20);
			triangle2.setShininess(20);

			triangle1.setEmmission(new Color(0, 0, 50));
			triangle2.setEmmission(new Color(0, 0, 50));
			
		
			sph1 = new Sphere(900, new Point3D(0,0,-1300));
			sph1.setShininess(35);
			sph1.setEmmission(new Color(17,15,116));
			
			
		}
		
		@Test
		public void pointTest(){
			scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
			imageWriter = new ImageWriter("Point Light Test 4", 500, 500, 500, 500);
			
			pointLight = new PointLight(new Color(255, 50, 50), new Point3D(0, 0,0), 0, 0.0000056, 0.000032);
			scene.addGeometry(triangle1);
			scene.addGeometry(triangle2);
			scene.addLight(pointLight);
			render = new Render(imageWriter, scene);
			render.renderImage();
			render.writeToImage();
		}
		
		@Test
		public void pBallTest(){
			
			scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
			imageWriter = new ImageWriter("Ball Point Light Test", 500, 500, 500, 500);
			pointLight = new PointLight(new Color(255,50,50), new Point3D(220,200,-20), 0.000008, 0.000008, 0.000002);
			scene.addLight(pointLight);
			scene.addGeometry(sph1);
			
			render = new Render(imageWriter, scene);
			render.renderImage();
			render.writeToImage();
			
			spotLight = new SpotLight(new Color(255, 50, 50), new Point3D(0, 0,0), new Vector(0, 0, -1), 0.0000056, 0.0000056, 0.000032);
			scene.addLight(spotLight);
		}
		
		@Test
		public void spotTest(){
			scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
			imageWriter = new ImageWriter("Spot Light Test 4", 500, 500, 500, 500);
			
			spotLight = new SpotLight(new Color(255, 50, 50), new Point3D(0, 0,0), new Vector(0,0, -1), 0.0000056, 0.0000056, 0.000032);
			scene.addLight(spotLight);
			scene.addGeometry(triangle1);
			scene.addGeometry(triangle2);
			render = new Render(imageWriter, scene);
			render.renderImage();
			render.writeToImage();
		}

		/*@Test
		public void sBallTest(){
			scene = new Scene(new AmbientLight(255,255,255), new Color(0,0,0), new Camera(), 100);
			imageWriter = new ImageWriter("Ball Spot Light Test 4", 500, 500, 500, 500);
			
			spotLight = new SpotLight(new Color(255, 50, 50), new Point3D(200, 200, -20), new Vector(-1,0, -1), 0.0000056, 0.0000056, 0.000032);
			scene.addLight(spotLight);
			scene.addGeometry(sph1);
			render = new Render(imageWriter, scene);
			render.renderImage();
			render.writeToImage();
		}
		*/
	}
