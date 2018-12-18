package ui.whiteBoard.interactions;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.SubScene;
import javafx.scene.transform.Rotate;
import ui.whiteBoard.transforms.RotableGroup;
/*
 * This Class is used for controlling the Rotation of the Coordinate System view with a mouse.
 * It's been heavily influenced by http://www.genuinecoder.com/javafx-3d-tutorial-object-transform-rotation-with-mouse/
 * 
 */

public class MouseHandler {
    //Mouse Position at start
    private static double oldXmouse;
	private static double oldYmouse;
    //View Angle at start
    private static double oldXangle = 0;
    private static double oldYangle = 0;
    //property to easily bind to the Transforms angleProperties
    private final static DoubleProperty newXangle = new SimpleDoubleProperty(0);
    private final static DoubleProperty newYangle = new SimpleDoubleProperty(0);
    //scales angle change sensitivity
    private static double s = 0.5;
	@SuppressWarnings("unused")
	public	static void startMouseControl(RotableGroup group, SubScene scene) {
	   Rotate xRot;
	   Rotate yRot;
	   group.getTransforms().addAll(
	       xRot = new Rotate(0, Rotate.X_AXIS),
	       yRot = new Rotate(0, Rotate.Y_AXIS)
	   );
	   xRot.angleProperty().bind(newXangle);
	   yRot.angleProperty().bind(newYangle);
	
	   scene.setOnMousePressed(event -> {
	     oldXmouse = event.getSceneX();
	     oldYmouse = event.getSceneY();
	     oldXangle = newXangle.get();
	     oldYangle = newYangle.get();
	   });
	
	   scene.setOnMouseDragged(event -> {
	     newXangle.set((oldXangle - (oldYmouse - event.getSceneY()))*s);
	     newYangle.set((oldYangle - (oldXmouse - event.getSceneX()))*s);
	   });
	 }

}
