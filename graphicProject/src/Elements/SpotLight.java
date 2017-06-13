package Elements;

import primitives.*;
import java.awt.Color;

public class SpotLight extends PointLight {
	private Vector _direction;
	
	// ***************** Constructor ********************** //
	
	public SpotLight(Color color, Point3D position, Vector direction,
	double kc, double kl, double kq){
		super(color, position, kc, kl, kq);
		_direction = new Vector(direction);
	}
	
	
	// ***************** Getters/Setters ********************** //
	@Override
	public Color getIntensity(Point3D point){
		
		
	
		Color Ie = super.getIntensity(point);
		
		int r = Math.min((int)(_color.getRed() * Ie.getRed()), 255);
		int g = Math.min((int)(_color.getGreen() * Ie.getGreen()), 255);
		int b = Math.min((int)(_color.getBlue() * Ie.getBlue()), 255);
		return new Color(r, g, b);

	}
}
