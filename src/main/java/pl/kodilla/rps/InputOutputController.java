package pl.kodilla.rps;

import pl.kodilla.rps.players.Player;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputOutputController {
    private Scanner scanner = new Scanner(System.in);
    private List<String> figures = new ArrayList<>(List.of("Rock", "Paper", "Scissors"));

    public InputOutputController() {
    }

    public String getPlayerName() {
        System.out.print("Enter your name: ");
        String playerName = scanner.next();
        return playerName;
    }

    public int getNumberOfRounds() {
        int numberOfRounds = 0;
        boolean validValue = false;
        while (!validValue) {
            System.out.print("Enter the number of winning rounds to play (1-10): ");
            try {
                numberOfRounds = scanner.nextInt();
                if (numberOfRounds >= 1 && numberOfRounds <= 10) {
                    validValue = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a numerical value!");
                scanner.next();
            }
        }
        return numberOfRounds;
    }

    public void printInstruction() {
        System.out.println("Instruction:");
        System.out.print("1 – play \"Rock\"; ");
        System.out.print("2 – play \"Paper\"; ");
        System.out.print("3 – play \"Scissors\"; ");
        System.out.print("x – Exit game; ");
        System.out.println("n – Restart\n");
    }

    public void printResult(Player player1, Player player2, int player1Choice, int player2Choice, int result) {
        if (result == 0) {
            System.out.println("DRAW!");
        } else if (result == 1) {
            System.out.println("YOU WIN!");
        } else if (result == 2) {
            System.out.println("YOU LOST!");
        }
        System.out.println(player1.getName() + ": " + figures.get(player1Choice - 1) + " || " + player2.getName() + ": " + figures.get(player2Choice - 1));
        int round = Math.max(player1.getPoints(), player2.getPoints());
        System.out.println("Round: " + (round) + " \nResult: " + player1.getPoints() + " - " + player2.getPoints());
        System.out.println("--------------------");
    }

    public void summaryInfo(Player player1, Player player2) {
        System.out.print("GAME OVER! ");
        if (player1.getPoints() > player2.getPoints()) {
            System.out.println("The winner: " + player1.getName() + " - " + player1.getPoints() + " rounds won!\n");
        } else {
            System.out.println("The winner: " + player2.getName() + " - " + player2.getPoints() + " rounds won!\n");
        }
    }

    public boolean cheatMode() {
        boolean cheatMode = false;
        System.out.println("Press \'y\' to enable cheat mode or other key to skip");
        String cheat = scanner.next().toLowerCase();
        if (cheat.equals("y")) {
            cheatMode = true;
            System.out.println("Cheat mode activated!");
        }
        return cheatMode;
    }

    public void playAgain() {
        while (true) {
            System.out.println("Press \'n\' to play again or \'x\' to exit the game");
            String playAgain = scanner.next().toLowerCase();
            if (playAgain.equals("x")) {
                System.exit(0);
            } else if (playAgain.equals("n")) {
                break;
            }
        }
    }
}