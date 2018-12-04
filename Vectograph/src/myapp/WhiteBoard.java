package myapp;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;  
public class WhiteBoard {


	final static Group axisGroup = new Group();
	static Group root3D = new Group();
	private final static Rotate rotateX = new Rotate(-20, Rotate.X_AXIS);
	private final static Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
	private final static Rotate rotateZ = new Rotate(-3, Rotate.Z_AXIS);
	static SubScene subScene = new SubScene(root3D, 800, 600, false, SceneAntialiasing.BALANCED);
	 
	
	public static SubScene addWhiteBoard(){
		buildAxes();
		
		return subScene;
	}
	/*public static void makeAxes() {
		Cylinder xAxis = new Cylinder();
		xAxis.setRadius(1);
		xAxis.setHeight(1000);
		xAxis.getTransforms().add(new Rotate (90,0,0));
		
		Cylinder yAxis = new Cylinder();
		yAxis.setRadius(1);
		yAxis.setHeight(200);
		
		Cylinder zAxis = new Cylinder();
		zAxis.setRadius(1);
		zAxis.setHeight(1);
		zAxis.setTranslateZ(50);
		zAxis.getTransforms().add(new Rotate (0,90,15));
		wb.getChildren().addAll(xAxis,yAxis,zAxis);
	}*/
	
	
    private static void buildAxes() {
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);
 
        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.DARKGREEN);
        greenMaterial.setSpecularColor(Color.GREEN);
 
        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        blueMaterial.setSpecularColor(Color.LIGHTBLUE);
 
        final Box xAxis = new Box(10000.0, 0.5, 0.5);
        final Box yAxis = new Box(0.5, 1000.0, 0.5);
        final Box zAxis = new Box(0.5, 0.5, 10000.0);
        
        xAxis.setMaterial(redMaterial);
        yAxis.setMaterial(greenMaterial);
        zAxis.setMaterial(blueMaterial);
 
        
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll (rotateX, rotateY,rotateZ, new Translate(100, 0, -500));
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        root3D.getChildren().addAll(xAxis, yAxis, zAxis, camera);
        subScene.setFill(Color.WHITE);
        subScene.setCamera(camera);
        

    }
}
