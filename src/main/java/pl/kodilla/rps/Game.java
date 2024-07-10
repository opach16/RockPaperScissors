package pl.kodilla.rps;

import pl.kodilla.rps.players.*;

public class Game {
    private Player player1;
    private Player player2;
    private int maxPoints;
    private GameService gameService;
    private GameRules gameRules;
    private InputOutputController ioController;

    public void gameInit() {
        ioController = new InputOutputController();
        ioController.printInstruction();
        gameRules = new GameRules();
        while (true) {
            player1 = new Human(ioController.getPlayerName());
            player2 = new Computer();
            maxPoints = ioController.getNumberOfRounds();
            gameService = new GameService(player1, player2, gameRules, maxPoints);
            gameService.play();
            ioController.summaryInfo(player1, player2);
            ioController.playAgain();
        }
    }
}