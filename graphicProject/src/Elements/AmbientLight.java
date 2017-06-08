package Elements;
import java.awt.Color;
import java.util.Map;

public class AmbientLight extends Light	{
	
	private final double _Ka = 0.1;
	
	// ***************** Constructors ********************** //
	public AmbientLight(){
		//_color = new Color(0); 	/////////
		super();
	}
	public AmbientLight(AmbientLight aLight){
		super(aLight._color);
	}
	public AmbientLight(int r, int g, int b){
		_color = new Color(r, g, b);
	}
	public AmbientLight(Map<String, String> attributes){
		// TODO
	}
	// ***************** Getters/Setters ********************** //
	public Color getColor(){
	
		return new Color(_color.getRGB());
	}
	public void setColor(Color color){
		_color = new Color(color.getRGB());
	}
	public double getKa(){
		return _Ka;
	}
	@Override
	public Color getIntensity(){
		
		float r = (float) (_Ka * _color.getRed()) / 255;
		float g = (float)(_Ka * _color.getGreen()) / 255;
		float b = (float)(_Ka * _color.getBlue()) / 255;
		return new Color(r,g,b);
	}

}
