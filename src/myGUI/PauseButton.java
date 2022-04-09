package myGUI;

import javafx.scene.control.Button;
import myThread.Philosopher;

public class PauseButton {
    Philosopher[] philosophers;

    public PauseButton(Philosopher[] philosophers) {
        this.philosophers = philosophers;
    }

    public Button getButton() {
        Button pauseButton = new Button("pause");
        pauseButton.setLayoutX(290);
        pauseButton.setLayoutY(45);

        pauseButton.setOnMouseClicked(e -> {
            for (Philosopher a : philosophers) {
                a.suspend();
            }
        });

        return pauseButton;
    }
}
