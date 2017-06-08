package primitives;



public  class Point2D implements Comparable<Point2D> {
	
	protected Coordinate _x;	// coordinate on axis X
	protected Coordinate _y;	// coordinate on axis Y 
	
	// ***************** Constructors ********************** //
	
	public Point2D() {
		_x = new Coordinate();
		_y = new Coordinate();
	}
	

	public Point2D(Coordinate x, Coordinate y) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
	}
	public Point2D(Point2D point2D) {
		this(point2D._x,point2D._y);
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Coordinate getX() {
		return new Coordinate(_x);
	}
	public Coordinate getY() {
		return new Coordinate(_y);
		
	}
	public void setX(Coordinate x) {
		//_x =new Coordinate(x) ;
		_x.setCoordinate(x.getCoordinate());
	}
	public void setY(Coordinate y) {
		//_y = new Coordinate(y) ;
		_y.setCoordinate(y.getCoordinate());
	}
	
	// ***************** Administration ******************** //
	
	@Override
	public int compareTo(Point2D point2D) {
		if (_x.compareTo(point2D._x) == 0) {
			return _y.compareTo(point2D._y);
		} 
		return 1;		
	}
}
