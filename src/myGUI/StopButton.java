package myGUI;

import javafx.scene.control.Button;
import myThread.Philosopher;

public class StopButton {
    Philosopher[] philosophers;

    public StopButton(Philosopher[] philosophers) {
        this.philosophers = philosophers;
    }

    public Button getButton() {
        Button stopButton = new Button("stop");
        stopButton.setLayoutX(450);
        stopButton.setLayoutY(45);

        stopButton.setOnMouseClicked(e -> {
            for (Philosopher a : philosophers) {
                a.interrupt();
            }
        });

        return stopButton;
    }
}
