package Geometries;

import primitives.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sphere extends RadialGeometry{

	private Point3D _center;
	
	// ***************** Constructors ********************** //
	
	public Sphere(){
		_center = new Point3D();
	}
	public Sphere (Sphere sphere){
		this(sphere._radius, sphere._center);
		
	}
	public Sphere(double radius, Point3D center){
		super(radius);
		_center = new Point3D(center);
		
	}
	public Sphere(Map<String, String> attributes){
		
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Point3D getCenter(){
		return new Point3D(_center);
	}
	public void setCenter(Point3D center){
		_center.setPoint(center);
	}
	// ***************** Operations ******************** //

	
    @Override
	public List<Point3D> FindIntersections(Ray ray) {
		Point3D P0 = ray.getPOO();
		Vector L = new Vector(_center, P0);
		Vector V = new Vector(ray.getDirection());
		V.normalize();
		double t_m = L.dotProduct(V);
		double d = (Math.sqrt(  Math.pow(L.length(),2) - Math.pow(t_m, 2) ) );
		
		List<Point3D> pArrayList = new ArrayList<Point3D>();
		if (d <= _radius) {
			double t_h = (Math.sqrt( ( Math.pow(_radius,2) - Math.pow(d, 2) ) ));
			double t1 = t_m - t_h;
			double t2 = t_m + t_h;
			
		
			Point3D p1 = intersecPoint(ray, t1);
			Point3D p2 = intersecPoint(ray, t2);
			
			if (t1 > 0) 				
				pArrayList.add(p1);
			if (t2 > 0) 
				pArrayList.add(p2);
			return pArrayList;
		}
		
		return pArrayList;
	}
	
	private  Point3D intersecPoint(Ray ray, double t) {
		Point3D P0 = ray.getPOO();
		Vector V = new Vector(ray.getDirection());
		V.normalize();
		V.scale(t);
		P0.add(V);
		return new Point3D(P0);
	}
	
	@Override
	public Vector getNormal(Point3D point){
		Vector vector = new Vector(point,_center);
		vector.normalize();
		return vector;
	}
}
