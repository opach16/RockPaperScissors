package players;

import java.util.Random;

public class Computer {
    private int points;

    public int getChoice() {
        Random random = new Random();
        return random.nextInt(1, 4);
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


