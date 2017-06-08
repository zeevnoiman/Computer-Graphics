package primitives;

/**
 * Created by daniel on 4/6/2017.
 */
public class Material {
    private double kd; // Diffusion attenuation coefficient
    private double ks; // Specular attenuation coefficient
    private double kr; // Reflection coefficient (1 for mirror)
    private double kt; // Refraction coefficient (1 for transparent)
    private double n; // Refraction index
    // ***************** Constructors ********************** //
    public Material()
    {
        kd = 1;
        ks = 1;
        kr = 0;
        kt = 0;
        n = 1;
    }
    public Material(Material material)
    {
        kd = material.kd;
        ks = material.ks;
        kr = material.kr;
        kt = material.kt;
        n = material.n;
    }
    // ***************** Getters/Setters ********************** //
    public double getKd()
    {
        return kd;
    }
    public double getKs()
    {
        return ks;
    }
    public double getKr()
    {
        return kr;
    }
    public double getKt()
    {
        return kt;
    }
    public double getN()
    {
        return n;
    }
    public void setKd(double _Kd)
    {
        kd = _Kd;
    }
    public void setKs(double _Ks)
    {
        ks = _Ks;
    }
    public void setKr(double _Kr)
    {
        kr = _Kr;
    }
    public void setKt(double _Kt)
    {
        kt = _Kt;
    }
    public void setN (double _n)
    {
        n = _n;
    }
}
