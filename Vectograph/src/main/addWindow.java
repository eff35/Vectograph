package main;
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import resources.Vector;
public class addWindow {
	static String name;
	static double xCor; 
	static double yCor; 
	static double zCor;
	public static Vector display() {
		
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL); //makes main window unusable while addWindow is open
		window.setTitle("Add Vector");
		
		
		
		GridPane layout = new GridPane();
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.setVgap(8);
		layout.setHgap(10);
		
		Scene scene = new Scene(layout, 200, 150);	
		
		Label nameLabel = new Label("Name:");
		GridPane.setConstraints(nameLabel, 0, 0);
		TextField nameInput = new TextField();
		nameInput.setPromptText("Name");
		GridPane.setConstraints(nameInput, 1, 0);
		
		TextField xCorInput = new TextField();
		xCorInput.setPromptText("x");
		GridPane.setConstraints(xCorInput, 0, 1);
		
		TextField yCorInput = new TextField();
		yCorInput.setPromptText("y");
		GridPane.setConstraints(yCorInput, 1, 1);
		
		TextField zCorInput = new TextField();
		zCorInput.setPromptText("z");
		GridPane.setConstraints(zCorInput, 2, 1);
		
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> window.close());
		GridPane.setConstraints(addButton,1,3);
		
		layout.getChildren().addAll(nameLabel, nameInput, xCorInput, yCorInput, zCorInput, addButton);
		
			
		window.setScene(scene);
		window.showAndWait();
		name = nameInput.getText();
		xCor = Double.parseDouble(xCorInput.getText());
		yCor = Double.parseDouble(yCorInput.getText());
		zCor = Double.parseDouble(zCorInput.getText());
		return new Vector(name,xCor,yCor,zCor);
	}
	 
}
