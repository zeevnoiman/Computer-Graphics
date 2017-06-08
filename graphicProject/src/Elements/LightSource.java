package Elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;


//a light source interface to define the light source 

public interface LightSource {
	public abstract Color getIntensity(Point3D point);
	
	public abstract Vector getL(Point3D point); // light to point vector
}
