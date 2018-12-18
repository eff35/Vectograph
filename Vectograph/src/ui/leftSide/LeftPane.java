package ui.leftSide;

import javafx.scene.control.ListView;
import resources.Vector;

public class LeftPane {
    //Listview of all Vectors
    public static ListView<Vector> addList() {
        ListView<Vector> list = new ListView<Vector>();
        list.setItems(Vector.all);
        @SuppressWarnings("unused")
		Vector a = new Vector("a",10,10,10);
        @SuppressWarnings("unused")
        Vector b = new Vector("b",0,10,0);
        @SuppressWarnings("unused")
        Vector c = new Vector("c", 5,8,15.8);
        return list;
    }
}
,