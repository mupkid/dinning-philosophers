package myGUI;

import javafx.scene.control.Button;
import myThread.Philosopher;

public class RestartButton {
    Philosopher[] philosophers;

    public RestartButton(Philosopher[] philosophers) {
        this.philosophers = philosophers;
    }

    public Button getButton() {
        Button restartButton = new Button("restart");
        restartButton.setLayoutX(370);
        restartButton.setLayoutY(45);

        restartButton.setOnMouseClicked(e -> {
            for (Philosopher a : philosophers) {
                a.resume();
            }
        });

        return restartButton;
    }
}
