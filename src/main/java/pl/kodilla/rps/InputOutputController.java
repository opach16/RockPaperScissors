package pl.kodilla.rps;

import pl.kodilla.rps.players.Player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputOutputController {
    private Scanner scanner = new Scanner(System.in);
    private List<String> figures = new ArrayList<>(List.of("ROCK", "PAPER", "SCISSORS", "SPOCK", "LIZARD"));

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
        System.out.println("INSTRUCTION:");
        System.out.println("******************************");
        System.out.println("ROCK beats SCISSORS and LIZARD");
        System.out.println("PAPER beats ROCK and SPOCK");
        System.out.println("SCISSORS beats PAPER and LIZARD");
        System.out.println("SPOCK beats ROCK and SCISSORS");
        System.out.println("LIZARD beats PAPER and SPOCK\n");
        System.out.print("1 – play ROCK | ");
        System.out.print("2 – play PAPER | ");
        System.out.print("3 – play SCISSORS | ");
        System.out.print("4 – play SPOCK | ");
        System.out.print("5 – play LIZARD\n");
        System.out.print("X – Exit game | ");
        System.out.println("N – Restart");
        System.out.println("******************************");
    }

    public void printResult(Player player1, Player player2, int player1Choice, int player2Choice, int result) {
        if (result == 0) {
            System.out.println("DRAW!");
        } else if (result == 1) {
            System.out.println("YOU WIN!");
        } else if (result == -1) {
            System.out.println("YOU LOST!");
        }
        System.out.println(player1.getName() + ": " + figures.get(player1Choice - 1) + " || "
                + player2.getName() + ": " + figures.get(player2Choice - 1));
        int round = Math.max(player1.getPoints(), player2.getPoints());
        System.out.println("Round: " + (round) + " \nResult: " + player1.getPoints() + " - " + player2.getPoints());
    }

    public void summaryInfo(Player player1, Player player2) {
        System.out.println("******************************");
        System.out.print("GAME OVER! ");
        if (player1.getPoints() > player2.getPoints()) {
            System.out.println("THE WINNER: " + player1.getName() + " - " + player1.getPoints() + " ROUNDS WON!");
        } else {
            System.out.println("THE WINNER: " + player2.getName() + " - " + player2.getPoints() + " ROUNDS WON!");
        }
        System.out.println("******************************");
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