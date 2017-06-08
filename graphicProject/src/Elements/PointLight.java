package Elements;


import java.awt.Color;

import primitives.*;

//point light has a direction and very intense centers like a point 
public class PointLight extends Light{

	Point3D _position;
	double _Kc, _Kl, _Kq;

	//full cons
	public PointLight(Color color, Point3D position, double kc, double kl, double kq){
		this._color=new Color(color.getRGB());
		this._Kc=kc;
		this._Kl=kl;
		this._Kq=kq;
	}

	@Override
	public Color getIntensity() {
		return null;
	}

	public Point3D getL(){
		return _position;
	};


}
