package Elements;

import java.awt.Color;

public abstract class Light {
	protected Color _color;
	
	
	// ***************** Constructors ********************** //
	public Light(){
		_color = new Color(255,255,255); 	/////////
	}
	public Light (Color color){
		_color = new Color(color.getRGB());
	}
	
	// ***************** Getters/Setters ********************** //
	public Color getIntensity(){
		return new Color(_color.getRGB());
	}
}
