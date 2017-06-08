package Geometries;

import java.util.List;

// import com.sun.org.apache.regexp.internal.recompile;

import primitives.*;

public class Cylinder extends RadialGeometry{
	
	private Point3D _axisPoint;
	private Vector _axisDirection;
	
	// ***************** Constructors ********************** //
	
	public Cylinder(){
		this(0, new Point3D(), new Vector());
	}
	public Cylinder(Cylinder cylinder){
		this(cylinder._radius, cylinder._axisPoint, cylinder._axisDirection);
		
	}
	public Cylinder(double radius, Point3D axisPoint, Vector axisDirection){
		_radius = radius;
		_axisPoint = new Point3D(axisPoint);
		_axisDirection = new Vector(axisDirection);
	}
	// ***************** Getters/Setters ********************** //
	
	public Point3D getAxisPoint(){
		
		return _axisPoint;
	}
	public Vector getAxisDirection(){
		
		return _axisDirection;
	}
	public void setAxisPoint(Point3D axisPoint){
		_axisPoint.setPoint(axisPoint);
	}
	public void setAxisDirection(Vector axisDirection){
		_axisDirection.setHead(axisDirection.getHead());
	}
	
	// ***************** Operations ******************** //
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		
		return null;
	}
	public Vector getNormal(Point3D point){
		
		return null;
	}
}
