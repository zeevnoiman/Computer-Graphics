package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import primitives.*;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by daniel on 3/22/2017.
 */
public class Triangle implements Geometry{
    private Point3D p1;
    private Point3D p2;
    private Point3D p3;

    // ***************** Constructors ********************** //
    public Triangle()
    {
        p1 = new Point3D();
        p2 = new Point3D();
        p3 = new Point3D();
    }
    public Triangle(Triangle triangle)
    {
        p1 = triangle.getP1();
        p2 = triangle.getP2();
        p3 = triangle.getP3();
    }
    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3)
    {
       p1 = new Point3D(_p1);
       p2 = new Point3D(_p2);
       p3 = new Point3D(_p3);
    }

    // ***************** Getters/Setters ********************** //

    public Point3D getP1()
    {
        return new Point3D(p1);
    }
    public Point3D getP2()
    {
        return new Point3D(p2);
    }
    public Point3D getP3()
    {
        return new Point3D(p3);
    }

    public void setP1(Point3D p1) {
        this.p1.setP1(p1.getP1());
        this.p1.setP2(p1.getP2());
        this.p1.setP3(p1.getP3());
    }

    public void setP3(Point3D p3) {
        this.p3.setP1(p3.getP1());
        this.p3.setP2(p3.getP2());
        this.p3.setP3(p3.getP3());
    }


    public void setP2(Point3D p2) {
        this.p2.setP1(p2.getP1());
        this.p2.setP2(p2.getP2());
        this.p2.setP3(p2.getP3());
    }
    // ***************** Operations ******************** //
    public Vector getNormal()
    {
        Vector U = new Vector(p1, p2);
        Vector V = new Vector(p1, p3);
        V.crossProduct(U);
        Vector N = new Vector(V);

        N.normalize();
        N.scale(-1);

        return N;

    }
    public List<Point3D> FindIntersections(Ray ray)
    {
        Vector P1toP2 = new Vector(p1, p2);
        Vector P1toP3 = new Vector(p1,p3);
        Vector normalTriangle = P1toP2.crossProduct(P1toP3);

        normalTriangle.normalize();

        Plane planeTriangle = new Plane(normalTriangle, this.getP3());

        List<Point3D> planeTrianglePoint = planeTriangle.FindIntersections(ray);

        if(planeTrianglePoint.isEmpty() == true)
        {
            return new ArrayList<>(0);
        }

        Point3D P = planeTrianglePoint.get(0);

        Vector V1 = new Vector(ray.getPOO(), p1);
        Vector V2 = new Vector(ray.getPOO(), p2);
        Vector V22 = new Vector(ray.getPOO(), p2);
        Vector V3 = new Vector(ray.getPOO(), p3);


        Vector N1 = V2.crossProduct(V1);
        N1.normalize();

        Vector N2 = V1.crossProduct(V3);
        N2.normalize();

        Vector N3 = V3.crossProduct(V22);
        N3.normalize();

        //   P - P0
        Vector PoToP = new Vector(ray.getPOO(), P);

        if(Math.signum(PoToP.dotProduct(N1)) == Math.signum(PoToP.dotProduct(N2)) &&
                Math.signum(PoToP.dotProduct(N2)) == Math.signum(PoToP.dotProduct(N3)))
        {
            System.out.printf("sababa  \n");
            return planeTrianglePoint;
        }
        else
        {
            return new ArrayList<>(0);   //   as an empty list
        }
    }

}


/*

public class Triangle extends RadialGeometry{

	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;
	private Color _emmission = new Color(0, 0, 0);

	// Default cons
	public Triangle() {
		this._p1 = new Point3D();
		this._p2 = new Point3D();
		this._p3 = new Point3D();
	}

	// copy cons
	public Triangle(Triangle triangle) {
		this._p1 = new Point3D(triangle._p1);
		this._p2 = new Point3D(triangle._p2);
		this._p3 = new Point3D(triangle._p3);
	}

	// full cons
	public Triangle(Point3D p1, Point3D p2, Point3D p3) {
		this._p1 = new Point3D(p1);
		this._p2 = new Point3D(p2);
		this._p3 = new Point3D(p3);
	}

	// getters
	
    
	public Color get_emmission() {
		return _emmission;}
	
	public Point3D get_p1() {
		return _p1;
	}

	public Point3D get_p2() {
		return _p2;
	}

	public Point3D get_p3() {
		return _p3;
	}

	// setters
	
	public void setEmmission(Color emmission){
		this._emmission = new Color(_emmission.getRGB());
	}
	
	public void set_p1(Point3D _p1) {
		this._p1 = new Point3D(_p1);
	}

	public void set_p2(Point3D _p2) {
		this._p2 = new Point3D(_p2);
	}

	public void set_p3(Point3D _p3) {
		this._p3 = new Point3D(_p3);
	}

	//The function returns a list of all the points of intersection with the triangle
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		
		List<Point3D> _intersectionPointList=new ArrayList<>();
		Plane _plane=new Plane(getNormal(_p3),_p3);
		_intersectionPointList=_plane.FindIntersections(ray);
		if(_intersectionPointList.size()==0)
			return _intersectionPointList;
		
		Vector _p0_p=new Vector(ray.getPOO(),_intersectionPointList.get(0));
		
		Vector _v1=new Vector(ray.getPOO(),_p1);
		Vector _v2=new Vector(ray.getPOO(),_p2);
		Vector _v3=new Vector(ray.getPOO(),_p3);
		
		Vector _normal1=_v1.crossProduct(_v2);
		Vector _normal2=_v2.crossProduct(_v3);
		Vector _normal3=_v3.crossProduct(_v1);
		
		_normal1.normalize();
		_normal2.normalize();
		_normal3.normalize();
		
		
		_normal1.scale(-1.0);
		_normal2.scale(-1.0);
		_normal3.scale(-1.0);
		
		
		double s1=_normal1.dotProduct(_p0_p);
		double s2=_normal2.dotProduct(_p0_p);
		double s3=_normal3.dotProduct(_p0_p);
		
		if(s1>0 && s2>0 && s3>0 || s1<0 && s2<0 && s3<0)
		return _intersectionPointList;
		
		
		_intersectionPointList.remove(0);
		return _intersectionPointList; 
	}

	//The function return the normal of the triangle
	@Override
	public Vector getNormal(Point3D point) {
		
		Vector _p1_p2=new Vector(_p1,_p2);
		Vector _p1_p3=new Vector(_p1,_p3);
		
		Vector _normal=new Vector(_p1_p2.crossProduct(_p1_p3));
		_normal.normalize();
		_normal.scale(-1);
		return _normal;
	}

	@Override
	public Color getEmmission() {
		return get_emmission();
	}
	
	public int compareTo(Triangle triangle)
	{
		if (Math.abs((triangle.get_p1().compareTo(this._p1) )* (triangle.get_p2().compareTo(this._p2) ) *(triangle.get_p3().compareTo(this._p3) )) <= 0.0001)
		return 0;
		else
		return -1;
	}
	
}

*/
