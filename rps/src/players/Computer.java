package players;

import java.util.Random;

public class Computer {
    private int points;

    public int getChoice() {
        Random random = new Random();
        return random.nextInt(0, 3);
    }
    public int cheatChoice() {
        Random random = new Random();
        return random.nextInt(0, 4);
    }

    public Computer() {
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}


