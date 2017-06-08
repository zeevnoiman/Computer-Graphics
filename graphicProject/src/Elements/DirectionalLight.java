package Elements;

import primitives.*;
import java.awt.Color;

public class DirectionalLight extends Light	implements LightSource{

	private Vector _direction;
	
	// ***************** Constructors ********************** //
	public DirectionalLight(Color color, Vector direction){
		super(color);
		_direction = new Vector(direction);
	}
	
	
	// ***************** Getters/Setters ********************** //
	@Override
	public Color getIntensity(Point3D point){
		
		return super.getIntensity();
	}
	public Vector getDirection() {
		return new Vector(_direction);
	}
	public void setDirection(Vector direction){
		_direction.setHead(direction.getHead());
	}
	@Override
	public Vector getL(Point3D point){
		return new Vector(point);
	}
}
