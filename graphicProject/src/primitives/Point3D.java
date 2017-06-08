package primitives;

/**
 * Created by daniel on 3/22/2017.
 */
public class Point3D extends Point2 {
    private Coordinate p3;

    //****************constructors*********************//
    public Point3D()
    {
        super();
        p3 = new Coordinate(0);
    }
    public Point3D(Coordinate _p1, Coordinate _p2, Coordinate _p3) {
        super(_p1, _p2);
        p3 = new Coordinate(_p3);
    }
    public Point3D(double x, double y, double z)
    {
        super(x, y);
        p3 = new Coordinate(z);
    }
    public Point3D(Point3D point3D)
    {
        super(point3D.getP1(), point3D.getP2());
     //   p1 = new Coordinate(Point3D.super.getP1());
      //  p2 = new Coordinate(Point3D.super.getP2());
        p3 = new Coordinate(point3D.getP3());
    }

    //********************getter and setter*********************//
    public Coordinate getP3()
    {
        return new Coordinate(p3);
    }

    public void setP3(Coordinate _p3)
    {
        this.p3.setCoordinate(_p3.getCoordinate());
    }

    // ***************** Administration ******************** //

    @Override
    public String toString() {
        return "Point3D: (" +
                "x = " + p1.getCoordinate()+ ", y =  " + p2.getCoordinate() + ", z = " + p3.getCoordinate() +
                ')';
    }

    @Override
    public int compareTo(Point3D _point3D)
    {
        if (_point3D == null)
            throw new NullPointerException();

        double size1 = Math.sqrt(Math.pow(p1.getCoordinate(),2) + Math.pow(p2.getCoordinate(),2) + Math.pow(p3.getCoordinate(),2));
        double size2 = Math.sqrt(Math.pow(_point3D.p1.getCoordinate(),2) + Math.pow(_point3D.p2.getCoordinate(),2) + Math.pow(_point3D.p3.getCoordinate(),2));

        if (size1 > size2)
            return 1;
        if (size1 < size2)
            return -1;
        if (size1 == size2)
            return 0;

        return -123;

    }


    // ***************** Operations ******************** //

    public void add(Vector vector)
    {
        this.p1.add(vector.get_head().getP1());
        this.p2.add(vector.get_head().getP2());
        this.p3.add(vector.get_head().getP3());
    }
    public void subtract(Vector vector)
    {
        this.p1.subtract(vector.get_head().getP1());
        this.p2.subtract(vector.get_head().getP2());
        this.p3.subtract(vector.get_head().getP3());
    }
    public double distance(Point3D point)
    {
        double x = point.p1.getCoordinate() - this.p1.getCoordinate();
        double y = point.p2.getCoordinate() - this.p2.getCoordinate();
        double z = point.p3.getCoordinate() - this.p3.getCoordinate();

        double dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));

        return dist;
    }
}



