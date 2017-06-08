package Elements;

import java.awt.Color;
//import Primitives.Point3D;

//import Primitives.Coordinate;


//ambient light class for ambient light in a scene 
public class AmbientLight extends Light{
	
Color _color;
private double _Ka = 0.1;

//=================constructors as asked in the moodle 
public AmbientLight() {
			
	this._color = new Color(255,255,255);
	
	this._Ka = 1.0;
}

public AmbientLight(Color color) {
	
	this._color = new Color(color.getRGB());
	
	this._Ka = 0.5;
}

public AmbientLight(Color color, double d) {
	
	this._color = new Color(color.getRGB());
	
	this._Ka = d;
}
public AmbientLight(AmbientLight aLight) {
	
	this._color = new Color(aLight.getColor().getRGB());
	this._Ka=aLight._Ka;
}

public AmbientLight(int r,int g , int b) {
	this._color = new Color(r,g,b);
	this._Ka = 0.1;
	
}


// get intensity function returns the color * a constent factor
@Override
public Color getIntensity(){
	Color color = new Color((int)(_color.getRed()*_Ka),(int)(_color.getGreen()*_Ka),(int)(_color.getBlue()*_Ka));
	
	return color;
	};
	
//getters and setters
	
public void setColor(Color color) {this._color = new Color(color.getRed(),color.getGreen(),color.getBlue());}

public Color getColor(){return _color;}

public void setKa(double ka){this._Ka = ka;}

public double getKa(){return _Ka;}


@Override
public String toString() {
	return "color is" + _color.getRGB()  + "Ka is: " + _Ka ;
	}

//compare function compares two lights
public int compareTo(AmbientLight ambL)
{
	if (Math.abs((ambL.getColor().getRGB() - _color.getRGB())* (ambL.getKa() - _Ka )) <= 0.0001)
	return 0;
	else
	return -1;
};



	
}
