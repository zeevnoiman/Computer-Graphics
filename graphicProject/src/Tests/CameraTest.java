package Tests;
import primitives.*;

import Elements.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class CameraTest {

	@Test
	public void test() {
		
		Point3D P0 = new Point3D();
		Vector rVector = new Vector(100,-100,-100);
		rVector.normalize();
		//P0.subtract(rVector);
		Ray ray1 = new Ray(P0, rVector);
		
		Camera camera1 = new Camera();
		Ray cRay = camera1.constructRayThroughPixel(3, 3, 3, 3, 100, 150, 150);
		cRay.getDirection().normalize();
		int poo = ray1.getPOO().compareTo(cRay.getPOO());
	//	assertEquals(0, poo, 0);
		
		int direction = ray1.getDirection().compareTo(cRay.getDirection());
		assertEquals(0, direction, 0);
		
		// ***************************************************************************** //
		
		final int WIDTH = 3;
		final int HEIGHT = 3;
		Point3D[][] screen = new Point3D [HEIGHT][WIDTH];
		Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
				new Vector (0.0, 1.0, 0.0),
				new Vector (0.0, 0.0, -1.0));
		System.out.println("Camera:\n" + camera);
		for (int i = 0; i < HEIGHT; i++)
		{
			for (int j = 0; j < WIDTH; j++)
			{
				Ray ray = camera.constructRayThroughPixel(
						WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
				screen[i][j] = ray.getPOO();
				System.out.print(screen[i][j]);
				System.out.println(ray.getDirection());
				// Checking z-coordinate
				assertTrue(Double.compare(screen[i][j].getZ().getCoordinate(), -1.0) == 0);
				// Checking all options
				double x = screen[i][j].getX().getCoordinate();
				double y = screen[i][j].getY().getCoordinate();
				if (Double.compare(x, 3) == 0 ||
						Double.compare(x, 0) == 0 ||
						Double.compare(x, -3) == 0){
					if (Double.compare(y, 3) == 0 ||
							Double.compare(y, 0) == 0 ||
							Double.compare(y, -3) == 0){
						assertTrue(true);
					}
					else
						fail("Wrong y coordinate");
				} else
					fail("Wrong x coordinate");
			}
			System.out.println("---");
		}
		
		
		
	}

}
