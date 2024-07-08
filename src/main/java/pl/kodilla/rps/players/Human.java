package pl.kodilla.rps.players;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Human extends Player {

    public Human(String name) {
        super(name);
    }

    @Override
    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        boolean validChoice = false;
        while (!validChoice) {
            try {
                System.out.println();
                System.out.println("1 - Rock; 2 - Paper; 3 - Scissors;\nYour turn: ");
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    validChoice = true;
                } else {
                    System.out.println("Enter value 1 - 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter numerical value!");
                scanner.next();
            } catch (NoSuchElementException e) {
                scanner.next();
            }
        }
        return choice;
    }
}
