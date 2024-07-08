package pl.kodilla.rps;

import pl.kodilla.rps.players.*;

public class Game {
    private Player player1;
    private Player player2;
    private GameService gameService;
    private GameRules gameRules;
    private InputOutputController ioController;

    public Game() {
    }

    public void gameInit() {
        while (true) {
            ioController = new InputOutputController();
            ioController.printInstruction();
            gameRules = new GameRules();
            player1 = new Human(ioController.getPlayerName());
            player2 = new Computer();
            gameService = new GameService(player1, player2, gameRules, ioController.getNumberOfRounds());
            gameService.play();
            ioController.summaryInfo(player1, player2);
            ioController.playAgain();
        }
    }
}