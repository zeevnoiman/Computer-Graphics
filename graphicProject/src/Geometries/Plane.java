package Geometries;

import java.util.ArrayList;

import java.util.List;

import primitives.*;

import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 3/22/2017.
 */
public class Plane implements FlatGeometry, Geometry {
    private Vector normal;
    private Point3D Q;

    // ***************** Constructors ********************** //
    public Plane() {
        Q = new Point3D();
        normal = new Vector();
    }

    public Plane(Plane plane) {
        Q = plane.Q;
        normal = plane.normal;
    }

    public Plane(Vector _normal, Point3D _Q) {
        Q = new Point3D(_Q);
        normal = new Vector(_normal);
    }

    // ***************** Getters/Setters ********************** //
    public Vector getNormal(Point3D point) {
        return new Vector(normal);
    }

    public Point3D getQ() {
        return Q;
    }

    public void setNormal(Vector _normal) {
        normal = _normal;
    }

    public void setQ(Point3D d) {
        Q = d;
    }

    // ***************** Operations ******************** //
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> intersectionsPoint = new ArrayList<Point3D>(1);

        Point3D PO = ray.getPOO();
        Point3D QO = this.getQ();
        Vector N = this.getNormal(null);
        Vector V = ray.getDirection();

        Vector v = new Vector(QO, PO);
        double t = (N.dotProduct(v) * -1) / N.dotProduct(V);

        if (t >= 0) {
            V.scale(t);
            PO.add(V);
            intersectionsPoint.add(PO);

        }
        return intersectionsPoint;
    }
}



/*
public class Plane extends RadialGeometry{
	
	private Vector _normal;
	private Point3D _Q;
	private Color _emmission = new Color(0, 0, 0);
	
	// ***************** Constructors ********************** //
	
	public Plane() { 
		this._normal = new Vector(); this._Q = new Point3D();
		};
	
	public Plane (Plane plane ) { 
		this._normal = new Vector(plane._normal); this._Q = new Point3D(plane._Q); 
		};
	
	public Plane (Vector normal, Point3D q){ 
		this._normal = new Vector(normal); this._Q = new Point3D(q);
		};
	 
	// ***************** Getters/Setters ********************** //
	
	public Vector getNormal(Point3D point){	return _normal; };
	
	public Point3D getQ(){return _Q;};
	
	public void setNormal(Vector normal){
		this._normal = new Vector(_normal); 
		};
	
	public void setQ(Point3D d){
		this._Q = new Point3D(_Q);
		};
	
	public void setEmmission(Color emmission){this._emmission = new Color(_emmission.getRGB());};
	
	public Color get_emmission() {return _emmission;}
	
	// ***************** Operations ******************** //
	
	//The function returns a list of all the points of intersection with the plane
	
	@Override
	public List<Point3D> FindIntersections(Ray ray) {

		List<Point3D> _intersectionPointList=new ArrayList<>();
		
		Vector _temNormal = new Vector(_normal);
		
		_temNormal.scale(-1.0);
		
		Vector _P0_Q = new Vector(_Q,ray.getPOO());
		
		double _t = _temNormal.dotProduct(_P0_Q) / (double) (_normal.dotProduct(ray.getDirection()));
		if (_t >= 0) {
			
			Vector _tmp_v = new Vector(ray.getDirection());
			
			_tmp_v.scale(_t);
			
			Point3D _new_p=new Point3D(ray.getPOO());
			
			_new_p.add(_tmp_v);
			
			_intersectionPointList.add(_new_p);

		}

		return _intersectionPointList;
	}

	@Override
	public Color getEmmission() {
		return get_emmission();
	}



}
*/
