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

	/*
	@Override
	public Color getIntensity(Point3D point){
		
		Vector L = new Vector(point, _position);
		
		double DversusL = _direction.dotProduct(L);
		
		int r = Math.min((int)(DversusL * _color.getRed()), 255);
		int g = Math.min((int)(DversusL * _color.getGreen()), 255);
		int b = Math.min((int)(DversusL * _color.getBlue()), 255);
	
		double d = getL(point).length();
		float attenuation = (float)(_Kc * _Kl * _Kq*Math.pow(d, 3));
	
		int r1 = Math.min((int)(r / attenuation), 255);
		int g1 = Math.min((int)(g / attenuation), 255);
		int b1 = Math.min((int)(b / attenuation), 255);
		
		return new Color(r1, g1, b1);

	}
	*/
	
	@Override
	public Color getIntensity(Point3D point){
		
		Vector dVector = new Vector(_direction);
		Vector lVector = getL(point);//The point of impact on geometry
		double d = point.distance(_position);
		dVector.normalize();
		lVector.normalize();
		double attenuation = Math.abs(dVector.dotProduct(lVector));//dotProduct  between L and D
		if (attenuation < 0) {
			return new Color(0, 0, 0);
		}
		attenuation /= (_Kc + _Kl * d + _Kq * Math.pow(d, 2)); // equal to => Kc * Ki*d * Kq*d^2

		int r = Math.min((int)(_color.getRed() * attenuation), 255);
		int g = Math.min((int)(_color.getGreen() * attenuation), 255);
		int b = Math.min((int)(_color.getBlue() * attenuation), 255);
		return new Color(r, g, b);

	}
	
}
