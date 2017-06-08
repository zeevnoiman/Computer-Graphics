package primitives;

/**
 * Created by daniel on 3/21/2017.
 */
public abstract class Point2 implements Comparable<Point2>{
    protected Coordinate p1;
    protected Coordinate p2;

    //*******************constructors************************//
    public Point2(Coordinate _p1, Coordinate _p2)
    {
        p1 = new Coordinate(_p1);
        p2 = new Coordinate(_p2);
    }

    public Point2()
    {
    p1 = new Coordinate();
    p2 = new Coordinate();
    }
    public Point2(Point2 _point2D)
    {
        p1 = new Coordinate(_point2D.getP1());
        p2 = new Coordinate(_point2D.getP2());
    }
    public Point2(double x, double y)
    {
        p1 = new Coordinate(x);
        p2 = new Coordinate(y);

    }


    // ***************** Getters/Setters ********************** //
    public Coordinate getP1() {
        return new Coordinate(p1);
    }

    public void setP1(Coordinate _p1)
    {
        p1.setCoordinate(_p1.getCoordinate());
    }

    public Coordinate getP2() {
        return new Coordinate(p2);
    }

    public void setP2(Coordinate _p2)
    {
        p2.setCoordinate(_p2.getCoordinate());
    }

    //*******************************************************//
    @Override
    public int compareTo(Point2 _point2D)
    {
        if (_point2D == null)
            throw new NullPointerException();

        double size1 = Math.sqrt(Math.pow(p1.getCoordinate(),2) + Math.pow(p2.getCoordinate(),2));
        double size2 = Math.sqrt(Math.pow(_point2D.p1.getCoordinate(),2) + Math.pow(_point2D.p2.getCoordinate(),2));

        if (size1 > size2)
            return 1;
        if (size1 < size2)
            return -1;
        if (size1 == size2)
            return 0;

        return -123;

    }

    public abstract int compareTo(Point3D _point3D);
}
