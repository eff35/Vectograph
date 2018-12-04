package myapp;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Vectograph");

        BorderPane layout = new BorderPane();
        
        ListView<Vector> leftSide = LeftPane.addList();
        layout.setLeft(leftSide);
        
        HBox bottom = Bottom.addBottom();
        
        layout.setBottom(bottom);
        
        SubScene center = WhiteBoard.addWhiteBoard();
        System.out.println(center.getLayoutX() +" " +center.getLayoutY());
        layout.setCenter(center);
        center.heightProperty().bind(layout.heightProperty().subtract(bottom.heightProperty()));
        center.widthProperty().bind(layout.widthProperty());
        

        
        Scene scene = new Scene(layout, 1280, 720,Color.WHITE);
        window.setScene(scene);
        window.show();
    }



    

        
       
        

       
        
    }
    
    



