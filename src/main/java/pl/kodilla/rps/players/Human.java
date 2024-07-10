package pl.kodilla.rps.players;

import pl.kodilla.rps.InputOutputController;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Human extends Player {

    public Human(String name) {
        super(name);
    }

    @Override
    public int getChoice() {
        return InputOutputController.getHumanMove();
    }
}
