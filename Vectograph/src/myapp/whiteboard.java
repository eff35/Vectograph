package myapp;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;  
public class whiteboard {
	
	public static Group makeWhiteBoard(){
		Group wb = new Group();
		Sphere mySphere = new Sphere(100);
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
		
		
		
		wb.getChildren().addAll(mySphere,xAxis,yAxis,zAxis);

		return wb;
	}
	
	
}
