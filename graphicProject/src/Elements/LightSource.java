package Elements;

import primitives.*;
import java.awt.Color;

public interface LightSource {
	
	public abstract Color getIntensity(Point3D point);
	public abstract Vector getL(Point3D point); 
	
}

