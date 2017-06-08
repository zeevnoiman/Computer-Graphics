package primitives;


public class Ray {
	//POO =  Point Of Origin
	private Point3D _POO;
	
	// Ray direction
	private Vector _direction;
	
	
	// ***************** Constructors ********************** //
	
	public Ray(){
		
		this(new Point3D(), new Vector());
		_direction.normalize();
	}
	
	public Ray(Ray ray){
		/*_POO = new Point3D(ray._POO);
		_direction = new Vector(ray._direction);*/
		
		this(ray._POO, ray._direction);		
	}
	
	public Ray(Point3D poo, Vector direction){
		_POO = new Point3D(poo);
		
		_direction = new Vector(direction);
		_direction.normalize();
		
	}
	// ***************** Getters/Setters ********************** //
	
	public void setPOO(Point3D _POO){
		_POO.setPoint(_POO);
	}
	public void setDirection(Vector direction){
		_direction.setHead(direction.getHead());
	}

	public Vector getDirection(){
		_direction.normalize();
		return new Vector(_direction);
	}
	public Point3D getPOO(){
		return new Point3D(_POO);
	}

}
