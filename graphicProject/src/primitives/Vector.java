package primitives;


public class Vector implements Comparable<Vector> {
	

	
	private Point3D _head;
	
	// ***************** Constructors ********************** //
	
	public Vector() {
		_head = new Point3D();
		
	}
	public Vector(Point3D head) {
		_head = new Point3D(head);
	}
	

	public Vector(Vector vector) {
		this(vector._head);
	}
	
	public Vector(double xHead, double yHead, double zHead) {
		_head = new Point3D(xHead,yHead,zHead);
	}
	

	public Vector(Point3D p1, Point3D p2) { 

		_head = new Point3D(p2);
		Point3D point3d = new Point3D(p1);
		point3d.subtract(this);
		_head.setPoint(point3d);
	
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Point3D getHead() {
		return new Point3D(_head);
	}
	// Getters for the coordinates of the vector head
	public double getX() {
		return _head._x.getCoordinate();
	}
	public double getY() {
		return _head._y.getCoordinate();
	}
	public double getZ() {
		return _head._z.getCoordinate();
	}
	
	public void setHead(Point3D head) {

		_head.setPoint(head);
	}

	// ***************** Administration ******************** //
	@Override
	public int compareTo(Vector vector){  
		return _head.compareTo(vector._head);
	}
	
	@Override
	public String toString() {
		return _head.toString();
	}
	
	// ***************** Operations ******************** //
	
	
	public void add (Vector vector ){
		_head.add(vector);
	}

	public void subtract (Vector vector){
		_head.subtract(vector);
	}

	public void scale(double scalingFactor) {
		_head._x.setCoordinate(scalingFactor * getX() ); 
		_head._y.setCoordinate(scalingFactor * getY() ); 
		_head._z.setCoordinate(scalingFactor * getZ() ); 
	}

	public Vector crossProduct(Vector vector){
		double x = ( (getY() * vector.getZ()) - (getZ() * vector.getY()) );		
		double y = ( (getZ() * vector.getX()) - (getX() * vector.getZ()) );	
		double z = ( (getX() * vector.getY()) - (getY() * vector.getX()) );
		return new Vector(x,y,z);
	}

	
	public double length(){
		return Math.sqrt(Math.pow(getX(),2)
				+ Math.pow(getY(),2)
				+ Math.pow(getZ(),2));
	}

	
	public void normalize() {	
		if (length() == 0) {
<<<<<<< HEAD
			return;
			//throw new ArithmeticException("Can't devide in zero");
=======
			
			
			throw new ArithmeticException("Can't devide in zero - i'm vector class");
>>>>>>> 8e4289348374df1ea6dc6cb786555ddb2392d125
		}
		double len = length();
		_head._x.setCoordinate(getX() / len);
		_head._y.setCoordinate(getY() / len);
		_head._z.setCoordinate(getZ() / len);
	}

	
	public double dotProduct(Vector vector){
		return (  getX() * vector.getX()
				+ getY() * vector.getY()
				+ getZ() * vector.getZ() );
	}
	
}
