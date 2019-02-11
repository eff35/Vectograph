package main;

import javafx.scene.control.ListView;

public class LeftPane {
    //Listview of all Vectors
    public static ListView<Vector> addList() {
        ListView<Vector> list = new ListView<Vector>();
        
        list.setItems(Vector.all);
                
        return list;
    }
}
