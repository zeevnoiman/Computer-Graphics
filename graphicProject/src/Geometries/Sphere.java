package Geometries;

import primitives.*;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import primitives.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 * Created by daniel on 3/22/2017.
 */
public class Sphere extends RadialGeometry {
    private Point3D center;

    // ***************** Constructors ********************** //
    public Sphere()
    {
        super();
        center = new Point3D();
    }
    public Sphere (Sphere sphere)
    {
        super(sphere.getRadius());
        center = sphere.getCenter();
    }
    public Sphere(double radius, Point3D center)
    {
        super(radius);
        this.center = new Point3D();
        this.setCenter(center);

    }
    public Sphere(Map<String, String> attributes)
    {

    }

    // ***************** Getters/Setters ********************** //
    public Point3D getCenter()
    {
        return new Point3D(center);
    }
    public void setCenter(Point3D center) {
        this.center.setP1(center.getP1());
        this.center.setP2(center.getP2());
        this.center.setP3(center.getP3());
    }

    // ***************** Operations ******************** //
    public List<Point3D> FindIntersections(Ray ray)
    {
        List<Point3D> intersectionsPoint = new ArrayList<Point3D>(1);

        Point3D PO1 = new Point3D(ray.getPOO());
        Point3D PO2 = new Point3D(ray.getPOO());
        Vector direction1 = new Vector(ray.getDirection());
        Vector direction2 = new Vector(ray.getDirection());
        Vector L = new Vector(PO1, center);
        double tm = L.dotProduct(direction1);
        double d = Math.sqrt(Math.pow(L.length(),2) - Math.pow(tm, 2));

        double th = Math.sqrt(Math.pow(super.getRadius(),2) - Math.pow(d,2));
        double t1 = tm - th;
        double t2 = tm + th;

        if (t1 > 0) {
            direction1.scale(t1);
            PO1.add(direction1);
            intersectionsPoint.add(PO1);
        }
        if (t2 > 0)
        {
            direction2.scale(t2);
            PO2.add(direction2);
            intersectionsPoint.add(PO2);
        }
        return intersectionsPoint;
    }

}

/*
public class Sphere extends RadialGeometry {
	
	private Point3D _center;
	private Color _emmission = new Color(0, 0, 0);
	
	// ***************** Constructors ********************** //
	
	public Sphere(){ super(); this._center = new Point3D();};
	
	public Sphere (Sphere sphere){super(sphere._radius); this._center = new Point3D(sphere._center);};
	
	public Sphere(double radius, Point3D center){super(radius); this._center = new Point3D(center);};
	
	public Sphere(Map<String, String> attributes){};
	
	// ***************** Getters/Setters ********************** //
	
	public Point3D getCenter(){return _center;};
	
	public void setCenter(Point3D center){this._center = new Point3D(_center);};
	
	public void setEmmission(Color emmission){this._emmission = new Color(_emmission.getRGB());};
	
	public Color get_emmission() {return _emmission;}
	
	// ***************** Operations ******************** //
	
	//The function returns a list of all the points of intersection b the sphere
	
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
	
		List<Point3D> _intersectionPointList = new ArrayList<Point3D>(1);
		Vector _l = new Vector(ray.getPOO(), _center);
		double _tm = _l.dotProduct(ray.getDirection());
		double _d = Math.sqrt(Math.pow(_l.length(), 2) - Math.pow(_tm, 2));
	
		if (_d > _radius)
			return _intersectionPointList;
	
		double _th = Math.sqrt(Math.pow(_radius, 2) - Math.pow(_d, 2));
		double _t1 = _tm - _th;
		double _t2 = _tm + _th;
	
		if (_t1 > 0) {
			Vector _tmp_v = new Vector(ray.getDirection());
			_tmp_v.scale(_t1);
			Point3D _p1 = new Point3D(ray.getPOO());
			_p1.add(_tmp_v);
			_intersectionPointList.add(_p1);
		}
		
			if (_t2 > 0) {
				Vector _tmp_v2 = new Vector(ray.getDirection());
				_tmp_v2.scale(_t2);
				Point3D _p2 = new Point3D(ray.getPOO());
				_p2.add(_tmp_v2);
				_intersectionPointList.add(_p2);
			}
		
		return _intersectionPointList;
	
	}
	
	//The function returns the normal of the sphere
	@Override
	public Vector getNormal(Point3D point) {
		Vector _normal = new Vector(_center, point);
		_normal.normalize();
		return _normal;
		}

	@Override
	public Color getEmmission() {
		return get_emmission();
	}

}
*/