package myGUI;

import javafx.scene.control.Button;
import myThread.Philosopher;

public class StartButton {
    Philosopher[] philosophers;

    public StartButton(Philosopher[] philosophers) {
        this.philosophers = philosophers;
    }

    public Button getButton() {
        Button startButton = new Button("start");
        startButton.setLayoutX(210);
        startButton.setLayoutY(45);

        startButton.setOnMouseClicked(e -> {
            for (Philosopher a : philosophers) {
                a.start();
            }
        });

        return startButton;
    }
}
