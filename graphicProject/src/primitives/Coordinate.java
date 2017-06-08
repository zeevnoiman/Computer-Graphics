package primitives;


 

public  class Coordinate implements Comparable<Coordinate>{
	
	
	private double _coordinate;
	
	
	// ***************** Constructors ********************** //
	
	public Coordinate() {
		_coordinate = 0.0;
	}
	public Coordinate(double coordinate) {
		_coordinate = coordinate;
	}
	public Coordinate(Coordinate coordinate){
		_coordinate = coordinate._coordinate;
	}

	// ***************** Getters/Setters ********************** //
	public double getCoordinate() {
		return _coordinate;
	}
	public void setCoordinate(double coordinate){
		_coordinate = coordinate;
	}
	
	// ***************** Administration ******************** //
	@Override
	public int compareTo(Coordinate coordinate){
		
		double ab = Math.abs(_coordinate - coordinate.getCoordinate());
		if (ab > 1e-10) {
			return 1;
		}
		return 0;
		
	}
	
	
	// ***************** Operations ******************** //

	public void add (Coordinate coordinate){
		_coordinate += coordinate.getCoordinate();
	}
	

	public void subtract (Coordinate coordinate){
		_coordinate -= coordinate.getCoordinate();		
	}
	
	
}
