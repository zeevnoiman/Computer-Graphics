package Tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import Elements.AmbientLight;
import Elements.Camera;
import Geometries.Geometry;
import Geometries.Sphere;
import primitives.Point3D;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class rendererTest {

	@Test
	public void RenderTest() {
		java.util.List<Geometry> geometries = new ArrayList<Geometry>(1);
        geometries.add((Geometry) new Sphere(30, new Point3D(0,0, -150)));

        Scene myScene = new Scene("sceneName", new Color(55, 3, 100), new AmbientLight(), geometries, new Camera(), 100 );
        ImageWriter myImageWriter = new ImageWriter("estupido", 500, 500, 500, 500);
        Render myRender = new Render(myScene, myImageWriter);
        //myRender.printGrid(50);
        myRender.renderImage();
	}

}
