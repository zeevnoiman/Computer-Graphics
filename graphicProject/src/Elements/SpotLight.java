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
		
		Vector L = new Vector(point, _position);		
		L.normalize();
		_direction.normalize();
		double DversusL = _direction.dotProduct(L);
		//DversusL = Math.abs(DversusL);
		if(DversusL < 0){
			DversusL = 0;
		}
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
}
