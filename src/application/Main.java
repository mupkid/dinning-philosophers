package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import myGUI.BaseGUI;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BaseGUI base = new BaseGUI();
            Pane root = base.getPane();
            Scene scene = new Scene(root, 1300, 700);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
