package application;

import javafx.scene.layout.Pane;
import myGUI.PauseButton;
import myGUI.RestartButton;
import myGUI.StartButton;
import myGUI.StopButton;
import myResource.Fork;
import myThread.Philosopher;
import myTool.Room;

public class StartThread {
    public static void startThread(Pane pane) {
        int numberOfForks = 5;
        int numberOfPhilosopher = 5;
        Room room = new Room(numberOfPhilosopher);
        Fork[] forks = new Fork[numberOfForks];
        for (int i = 0; i < numberOfForks; i++) {
            forks[i] = new Fork(i + 1);
            pane.getChildren().add(forks[i].getLine());
            pane.getChildren().add(forks[i].geText());
        }
        Philosopher[] philosophers = new Philosopher[numberOfPhilosopher];
        for (int i = 0; i < numberOfPhilosopher; i++) {
            philosophers[i] = new Philosopher(room, forks[i], forks[(i + 1) % numberOfForks]);
            philosophers[i].setName((i + 1) + "");
            // philosophers[i].start();
            pane.getChildren().add(philosophers[i].getCircle());
            pane.getChildren().add(philosophers[i].getLabel());
            pane.getChildren().add(philosophers[i].geText());
        }

        pane.getChildren().addAll(
                new StartButton(philosophers).getButton(),
                new PauseButton(philosophers).getButton(),
                new RestartButton(philosophers).getButton(),
                new StopButton(philosophers).getButton());
    }
}
