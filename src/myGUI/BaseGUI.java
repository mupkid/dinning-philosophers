package myGUI;

import application.StartThread;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class BaseGUI {
    private Pane basePane = new Pane();
    private Circle desk = new Circle(150);

    public BaseGUI() {
        setDesk();
    }

    public Pane getPane() {
        basePane.getChildren().addAll(desk);
        StartThread.startThread(basePane);
        return this.basePane;
    }

    private void setDesk() {
        desk.setLayoutX(350);
        desk.setLayoutY(350);
    }
}
