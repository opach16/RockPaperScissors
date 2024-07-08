package pl.kodilla.rps.players;

import java.util.Random;

public class Computer extends Player {
    private final Random random = new Random();

    public Computer() {
        super("Computer");
    }

    @Override
    public int getChoice() {
        return random.nextInt(1, 6);
    }
}


