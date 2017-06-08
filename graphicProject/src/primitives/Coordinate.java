package primitives;

/**
 * Created by daniel on 3/21/2017.
 */
public class Coordinate implements Comparable<Coordinate> {

    private double coordinate;
    //*************** Constructors*************************//
    public Coordinate(double _coordinate)
    {
        this.coordinate = _coordinate;
    }
    public Coordinate()
    {
        coordinate = 0;
    }
    public Coordinate(Coordinate _coordinate)
    {
        this.coordinate = _coordinate.coordinate;
    }

    //***************** Getter and Setter**********************************
    public double getCoordinate() {
        return coordinate;
    }


    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    // ***************** Operations ******************** //
    public int compareTo(Coordinate _coordinate)
    {
        if (_coordinate == null)
            throw new NullPointerException();

        if (_coordinate.coordinate < this.coordinate)
            return 1;
        if (_coordinate.coordinate > this.coordinate)
            return -1;
        if (_coordinate.coordinate == this.coordinate)
            return 0;

        return -123;
    }

    public void add (Coordinate _coordinate)
    {
        this.coordinate = _coordinate.coordinate + this.coordinate;

    }
    public void subtract (Coordinate _coordinate)
    {
        this.coordinate = this.coordinate - _coordinate.coordinate;

    }

}

