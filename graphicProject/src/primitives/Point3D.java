package primitives;


public class Point3D extends Point2D {
	
	protected Coordinate _z;	// coordinate on axis Z
	
	// ***************** Constructors ********************** //
	
	public Point3D() {
		super();
		_z = new Coordinate();
	}
	
	public Point3D(double x, double y, double z){
		_x = new Coordinate(x);
		_y = new Coordinate(y);
		_z = new Coordinate(z);
		
	}
	
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super(x, y);
		_z = new Coordinate(z);
	}
	
	public Point3D(Point3D point3D) {
		this(point3D._x,point3D._y,point3D._z);
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Coordinate getZ() {
		return new Coordinate(_z);
	}
	
	public void setZ(Coordinate z) {
		
		_z.setCoordinate(z.getCoordinate());
	}
	
	public void setPoint(Point3D point) {
		setX(point._x);
		setY(point._y);
		setZ(point._z);
	}
	
	// ***************** Administration ******************** //
	
	@Override
	public int compareTo(Point2D point3D) {
		if (point3D instanceof Point3D) {
			if (_x.compareTo(point3D._x) == 0 && _y.compareTo(point3D._y) == 0) {              
				return _z.compareTo( ((Point3D)point3D)._z );
			}
			else return 1;
		}
		throw new IllegalAccessError("Try Again");  
	}
	
	@Override
	public String toString() {
		return String.format("(%.2f, %.2f, %.2f)", _x.getCoordinate(), _y.getCoordinate(), _z.getCoordinate());
	}
	
	// ***************** Operations ******************** //

	public void add(Vector vector){
		
		_x.add(vector.getHead()._x);
		_y.add(vector.getHead()._y);
		_z.add(vector.getHead()._z);

	}
	
	public void subtract(Vector vector) {
		
		_x.subtract(vector.getHead()._x);
		_y.subtract(vector.getHead()._y);
		_z.subtract(vector.getHead()._z);
		
	}
	

	public double distance(Point3D point)	{
		return Math.sqrt( Math.pow((_x.getCoordinate() - point._x.getCoordinate()),2)
				+ Math.pow((_y.getCoordinate() - point._y.getCoordinate()),2)
				+ Math.pow((_z.getCoordinate() - point._z.getCoordinate()),2) );					
	}
}
