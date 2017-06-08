package Geometries;
import primitives.*;
import java.awt.Color;
import java.util.List;


public abstract class Geometry {
	private Material _material = new Material();
	private double _nShininess = 1;
	private Color _emmission = new Color(0, 0, 0);
	
	
	public abstract List<Point3D> FindIntersections (Ray ray);
	public abstract Vector getNormal(Point3D point);
	
	public double getShininess(){
		return _nShininess;
	}
		
	
	public Material getMaterial(){
		return new Material(_material);
	}
	public Color getEmmission(){
		return new Color(_emmission.getRGB());
	}
		
	public void setShininess(double n){
		_nShininess = n;
	}
	public void setMaterial(Material _material){
		_material = new Material(_material);
	}
	public void setEmmission(Color emmission){
		_emmission = new Color(emmission.getRGB());
	}
	public void setKs(double ks){
		_material.setKs(ks);
	}
	public void setKd(double kd){
		_material.setKd(kd);
	}
	public void setKr(double Kr){
		_material.setKr(Kr);
	}
	public void setKt(double Kt){
		_material.setKt(Kt);
	}
}
