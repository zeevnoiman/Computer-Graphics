package Geometries;


import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 3/22/2017.
 */
public class Cylinder extends RadialGeometry{
    private Point3D axisPoint;
    private Vector axisDirection;

    // ***************** Constructors ********************** //
    public Cylinder()
    {
        super();
        axisPoint = new Point3D();
        axisDirection = new Vector();
    }
    public Cylinder(Cylinder cylinder)
    {
        super(cylinder.getRadius());
        axisDirection = cylinder.getAxisDirection();
        axisPoint = cylinder.getAxisPoint();
    }
    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection)
    {
        super(radius);
        this.axisPoint = new Point3D();
        this.axisDirection = new Vector();

        this.setAxisPoint(axisPoint);
        this.setAxisDirection(axisDirection);
    }
// ***************** Getters/Setters ********************** //

    public Point3D getAxisPoint()
    {
        return new Point3D(axisPoint);
    }

    public Vector getAxisDirection()
    {
        return new Vector(axisDirection);
    }

    public void setAxisPoint(Point3D axisPoint) {
        this.axisPoint.setP1(axisPoint.getP1());
        this.axisPoint.setP2(axisPoint.getP2());
        this.axisPoint.setP3(axisPoint.getP3());
    }

    public void setAxisDirection(Vector axisDirection)
    {
        this.axisDirection.set_head(axisDirection.get_head());
    }

    @Override
	public List<Point3D> FindIntersections(Ray ray) {
		
		List<Point3D> _intersectionPointList = new ArrayList<Point3D>();
		Vector _l = new Vector(ray.getPOO(), axisPoint);
		double _tm = _l.dotProduct(ray.getDirection());
		double _d = Math.sqrt(Math.pow(_l.length(), 2) - Math.pow(_tm, 2));
	
		if (_d > radius)
			return _intersectionPointList;
	
		double _th = Math.sqrt(Math.pow(radius, 2) - Math.pow(_d, 2));
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

	
	public Vector getNormal(Point3D point) {
		Vector _normal = new Vector(axisPoint, point);
		_normal.normalize();
		return _normal;
	}

	
	public Color getEmmission() {
		return getEmmission();
	}
    // ***************** Operations ******************** //
 /*
    public List<Point3D> FindIntersections(Ray ray)
    {

    }
    public Vector getNormal(Point3D point)
    {

    }
*/
}








/*
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.*;

//cylinder class is a geometry that has an axis point and a radius and direction 

public class Cylinder extends RadialGeometry {

	
	private Point3D _axisPoint;
	private Vector _axisDirection;
	private Color _emmission = new Color(0, 0, 0);
	
	// ***************** Constructors ********************** //
	
	public Cylinder(){this._axisPoint = new Point3D(); this._axisDirection = new Vector(); };
	
	public Cylinder(Cylinder cylinder) { super(cylinder._radius); this._axisDirection = cylinder._axisDirection; this._axisPoint = cylinder._axisPoint;};
	
	public Cylinder(double radius, Point3D axisPoint, Vector axisDirection) { super(radius); this._axisDirection = new Vector(axisDirection); this._axisPoint = new Point3D(axisPoint);};
	
	
	// ***************** Getters/Setters ********************** //
	
	public Point3D getAxisPoint(){return _axisPoint; };
	
	public Vector getAxisDirection(){return _axisDirection; };
	
	public void setAxisPoint(Point3D axisPoint){this._axisPoint = new Point3D(_axisPoint); };
	
	public void setAxisDirection(Vector axisDirection){this._axisDirection = new Vector(_axisDirection); };
	
	public void setEmmission(Color emmission){this._emmission = new Color(_emmission.getRGB());};
	
	public Color get_emmission() {return _emmission;}
	
	
	// ***************** Operations ******************** //
	
	// ***************** Not sure if works... ******************** //
	
	
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		
		List<Point3D> _intersectionPointList = new ArrayList<Point3D>();
		Vector _l = new Vector(ray.getPOO(), _axisPoint);
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

	@Override
	public Vector getNormal(Point3D point) {
		Vector _normal = new Vector(_axisPoint, point);
		_normal.normalize();
		return _normal;
	}

	@Override
	public Color getEmmission() {
		return get_emmission();
	}

}
*/