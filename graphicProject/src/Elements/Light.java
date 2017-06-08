package Elements;

import java.awt.Color;

//import Primitives.Point3D;

//light class is an abstract description of the light concept

abstract public class Light {
	
	protected Color _color;
	
//default cons will define the light as white 
	public Light(){
		
		_color=new Color(255, 255, 255);
	}
	
	//copy constructor
	
	public Light (Color color)
	{
		_color=new Color(color.getRGB());
	}
	
	//abstract operation
	abstract public Color getIntensity();
	
	
}
