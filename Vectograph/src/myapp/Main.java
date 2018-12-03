package myapp;
import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Main extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Vectulator");

        BorderPane layout = new BorderPane();
        layout.setLeft(addList());
        layout.setBottom(addBottom());
        layout.setCenter(whiteboard.makeWhiteBoard());
        
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 1280, 720,Color.WHITE);
        window.setScene(scene);
        window.show();
    }

    //Listview of all Vectors
    public ListView<Vector> addList() {
        ListView<Vector> list = new ListView<Vector>();
        
        list.setItems(Vector.all);
                
        return list;
    }
    
    //Bottom of BorderPane with "Add..." Button and textInput for future use.
    public HBox addBottom() {
        button = new Button("Add...");
    	HBox bottomPane = new HBox();
        bottomPane.setPadding(new Insets(10, 12, 10, 12));
        bottomPane.setSpacing(10);
        
        Button addButton = new Button("Add...");
        addButton.setPrefSize(100, 20);
        addButton.setOnAction(e -> {
        	addWindow.display();
        	
        	
        	});
        
        TextField addInput = new TextField();
       
        
        bottomPane.getChildren().addAll(addButton, addInput);
        HBox.setHgrow(addInput, Priority.ALWAYS);
       
        
    	return bottomPane;
    }
    
    



}