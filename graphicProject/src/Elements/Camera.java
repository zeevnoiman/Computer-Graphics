package Elements;
import primitives.*;

public class Camera {
	private Point3D _P0;
	private Vector _vUp;
	private Vector _vTo;
	 // calculated as the cross product of vUp and vTo
	private Vector _vRight;
	
	// ***************** Constructors ********************** //
	public Camera(){
		_P0 = new Point3D();
		_vRight = new Vector(1.0,0.0,0.0);
		_vUp = new Vector(0.0,1.0,0.0);
		_vTo = new Vector(0.0,0.0,-1.0);
	
		
	}
	public Camera (Camera camera){
		this(camera._P0,camera._vUp,camera._vTo);
	}
	public Camera (Point3D P0, Vector vUp, Vector vTo){
		_P0 = new Point3D(P0);
		_vUp = new Vector(vUp);
		_vTo = new Vector(vTo);
		_vRight = vTo.crossProduct(vUp);
		_vRight.normalize();
		_vTo.normalize();
		_vUp.normalize();
	}
//	public Camera (Map<String, String> attributes(;

	// ***************** Getters/Setters ********************** //
	public Vector get_vUp(){
		return new Vector(_vUp);
	}
	public void  set_vUp(Vector vUp){
		_vUp.setHead(vUp.getHead());
	}
	public Vector get_vTo(){
		return new Vector(_vTo);
	}
	public void set_vTo(Vector vTo){
		_vTo.setHead(vTo.getHead());
	}
	public Vector get_vRight(){
		return new Vector(_vRight);
	}
	public Point3D getP0(){
		return _P0;
	}
	public void setP0(Point3D P0){
		_P0.setPoint(P0);
	}
	
	// ***************** Administration ********************** //
	@Override
	public String toString(){
		return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + "."; 
	}
	// ***************** Operations ******************** //


	public Ray constructRayThroughPixel (int Nx, int Ny,
			 double x, double y,
			 double screenDist,
			 double screenWidth,
			 double screenHeight){
			
				Point3D Pc = pcCalc(screenDist);
				Vector vX = new Vector(pixelCalc(Nx, x, screenWidth),0,0);
				Vector vY = new Vector(0,pixelCalc(Ny, y, screenHeight),0);
				
				vX.subtract(vY);
				Pc.add(vX);			// P = Pc
				Vector vector = new Vector(Pc);
				return new Ray(Pc, vector);
				
			}

			private double pixelCalc(int N, double cPoint, double sLengh) {
				cPoint -= N/2.0;					// center point of the pixel = end point of the pixel - (#pixel / 2)
				double R = sLengh / N;				// R = screen length / NO' of pixels => W/#pixel_x for example 
				return  (R * cPoint) + (R / 2.0);	// (calculate the length from Pc to P on the screen) + of the length of the pixel => bring P to the middle of the correct pixel 	
			}
			private Point3D pcCalc(double screenDist) {
				Point3D p0 = new Point3D(_P0);
				//Vector vTo = new Vector(_vTo); 
				//vTo.scale(screenDist);
				Vector vTo = new Vector(0,0,-screenDist); 	// scalar product with _vTo (z-axis). it negative. 
				p0.add(vTo); 								// Pc = p0 + t*_vTo
				return new Point3D(p0); 					// return Pc
			}
}
