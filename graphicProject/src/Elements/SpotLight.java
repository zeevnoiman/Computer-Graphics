package Elements;



import java.awt.Color;

import primitives.*;

//spot light is like a beam of light that has a direction and color etc.

public class SpotLight extends PointLight{

	private Vector _direction;
	
	//full cons
	public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq){
		super(color, position, kc, kl, kq);
		this._direction=new Vector(direction);
	}

	//operation
	public Color getIntensity(Point3D point){
		return null;
		};
	
	@Override
	public Color getIntensity() {
		return null;
	}
	
	public Vector getL(Point3D point){
		return null;
	};
	
	public Vector getDirection (){
	 return this._direction;
	}
	
	public void setDirection (Vector vec){
		 this._direction = vec;
		}

	
}


