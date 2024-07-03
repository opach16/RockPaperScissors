import players.Computer;
import players.Player;

import java.util.*;

public class Game {
    private int numbersOfRounds;
    private int currentRound = 0;
    private Player player;
    private Computer computer;
    private List<String> figures = new ArrayList<>(List.of("Rock", "Paper", "Scissors"));
    Scanner scanner = new Scanner(System.in);

    private void summaryInfo() {
        System.out.print("Game over! ");
        if (computer.getPoints() > player.getPoints()) {
            System.out.println("The winner: Computer - " + computer.getPoints() + " rounds won!\n");
        } else {
            System.out.println("The winner: " + player.getName() + " - " + player.getPoints() + " rounds won!\n");
        }

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

    private void printResult(int playerChoice, int computerChoice) {
        System.out.println(player.getName() + ": " + figures.get(playerChoice - 1) + " || Computer: " + figures.get(computerChoice - 1));
        System.out.println("Round: " + (currentRound) + " \nResult: " + player.getPoints() + " - " + computer.getPoints());
        System.out.println("--------------------");
    }

    public void battle() {
        while (player.getPoints() != numbersOfRounds && computer.getPoints() != numbersOfRounds) {
            int playerChoice = player.getChoice();
            int computerChoice = computer.getChoice();
            switch (playerChoice) {
                case 1:
                    if (computerChoice == 2) {
                        System.out.println("YOU LOST!");
                        computer.setPoints(computer.getPoints() + 1);
                        currentRound++;
                    } else if (computerChoice == 3) {
                        System.out.println("YOU WON!");
                        player.setPoints(player.getPoints() + 1);
                        currentRound++;
                    } else if (computerChoice == 1) {
                        System.out.println("DRAW!");
                    }
                    break;
                case 2:
                    if (computerChoice == 1) {
                        System.out.println("YOU WON!");
                        player.setPoints(player.getPoints() + 1);
                        currentRound++;
                    } else if (computerChoice == 3) {
                        System.out.println("YOU LOST!");
                        computer.setPoints(computer.getPoints() + 1);
                        currentRound++;
                    } else if (computerChoice == 2) {
                        System.out.println("DRAW!");
                    }

                    break;
                case 3:
                    if (computerChoice == 1) {
                        System.out.println("YOU LOST!");
                        computer.setPoints(computer.getPoints() + 1);
                        currentRound++;
                    } else if (computerChoice == 2) {
                        System.out.println("YOU WON!");
                        player.setPoints(player.getPoints() + 1);
                        currentRound++;
                    } else if (computerChoice == 3) {
                        System.out.println("DRAW!");
                    }
                    break;
            }
            printResult(playerChoice, computerChoice);
        }
    }

    public void getUserInfo() {
        System.out.print("Enter your name: ");
        player = new Player(scanner.next());
        computer = new Computer();
        boolean validValue = false;
        while (!validValue) {
            System.out.print("Enter the number of winning rounds to play (1-10): ");
            try {
                numbersOfRounds = scanner.nextInt();
                if (numbersOfRounds >= 1 && numbersOfRounds <= 10) {
                    validValue = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a numerical value!");
                scanner.next();
            }
        }
    }

    public void printInstruction() {
        System.out.println("Instruction:");
        System.out.print("1 – play \"Rock\"; ");
        System.out.print("2 – play \"Paper\"; ");
        System.out.print("3 – play \"Scissors\"; ");
        System.out.print("x – Exit game; ");
        System.out.println("n – Restart\n");
    }

    public void run() {
        printInstruction();
        while (true) {
            currentRound = 0;
            getUserInfo();
            battle();
            summaryInfo();
        }
    }

    public Game() {
    }
}
