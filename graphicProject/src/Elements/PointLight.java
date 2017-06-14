package Elements;

import primitives.*;
import java.awt.Color;
//test commit
public class PointLight extends Light implements LightSource{
	Point3D _position;
	double _Kc, _Kl, _Kq;
	
	// ***************** Constructors ********************** //
	public PointLight(Color color, Point3D position,
	double kc, double kl, double kq){
		super(color);
		_position = new Point3D(position);
		_Kc = kc;
		_Kl = kl;
		_Kq = kq;
	}
	
	// ***************** Getters/Setters ********************** //
	@Override
	public Color getIntensity(Point3D point)	{
		double d = getL(point).length();
		float attenuation = (float)(_Kc * _Kl * _Kq*Math.pow(d, 3));

		int r = Math.min((int)(_color.getRed() / attenuation), 255);
		int g = Math.min((int)(_color.getGreen() / attenuation), 255);
		int b = Math.min((int)(_color.getBlue() / attenuation), 255);
		return new Color(r, g, b);
	}
	
	@Override
	public Vector getL(Point3D point){
		return new Vector(point, _position);
	}
}