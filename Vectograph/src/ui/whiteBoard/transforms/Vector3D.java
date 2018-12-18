package ui.whiteBoard.transforms;

import javafx.geometry.Point3D;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;

public class Vector3D extends Cylinder {
	Point3D pivot = new Point3D(0,0,0);
	Rotate xRotate;
	Rotate yRotate;
	void rotateVector() {
		this.getTransforms().addAll(
				xRotate = new Rotate(0,Rotate.X_AXIS),
				yRotate = new Rotate(0,Rotate.Y_AXIS)
				);
	}
}
