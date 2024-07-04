import players.Computer;
import players.Player;

import java.util.*;

public class Game {
    private int numbersOfRounds;
    private int currentRound = 0;
    private boolean cheatMode = false;
    private Player player;
    private Computer computer;
    private List<String> figures;
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

    private void printResult(String playerChoice, String computerChoice) {
        System.out.println(player.getName() + ": " + playerChoice + " || Computer: " + computerChoice);
        System.out.println("Round: " + (currentRound) + " \nResult: " + player.getPoints() + " - " + computer.getPoints());
        System.out.println("--------------------");
    }

    public void battle() {
        while (player.getPoints() != numbersOfRounds && computer.getPoints() != numbersOfRounds) {
            String playerChoice = figures.get(player.getChoice());
            String computerChoice;
            if (cheatMode) {
                if (playerChoice.equals("Rock")) {
                    figures.add("Paper");
                } else if (playerChoice.equals("Paper")) {
                    figures.add("Scissors");
                } else if (playerChoice.equals("Scissors")) {
                    figures.add("Rock");
                }
                computerChoice = figures.get(computer.cheatChoice());
            } else {
                computerChoice = figures.get(computer.getChoice());
            }
            switch (playerChoice) {
                case "Rock":
                    if (computerChoice.equals(playerChoice)) {
                        System.out.println("DRAW!");
                    } else if (computerChoice.equals("Paper")) {
                        System.out.println("YOU LOST!");
                        computer.setPoints(computer.getPoints() + 1);
                        currentRound++;
                    } else if (computerChoice.equals("Scissors")) {
                        System.out.println("YOU WON!");
                        player.setPoints(player.getPoints() + 1);
                        currentRound++;
                    }
                    break;
                case "Paper":
                    if (computerChoice.equals(playerChoice)) {
                        System.out.println("DRAW!");
                    } else if (computerChoice.equals("Scissors")) {
                        System.out.println("YOU LOST!");
                        computer.setPoints(computer.getPoints() + 1);
                        currentRound++;
                    } else if (computerChoice.equals("Rock")) {
                        System.out.println("YOU WON!");
                        player.setPoints(player.getPoints() + 1);
                        currentRound++;
                    }
                    break;
                case "Scissors":
                    if (computerChoice.equals(playerChoice)) {
                        System.out.println("DRAW!");
                    } else if (computerChoice.equals("Rock")) {
                        System.out.println("YOU LOST!");
                        computer.setPoints(computer.getPoints() + 1);
                        currentRound++;
                    } else if (computerChoice.equals("Paper")) {
                        System.out.println("YOU WON!");
                        player.setPoints(player.getPoints() + 1);
                        currentRound++;
                    }
                    break;
            }
            printResult(playerChoice, computerChoice);
        }
    }

    public void gameInitialization() {
        System.out.print("Enter your name: ");
        player = new Player(scanner.next());
        computer = new Computer();
        figures = new ArrayList<>(List.of("Rock", "Paper", "Scissors"));

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

        System.out.println("Press \'y\' to enable cheat mode or other key to skip");
        String cheat = scanner.next().toLowerCase();
        if (cheat.equals("y")) {
            cheatMode = true;
            System.out.println("Cheat mode activated!");
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
            gameInitialization();
            battle();
            summaryInfo();
        }
    }

    public Game() {
    }
}
