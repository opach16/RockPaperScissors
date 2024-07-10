package pl.kodilla.rps;

import pl.kodilla.rps.players.Player;

import java.util.*;

public class InputOutputController {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static List<String> FIGURES = new ArrayList<>(List.of("ROCK", "PAPER", "SCISSORS", "SPOCK", "LIZARD"));

    public String getPlayerName() {
        System.out.print("Enter your name: ");
        String playerName = SCANNER.next();
        return playerName;
    }

    public int getNumberOfRounds() {
        int numberOfRounds = 0;
        boolean validValue = false;
        while (!validValue) {
            System.out.print("Enter the number of winning rounds to play (1-10): ");
            try {
                numberOfRounds = SCANNER.nextInt();
                if (numberOfRounds >= 1 && numberOfRounds <= 10) {
                    validValue = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a numerical value!");
                SCANNER.next();
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
        System.out.println(player1.getName() + ": " + FIGURES.get(player1Choice - 1) + " || "
                + player2.getName() + ": " + FIGURES.get(player2Choice - 1));
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
            String playAgain = SCANNER.next().toLowerCase();
            if (playAgain.equals("x")) {
                System.exit(0);
            } else if (playAgain.equals("n")) {
                break;
            }
        }
    }

    public static int getHumanMove() {
        int choice = -1;
        boolean validChoice = false;
        while (!validChoice) {
            try {
                System.out.println("------------------------------");
                System.out.print("1 - Rock; 2 - Paper; 3 - Scissors; 4 - Spock; 5 - Lizard\nYour turn: ");
                choice = SCANNER.nextInt();
                if (choice >= 1 && choice <= 5) {
                    validChoice = true;
                } else {
                    System.out.println("Enter value 1 - 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter numerical value!");
                SCANNER.next();
            } catch (NoSuchElementException e) {
                SCANNER.next();
            }
        }
        return choice;
    }
}