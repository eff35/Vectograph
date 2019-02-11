package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import resources.Vector;
import ui.Bottom.Bottom;
import ui.leftSide.LeftPane;
import ui.whiteBoard.WhiteBoard;



public class Main extends Application {

    public static double listWidth;
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
        layout.getLeft().setLayoutX(20);
        

        HBox bottom = Bottom.addBottom();
        
        layout.setBottom(bottom);
        
        SubScene center = WhiteBoard.addWhiteBoard();
        
        layout.setCenter(center);
        center.heightProperty().bind(layout.heightProperty().subtract(bottom.heightProperty()));
        center.widthProperty().bind(layout.widthProperty());

        
        Scene scene = new Scene(layout, 1280, 720,Color.WHITE);
        window.setScene(scene);

        window.show();
        listWidth =leftSide.getWidth();

    }



    

        
       
        

       
        
    }
    
    



