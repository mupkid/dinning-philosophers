package myThread;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import myResource.Fork;
import myTool.Room;

import java.util.Random;

public class Philosopher extends Thread {
    // 是否正在吃饭
    private boolean isEating = false;
    private boolean isThinking = false;
    private final Fork leftFork;
    private final Fork rightFork;
    private final Room room;
    private final Circle circle = new Circle();
    private final Label nameLabel = new Label();
    private final Text text = new Text();

    public Philosopher(Room room, Fork leftFork, Fork rightFork) {
        this.room = room;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void eat(long eatTime) {
        try {
            room.enter();
            System.out.println("哲学家" + this.getName() + "想要拿起叉子" + leftFork.getId());
            text.setText("哲学家" + this.getName() + "想要拿起叉子" + leftFork.getId());
            leftFork.takeFork();// 先拿左手的叉子再拿右手的叉子
            System.out.println("哲学家" + this.getName() + "想要拿起叉子" + rightFork.getId());
            text.setText("哲学家" + this.getName() + "想要拿起叉子" + rightFork.getId());
            rightFork.takeFork();
            System.out.println("哲学家" + getName() + "需要吃饭" + eatTime + "秒");
            text.setText("哲学家" + getName() + "需要吃饭" + eatTime + "秒");
            isEating = true;
            setCircle();
            // 两只叉子都拿到后就开始吃饭
            Thread.sleep(eatTime * 1000);
            leftFork.putFork();
            rightFork.putFork();
            isEating = false;
            setCircle();
            room.exit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void think(long thinkTime) {
        try {
            System.out.println("哲学家" + getName() + "需要思考" + thinkTime + "秒");
            text.setText("哲学家" + getName() + "需要思考" + thinkTime + "秒");
            isThinking = true;
            setCircle();

            Thread.sleep(thinkTime * 1000);
            isThinking = false;
            setCircle();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!this.isInterrupted()) {
            // 思考和吃饭用sleep()
            think(random.nextInt(10) + 1);
            eat(random.nextInt(10) + 1);
        }
    }

    public Circle getCircle() {
        switch (this.getName()) {
            case "1":
                circle.setCenterX(350 + 225 * Math.cos(Math.toRadians(54)));
                circle.setCenterY(350 + 225 * Math.sin(Math.toRadians(54)));
                circle.setRadius(50);
                break;
            case "2":
                circle.setCenterX(350 + 225 * Math.cos(Math.toRadians(18)));
                circle.setCenterY(350 - 225 * Math.sin(Math.toRadians(18)));
                circle.setRadius(50);
                break;
            case "3":
                circle.setCenterX(350);
                circle.setCenterY(125);
                circle.setRadius(50);
                break;
            case "4":
                circle.setCenterX(350 - 225 * Math.cos(Math.toRadians(18)));
                circle.setCenterY(350 - 225 * Math.sin(Math.toRadians(18)));
                circle.setRadius(50);
                break;
            case "5":
                circle.setCenterX(350 - 225 * Math.cos(Math.toRadians(54)));
                circle.setCenterY(350 + 225 * Math.sin(Math.toRadians(54)));
                circle.setRadius(50);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.getName());
        }
        circle.setFill(Color.GREEN);
        return circle;
    }

    public Label getLabel() {
        nameLabel.setText(this.getName());
        nameLabel.setTextFill(Color.WHITE);
        nameLabel.setFont(new Font("Arial", 18));
        switch (this.getName()) {
            case "1":
                nameLabel.setLayoutX(350 + 220 * Math.cos(Math.toRadians(52)));
                nameLabel.setLayoutY(350 + 220 * Math.sin(Math.toRadians(52)));
                break;
            case "2":
                nameLabel.setLayoutX(350 + 225 * Math.cos(Math.toRadians(20)));
                nameLabel.setLayoutY(350 - 225 * Math.sin(Math.toRadians(20)));
                break;
            case "3":
                nameLabel.setLayoutX(347);
                nameLabel.setLayoutY(115);
                break;
            case "4":
                nameLabel.setLayoutX(350 - 230 * Math.cos(Math.toRadians(20)));
                nameLabel.setLayoutY(350 - 230 * Math.sin(Math.toRadians(20)));
                break;
            case "5":
                nameLabel.setLayoutX(350 - 225 * Math.cos(Math.toRadians(52)));
                nameLabel.setLayoutY(350 + 225 * Math.sin(Math.toRadians(52)));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.getName());
        }
        return nameLabel;
    }

    public void setCircle() {
        if (isThinking) {
            circle.setFill(Color.GREEN);
        } else if (isEating) {
            circle.setFill(Color.RED);
        } else {
            circle.setFill(Color.YELLOW);
        }
    }

    public Text geText() {
        switch (this.getName()) {
            case "1":
                text.setLayoutX(700);
                text.setLayoutY(100);
                break;
            case "2":
                text.setLayoutX(700);
                text.setLayoutY(200);
                break;
            case "3":
                text.setLayoutX(700);
                text.setLayoutY(300);
                break;
            case "4":
                text.setLayoutX(700);
                text.setLayoutY(400);
                break;
            case "5":
                text.setLayoutX(700);
                text.setLayoutY(500);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.getName());
        }
        return text;
    }
}
