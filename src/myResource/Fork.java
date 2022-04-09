package myResource;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import myThread.Philosopher;

public class Fork {
    private Philosopher owner;
    // 叉子是否可获得
    boolean avaliable = true;
    private int Id;
    private Line line = new Line();
    private Text text = new Text();

    public Fork(int Id) {
        this.Id = Id;
    }

    public void setOwner(Philosopher owner) {
        this.owner = owner;
    }

    public int getId() {
        return this.Id;
    }

    public Line getLine() {
        switch (Id) {
            case 1:
                line.setStartX(350);
                line.setStartY(400);
                line.setEndX(350);
                line.setEndY(490);
                break;
            case 2:
                line.setStartX(350 + 50 * Math.cos(Math.toRadians(18)));
                line.setStartY(350 + 50 * Math.sin(Math.toRadians(18)));
                line.setEndX(350 + 140 * Math.cos(Math.toRadians(18)));
                line.setEndY(350 + 140 * Math.sin(Math.toRadians(18)));
                break;
            case 3:
                line.setStartX(350 + 50 * Math.cos(Math.toRadians(54)));
                line.setStartY(350 - 50 * Math.sin(Math.toRadians(54)));
                line.setEndX(350 + 140 * Math.cos(Math.toRadians(54)));
                line.setEndY(350 - 140 * Math.sin(Math.toRadians(54)));
                break;
            case 4:
                line.setStartX(350 - 50 * Math.cos(Math.toRadians(54)));
                line.setStartY(350 - 50 * Math.sin(Math.toRadians(54)));
                line.setEndX(350 - 140 * Math.cos(Math.toRadians(54)));
                line.setEndY(350 - 140 * Math.sin(Math.toRadians(54)));
                break;
            case 5:
                line.setStartX(350 - 50 * Math.cos(Math.toRadians(18)));
                line.setStartY(350 + 50 * Math.sin(Math.toRadians(18)));
                line.setEndX(350 - 140 * Math.cos(Math.toRadians(18)));
                line.setEndY(350 + 140 * Math.sin(Math.toRadians(18)));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Id);
        }
        line.setStroke(Color.YELLOW);
        return line;
    }

    public void setLine() {
        if (avaliable) {
            switch (Id) {
                case 1:
                    line.setStartX(350);
                    line.setStartY(400);
                    line.setEndX(350);
                    line.setEndY(490);
                    break;
                case 2:
                    line.setStartX(350 + 50 * Math.cos(Math.toRadians(18)));
                    line.setStartY(350 + 50 * Math.sin(Math.toRadians(18)));
                    line.setEndX(350 + 140 * Math.cos(Math.toRadians(18)));
                    line.setEndY(350 + 140 * Math.sin(Math.toRadians(18)));
                    break;
                case 3:
                    line.setStartX(350 + 50 * Math.cos(Math.toRadians(54)));
                    line.setStartY(350 - 50 * Math.sin(Math.toRadians(54)));
                    line.setEndX(350 + 140 * Math.cos(Math.toRadians(54)));
                    line.setEndY(350 - 140 * Math.sin(Math.toRadians(54)));
                    break;
                case 4:
                    line.setStartX(350 - 50 * Math.cos(Math.toRadians(54)));
                    line.setStartY(350 - 50 * Math.sin(Math.toRadians(54)));
                    line.setEndX(350 - 140 * Math.cos(Math.toRadians(54)));
                    line.setEndY(350 - 140 * Math.sin(Math.toRadians(54)));
                    break;
                case 5:
                    line.setStartX(350 - 50 * Math.cos(Math.toRadians(18)));
                    line.setStartY(350 + 50 * Math.sin(Math.toRadians(18)));
                    line.setEndX(350 - 140 * Math.cos(Math.toRadians(18)));
                    line.setEndY(350 + 140 * Math.sin(Math.toRadians(18)));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + Id);
            }
            line.setStroke(Color.YELLOW);
        } else {
            switch (Id) {
                case 1:
                    line.setStartX(350);
                    line.setStartY(510);
                    line.setEndX(350);
                    line.setEndY(600);
                    break;
                case 2:
                    line.setStartX(350 + 160 * Math.cos(Math.toRadians(18)));
                    line.setStartY(350 + 160 * Math.sin(Math.toRadians(18)));
                    line.setEndX(350 + 250 * Math.cos(Math.toRadians(18)));
                    line.setEndY(350 + 250 * Math.sin(Math.toRadians(18)));
                    break;
                case 3:
                    line.setStartX(350 + 160 * Math.cos(Math.toRadians(54)));
                    line.setStartY(350 - 160 * Math.sin(Math.toRadians(54)));
                    line.setEndX(350 + 250 * Math.cos(Math.toRadians(54)));
                    line.setEndY(350 - 250 * Math.sin(Math.toRadians(54)));
                    break;
                case 4:
                    line.setStartX(350 - 160 * Math.cos(Math.toRadians(54)));
                    line.setStartY(350 - 160 * Math.sin(Math.toRadians(54)));
                    line.setEndX(350 - 250 * Math.cos(Math.toRadians(54)));
                    line.setEndY(350 - 250 * Math.sin(Math.toRadians(54)));
                    break;
                case 5:
                    line.setStartX(350 - 160 * Math.cos(Math.toRadians(18)));
                    line.setStartY(350 + 160 * Math.sin(Math.toRadians(18)));
                    line.setEndX(350 - 250 * Math.cos(Math.toRadians(18)));
                    line.setEndY(350 + 250 * Math.sin(Math.toRadians(18)));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + Id);
            }
            line.setStroke(Color.RED);
        }
    }

    public Text geText() {
        switch (Id) {
            case 1:
                text.setLayoutX(900);
                text.setLayoutY(100);
                break;
            case 2:
                text.setLayoutX(900);
                text.setLayoutY(200);
                break;
            case 3:
                text.setLayoutX(900);
                text.setLayoutY(300);
                break;
            case 4:
                text.setLayoutX(900);
                text.setLayoutY(400);
                break;
            case 5:
                text.setLayoutX(900);
                text.setLayoutY(500);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Id);
        }
        return text;
    }

    public synchronized void takeFork() {
        // 取叉子，应保持原子性
        // System.out.println("哲学家" + Thread.currentThread().getName() + "想要拿起叉子" + getId());
        // text.setText("哲学家" + Thread.currentThread().getName() + "想要拿起叉子" + getId());
        while (!avaliable) {
            // 叉子不能使用
            try {
                // 只能等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("哲学家" + Thread.currentThread().getName() + "得到了叉子" + getId());
        text.setText("哲学家" + Thread.currentThread().getName() + "得到了叉子" + getId());
        avaliable = false;
        setOwner((Philosopher) (Thread.currentThread()));
        setLine();

    }

    public synchronized void putFork() {
        // 吃完饭，放下叉子，也要保持原子性
        System.out.println("哲学家" + Thread.currentThread().getName() + "放下了叉子" + getId());
        text.setText("哲学家" + Thread.currentThread().getName() + "放下了叉子" + getId());
        avaliable = true;
        setOwner(null);
        setLine();
        notify();
    }
}
