package myTool;

public class Room {
    private int people;

    public Room(int people) {
        // 房间只能容纳最大人数减一的人数
        this.people = people - 1;
    }

    public synchronized void enter() {
        people--;
        while (people < 0) {
            // 房间已经满了
            try {
                // 必须等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("哲学家" + Thread.currentThread().getName() + "进入了房间");
    }

    public synchronized void exit() {
        System.out.println("哲学家" + Thread.currentThread().getName() + "离开了房间");
        people++;
        notify();
    }
}
