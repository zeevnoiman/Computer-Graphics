package primitives;

/**
 * Created by daniel on 3/22/2017.
 */
public class Ray {

    private Vector direction; //ray direction
    private Point3D POO;  // point of origin

    //***************Constructors*****************//
    public Ray(Vector _direction, Point3D _POO) {
        direction = new Vector(_direction);
        POO = new Point3D(_POO);
        direction.normalize();
    }

    public Ray()
    {
        direction = new Vector();
        POO = new Point3D();
        direction.normalize();
    }

    public Ray(Ray ray) {
        direction = new Vector(ray.direction);
        POO = new Point3D(ray.POO);

    }

    //******************Getters and Setters*****************//
    public Vector getDirection() {
        return new Vector(direction);
    }

    public void setDirection(Vector _direction)
    {
        direction.set_head(_direction.get_head());
        direction.normalize();
    }

    public Point3D getPOO() {
        return new Point3D(POO);
    }

    public void setPOO(Point3D POO) {
        this.POO.setP3(POO.getP3());
        this.POO.setP1(POO.getP1());
        this.POO.setP2(POO.getP2());
    }
}


