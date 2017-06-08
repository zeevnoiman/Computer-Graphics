package primitives;

/**
 * Created by daniel on 3/22/2017.
 */
public class Vector implements Comparable<Vector> {

    private Point3D head;

    //***********************Constructors**************************//
    public Vector(Point3D _head)
    {
        head = new Point3D(_head.getP1(), _head.getP2(), _head.getP3());
    }
    public Vector()
    {
        head = new Point3D();
    }
    public Vector(Vector vector)
    {
        head = new Point3D(vector.get_head().getP1(), vector.get_head().getP2(), vector.get_head().getP3());
    }
    public Vector(double xHead, double yHead, double zHead)
    {
        head = new Point3D(xHead, yHead, zHead);
    }
    public Vector(Point3D p1, Point3D p2)
    {
        double x = p2.getP1().getCoordinate() - p1.getP1().getCoordinate();
        double y = p2.getP2().getCoordinate() - p1.getP2().getCoordinate();
        double z = p2.getP3().getCoordinate() - p1.getP3().getCoordinate();


        head = new Point3D(x, y, z);

    }

    //***********************Getters and Setters
    public Point3D get_head() {
        return new Point3D(head);
    }
    public void set_head(Point3D _head) {
        this.head = _head;
    }

    // ***************** Administration ******************** //


    @Override
    public int compareTo(Vector _head)

    {
        return this.head.compareTo(_head.head);
    }

    @Override
    public String toString()
    {
        return "Vector = " +
                head.toString();
    }

    // ***************** Operations ******************** //
    public void add (Vector vector )
    {
       this.head.add(vector);

    }
    public void subtract (Vector vector)
    {
      this.head.subtract(vector);
    }
    public void scale(double scalingFactor)
    {
        double x = this.head.getP1().getCoordinate() * scalingFactor;
        double y = this.head.getP2().getCoordinate() * scalingFactor;
        double z = this.head.getP3().getCoordinate() * scalingFactor;

        this.head.setP1(new Coordinate(x));
        this.head.setP2(new Coordinate(y));
        this.head.setP3(new Coordinate(z));

    }
    public Vector crossProduct(Vector vector)
    {
        Coordinate x ,y, z;
        double _x, _y, _z;
        _x = (this.head.getP2().getCoordinate() * vector.head.getP3().getCoordinate()) - (vector.head.getP2().getCoordinate() * this.head.getP3().getCoordinate());
        _y = (this.head.getP1().getCoordinate() * vector.head.getP3().getCoordinate()) - (vector.head.getP1().getCoordinate() * this.head.getP3().getCoordinate());
        _z = (this.head.getP1().getCoordinate() * vector.head.getP2().getCoordinate()) - (vector.head.getP1().getCoordinate() * this.head.getP2().getCoordinate());

        x = new Coordinate(_x);
        y = new Coordinate(_y);
        z = new Coordinate(_z);

        this.head.setP1(x);
        this.head.setP2(y);
        this.head.setP3(z);

        return this;
    }
    public double length()
    {
        double size = Math.sqrt(Math.pow(this.head.getP1().getCoordinate(),2) + Math.pow(this.head.getP2().getCoordinate(),2) + Math.pow(this.head.getP3().getCoordinate(),2));
        return size;
    }
    public void normalize() // Throws exception if length = 0
    {
        if (this.length() == 0)
            throw new ArithmeticException();
        double x, y, z;
        x = this.head.getP1().getCoordinate()/this.length();
        y = this.head.getP2().getCoordinate()/this.length();
        z = this.head.getP3().getCoordinate()/this.length();

        this.head.setP1(new Coordinate(x));
        this.head.setP2(new Coordinate(y));
        this.head.setP3(new Coordinate(z));
    }
    public double dotProduct(Vector vector)
    {
        double x = this.head.getP1().getCoordinate() * vector.head.getP1().getCoordinate();
        double y = this.head.getP2().getCoordinate() * vector.head.getP2().getCoordinate();
        double z = this.head.getP3().getCoordinate() * vector.head.getP3().getCoordinate();

        return x + y + z;
    }
}


