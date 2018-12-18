package ui.Bottom;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import myapp.addWindow;

public class Bottom {
	static Button button;
    //Bottom of BorderPane with "Add..." Button and textInput for future use.

    public static HBox addBottom() {
        button = new Button("Add...");
    	HBox bottomBox = new HBox();
        bottomBox.setPadding(new Insets(5, 10, 5, 10));
        bottomBox.setSpacing(10);
        
        Button addButton = new Button("Add...");
        addButton.setPrefSize(100, 20);
        addButton.setOnAction(e -> {
        	addWindow.display();
        	
        	
        	});
        TextField addInput = new TextField();
        Label spaceHolder = new Label(" ");
        bottomBox.getChildren().addAll(addButton, addInput,spaceHolder);
        HBox.setHgrow(addInput, Priority.SOMETIMES);
        bottomBox.setPadding(new Insets(5, 10, 5, 10));
    	return bottomBox;

}
}
