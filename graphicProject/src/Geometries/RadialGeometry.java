package Geometries;


import primitives.Point3D;
import primitives.Ray;

import java.util.List;

/**
 * Created by daniel on 3/22/2017.
 */
public class RadialGeometry implements Geometry{
    protected double radius;

    //****************Constructors*********************//
    public RadialGeometry(double radius) {
        this.radius = radius;
    }
    public RadialGeometry()
    {
        radius = 1;
    }
    //*****************Getter and Setter********************//
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        return null;
    }
}


/*
public abstract class RadialGeometry extends Geometry{
	
	//abstract class for all the shapes that have a radius so they could use this abstract class 

	protected double _radius;
	
	//==========constructors 
	public RadialGeometry(){this._radius = 0;};
	
	public RadialGeometry(double radius){this._radius = radius; };
	
	public RadialGeometry(RadialGeometry radialGepmetry) {this._radius = radialGepmetry._radius; }
	
	//=========get and set function.
	public double getRadius(){return _radius; };
	
	public void setRadius(double radius){_radius = radius; };
	
}

*/
