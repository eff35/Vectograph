package ui.whiteBoard;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import resources.Vector;
import ui.whiteBoard.transforms.RotableGroup;  
import ui.whiteBoard.interactions.MouseHandler;
import java.util.Random;

/*
 * This class handles the View of the Coordinate System and draws the vectors
 */

public class WhiteBoard {

	
	static RotableGroup root3D = new RotableGroup();
	static SubScene subScene = new SubScene(root3D, 800, 600, true, SceneAntialiasing.BALANCED);
	 
	
	public static SubScene addWhiteBoard(){
		makeAxes();
		MouseHandler.startMouseControl(root3D, subScene);
		return subScene;
	}

	
    private static void makeAxes() {

        final Box xAxis = new Box(500, 1, 1);
       // xAxis.setTranslateX(100);
        final Box yAxis = new Box(1, 500, 1);
        //yAxis.setTranslateY(100);
        final Box zAxis = new Box(1, 1, 500);
       // zAxis.setTranslateZ(100);
        
        xAxis.setMaterial(new PhongMaterial(Color.BLACK));
        yAxis.setMaterial(new PhongMaterial(Color.BLACK));
        zAxis.setMaterial(new PhongMaterial(Color.BLACK));
 
        
       
        root3D.getChildren().addAll(xAxis, yAxis, zAxis);
        subScene.setFill(Color.WHITE);
        
        
        //Listeners to always keep origin always centered
		subScene.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				root3D.translateXProperty().set(((double)newValue -248)/2);
				
			}
			
		});
		subScene.heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				root3D.translateYProperty().set((double)newValue/2);
			
			}});
		root3D.getTransforms().add(new Rotate(195.0, Rotate.X_AXIS));
		root3D.getTransforms().add(new Rotate(-10, Rotate.Y_AXIS));
		

    }
    
    
    public static void addVector(Vector vector) {
    	Cylinder cyl = new Cylinder(2, vector.value*10);
    	cyl.setTranslateY(vector.value/2*10);
    	cyl.setMaterial(new PhongMaterial(randomColor()));
    	
    	
    	Rotate yRot = new Rotate(vector.yAngle,0,0,0,Rotate.Y_AXIS);
    	Rotate xRot = new Rotate(vector.xAngle,0,-vector.value/2*10,0, Rotate.X_AXIS);
        	
    	cyl.getTransforms().addAll(yRot,xRot);
    	
    	
    	root3D.getChildren().addAll(cyl);
    	
    	
    	
    }
    static Color randomColor() {
    	Random rand= new Random();
    	double r = rand.nextDouble();
    	double g = rand.nextDouble();
    	double b = rand.nextDouble();
    	return new Color(r,g,b, .99);
    }
    




}
