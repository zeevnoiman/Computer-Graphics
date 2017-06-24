package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Elements.AmbientLight;
import Elements.Camera;
import Elements.LightSource;
import Geometries.Geometry;
public class Scene
{
	private Color _background;
	private AmbientLight _ambientLight;
	private List<Geometry> _geometries = new ArrayList<Geometry>();
	private Camera _camera;
	private double _screenDistance;    //The distance between the camera and the screen
	private List<LightSource> _lights = new ArrayList<LightSource>();
	private String _sceneName = "scene";
	
	
	// ***************** Constructors ********************** //
	
	public Scene(){
		_screenDistance = 100;
		_camera = new Camera();
		_background = new Color(0, 0, 0);
		_ambientLight = new AmbientLight();
		_geometries = new ArrayList<Geometry>();
	}
	
	public Scene (Scene scene){
		this(scene._ambientLight, scene._background,
				scene._camera, scene._screenDistance);
		_geometries.addAll(scene._geometries);
		_lights.addAll(scene._lights);
	}
	public Scene(AmbientLight aLight, Color background,
			Camera camera, double screenDistance){
		_ambientLight = new AmbientLight(aLight);
		_background = new Color(background.getRGB());
		_camera = new Camera(camera);
		_screenDistance = screenDistance;
		_geometries = new ArrayList<Geometry>();
	}
	
	
	//***************** Getters/Setters ********************** //
	public Color getBackground(){
		return new Color(_background.getRGB());
	}
	public AmbientLight getAmbientLight(){
		return new AmbientLight(_ambientLight);
	}
	public Camera getCamera(){
		return new Camera(_camera);
	}
	public String getSceneName(){
		return _sceneName;
	}
	public double getScreenDistance(){
		return _screenDistance;
	}
	public void setBackground(Color background){
		_background = new Color(background.getRGB()); ///////////////// 
	}
	public void setAmbientLight(AmbientLight ambientLight){
		_ambientLight = new AmbientLight(ambientLight);
	}
	public void setCamera(Camera camera){
		_camera = new Camera(camera);
	}
	public void setSceneName(String sceneNAme){
		_sceneName = sceneNAme;
	}
	public void setScreenDistance(double screenDistance){
		_screenDistance = screenDistance;
	}
	//***************** Operations ******************** //
	public void addGeometry(Geometry geometry){
		_geometries.add(geometry);
	}
	public Iterator<Geometry> getGeometriesIterator(){
		return _geometries.iterator();
	}
	public void addLight(LightSource light){
		_lights.add(light);
	}
	public Iterator<LightSource> getLightsIterator(){
		return _lights.iterator();
	}
}
