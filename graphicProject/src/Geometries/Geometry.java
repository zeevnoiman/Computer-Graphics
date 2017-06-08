package Geometries;
import primitives.*;
import java.awt.*;
import java.util.List;

/**
 * Created by daniel on 5/7/2017.
 */
public interface Geometry
{
    public abstract List<Point3D> FindIntersections (Ray ray);
}




/*
import java.awt.Color;
import java.util.List;

import primitives.*;

//an abstract class that gets all kinds of geometries the we have in other classes 
public abstract class Geometry {

	
	double _ks;
	double _kd;
	double _kr;
	double _kt;
	
	//represents how shiny is an object 
	private double _nShininess = 1;
	
	//represents the amount of light the object projects 
	private Color _emmission = new Color(0, 0, 0);
	
	//every material absorbs light differently so this is how we subscribe it here 
	private Material _material = new Material();
	
	//a list of all the intersections of rays with the object 
	public abstract List<Point3D> FindIntersections (Ray ray);
	
	public abstract Vector getNormal(Point3D point);
	
	public abstract Color getEmmission();
	
	
	public double getShininess(){return _nShininess;};

	public void setShininess(double n){this._nShininess = n;};
	
	public void setEmmission(Color emmission){this._emmission = new Color(_emmission.getRGB());};
	
	public Color get_emmission() {return _emmission;}
	
	public Material get_material() {
		return _material;
	}

	public void set_material(Material _material) {
		this._material = new Material(_material);
	}

	
	public void setKs(double ks){this._ks = ks;};
	
	public double getKs(){return this._ks;};
	
	public void setKd(double kd){this._kd = kd;};
	
	public double getKd(){return this._kd;}
	
	public void setKr(double Kr){this._kr = Kr;};
	
	public double getKr(){return this._kr;}
	
	public void setKt(double Kt){this._kt = Kt;}
	
	public double getKt(){return this._kt;}
	
};
	*/
