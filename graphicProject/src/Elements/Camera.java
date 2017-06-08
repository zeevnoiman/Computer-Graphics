package Elements;

import primitives.*;
/**
 * Created by daniel on 5/7/2017.
 */
public class Camera
{
    Point3D P0;
    Vector vUp;
    Vector vTo;
    Vector vRight;

    public Camera()
    {
        P0 = new Point3D(0 ,0, 0);
        vUp = new Vector(0, 1, 0);
        vTo = new Vector(0,0,-1);
        vRight = new Vector(1,0,0);
    }
    public Camera(Point3D _PO, Vector _vRight, Vector _vUp, Vector _vTo)
    {
        P0 = _PO;
        vUp = _vUp;
        vTo = _vTo;
        vRight = _vRight;
    }
//---------------getters and setters----------------------//
    public Point3D getP0() {
        return P0;
    }

    public void setP0(Point3D p0) {
        P0 = p0;
    }

    public Vector getvUp() {
        return vUp;
    }

    public void setvUp(Vector vUp) {
        this.vUp = vUp;
    }

    public Vector getvTo() {
        return vTo;
    }

    public void setvTo(Vector vTo) {
        this.vTo = vTo;
    }

    public Vector getvRight() {
        return vRight;
    }

    public void setvRight(Vector vRight) {
        this.vRight = vRight;
    }
//--------------------------functions------------------------//
    @Override
    public String toString() {
        return "Vto: " + vTo + "\n" + "Vup: " + vUp + "\n" + "Vright:" + vRight + ".";
    }

    public Ray constructRayThroughPixel (double Nx, double Ny, double x, double y, double screenDistance, double screenWidth, double screenHeight)
    {
        Vector _vTo1 = new Vector(vTo);
        Vector _vTo2 = new Vector(vTo);
        Vector _vRight = new Vector(vRight);
        Vector _vUp = new Vector(vUp);
        Point3D _PO = new Point3D(P0);

        _vTo1.scale(screenDistance);
        _PO.add(_vTo1);
        Point3D imageCenter = new Point3D(_PO);

        _vRight = _vTo2.crossProduct(_vUp);

        double ratioX = screenWidth/Nx;
        double ratioY = screenHeight/Ny;

        _vRight.scale(((x - (Nx/2)) * ratioX) + (ratioX/2));
        _vUp.scale(((y - (Ny/2)) * ratioY) + (ratioY/2));

        _vRight.scale(-1);
        _vUp.scale(-1);
        _vRight.subtract(_vUp);
        imageCenter.add(_vRight);

        Point3D target = new Point3D(imageCenter);

        return new Ray(new Vector(P0,target), new Point3D(target));

    }
}

/*
 * 
 * package Elements;

import primitives.*;

// camera class for describing all element of the camera such as location and its oriantation 

public class Camera {

	//the camera location and direction 
	private Point3D _P0;
	private Vector _vUp;
	private Vector _vTo;
	private Vector _vRight;

	// default constructors
	public Camera() {
		this._P0 = new Point3D();
		this._vUp = new Vector();
		this._vTo = new Vector();
		this._vRight = new Vector();
	}

	// copy constructor
	public Camera(Camera camera) {
		this._P0 = new Point3D(camera._P0);
		this._vUp = new Vector(camera._vUp);
		this._vTo = new Vector(camera._vTo);
		this._vRight = new Vector(this._vUp.crossProduct(_vTo));
	}

	// full constructor

	public Camera(Point3D P0, Vector vUp, Vector vTo) {
		this._P0 = new Point3D(P0);
		this._vUp = new Vector(vUp);
		this._vTo = new Vector(vTo);
		this._vRight = new Vector(this._vUp.crossProduct(_vTo));
	}

	// getter
	public Vector get_vUp() {
		return this._vUp;
	}

	public Point3D getP0() {
		return this._P0;
	}

	public Vector get_vRight() {
		return this._vRight;
	}

	public Vector get_vTo() {
		return this._vTo;
	}

	// setters
	public void set_vUp(Vector vUp) {
		this._vUp = new Vector(vUp);
		this._vRight = this._vUp.crossProduct(_vTo);
	}

	public void set_vTo(Vector vTo) {
		this._vTo = new Vector(vTo);
		this._vRight = this._vUp.crossProduct(_vTo);
	}

	public void setP0(Point3D P0) {
		this._P0 = new Point3D(P0);
	}

	// toString print the camera object
	@Override
	public String toString() {
		return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + ".";
	}

	// operations

	// construct ray through pixel
	public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDist, double screenWidth,
			double screenHeight) {

		// copy the class members to new variables to avoid changes in the current class members

		Vector vUp = new Vector(this._vUp);
		Vector vRight = new Vector(this._vRight);

		// calculate ratio pixel width as Rx and ratio pixel height as Ry
		double Rx = screenWidth / (double) Nx;
		double Ry = screenHeight / (double) Ny;

		// calculate the distance that we need to move from Pc, A is right/left
		// and B is toward or back
		double A = ((x - (Nx / (double) 2)) * Rx) + (Rx / (double) 2);
		double B = ((y - (Ny / (double) 2)) * Ry) + (Ry / (double) 2);

		// calculate Pc
		Point3D tmpP = new Point3D(this._P0);
		Vector tmpV = new Vector(this._vTo);
		tmpV.scale(screenDist);
		tmpP.add(tmpV);
		Point3D Pc = new Point3D(tmpP);

		// calculate A*vRight into vRight and B*vUp into vUp
		vRight.scale(A);
		vUp.scale(B);

		// calculate vRight - vUp into vRight
		vRight.subtract(vUp);

		// calculate P, the point in the view plan the the ray pass there.
		Pc.add(vRight);
		Point3D P = new Point3D(Pc);

		// calculate the direction of the ray P-P0
		Point3D tmp = new Point3D(P);
		tmpV = new Vector(this._P0);
		tmp.subtract(tmpV);
		Vector direction = new Vector(tmp);

		// the final calculate- the ray.
		return new Ray(direction, P);
	}

	public Ray constructRayThroughPixel(double nX, double nY, int j, int i, double screenDistance, int width,
			int height) {
		// TODO Auto-generated method stub
		return null;
	}
}
*/
