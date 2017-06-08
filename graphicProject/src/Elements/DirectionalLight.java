package Elements;


import java.awt.Color;

import primitives.*;

// directional light is a light such as the sun with a constant intensity and a curtain  direction 

public class DirectionalLight extends Light {

	//the direction of the light 
	private Vector direction;
	
	//default cons 
	public DirectionalLight()
	{
		this.direction=new Vector();
		_color = new Color(255,255,255);
	}
	
	//full cons
	public DirectionalLight(Color color, Vector direction){
		this._color= new Color(color.getRGB());
		this.direction=new Vector(direction);
	}
	@Override
	public Color getIntensity() {
		
		return null;
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = new Vector(direction);
	}
	
	public Vector getL(Point3D point){
		//don't know what to do here? 		
		return direction;
	};
	
	

}
