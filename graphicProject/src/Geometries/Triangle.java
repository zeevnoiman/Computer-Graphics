package Geometries;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import primitives.*;

public class Triangle extends Geometry implements FlatGeometry {
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;
	
	// ***************** Constructors ********************** //
	

	public Triangle(){
		_p1 = new Point3D();
		_p2 = new Point3D();
		_p3 = new Point3D();
	}

	public Triangle(Triangle triangle){
		this(triangle._p1, triangle._p2, triangle._p3);
	}

	public Triangle(Point3D p1, Point3D p2, Point3D p3){
		_p1 = new Point3D(p1);
		_p2 = new Point3D(p2);
		_p3 = new Point3D(p3);
	}
	public Triangle(Map<String, String> attributes){
		
	}
	
	// ***************** Getters/Setters ********************** //
	public Point3D getP1(){
		return new Point3D(_p1);
	}
	public Point3D getP2(){
		return new Point3D(_p2);
	}
	public Point3D getP3(){
		return new Point3D(_p3);
	}
	public void setP1(Point3D p1){
		_p1.setPoint(p1);
	}
	public void setP2(Point3D p2){
		_p2.setPoint(p2);
	}
	public void setP3(Point3D p3){
		_p3.setPoint(p3);
	}
	
	// ***************** Operations ******************** //

	@Override
	public Vector getNormal(Point3D point){
		Vector AB = new Vector(_p2,_p1);
		Vector AC = new Vector(_p3,_p1);


		Vector normal = AB.crossProduct(AC);
		normal.normalize();
		normal.scale(-1);
		return normal;
	}

	
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		Vector normal = new Vector(this.getNormal(_p1));
		normal.normalize();
		Plane plane = new Plane(normal,_p3);
		List<Point3D> tArrayList = plane.FindIntersections(ray);
		if (tArrayList.size() > 0) {
			if (checkInstructions(ray.getPOO(), tArrayList.get(0))){
				return tArrayList;
			}
		}
		return new ArrayList<Point3D>();		
	}
	
	
 // check if the intersection falls in with the triangle on the plane	
	
	private boolean checkInstructions(Point3D rayPoo, Point3D p0) {
		
		Vector P_P0 = new Vector(p0, rayPoo);
		Vector vProjector[] = new Vector[3];
		
		vProjector[0] = projector(_p1, _p2, p0);
		vProjector[1] = projector(_p2, _p3, p0);
		vProjector[2] = projector(_p3, _p1, p0);
		
		double[] sign = new double[3];
		for (int i = 0; i < vProjector.length; i++) {
			vProjector[i].normalize();
			sign[i] = P_P0.dotProduct(vProjector[i]);	
		}
	
		
		if ((sign[0] > 0 && sign[1] > 0 && sign[2] > 0)
			|| (sign[0] <= 0 && sign[1] <= 0 && sign[2] <= 0)){
			return true;
		}
		return false;
		
	}
	
	private Vector projector(Point3D vertex1, Point3D vertex2, Point3D p0) {
		Vector v1 = new Vector(vertex1,p0);
		Vector v2 = new Vector(vertex2,p0);
		return v2.crossProduct(v1);
	}
}
