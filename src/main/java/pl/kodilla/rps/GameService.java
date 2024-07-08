package pl.kodilla.rps;

import pl.kodilla.rps.players.Player;

public class GameService {
    private Player player1;
    private Player player2;
    private GameRules gameRules;
    private int maxPoints;
    private final InputOutputController inputOutputController = new InputOutputController();

    public GameService(Player player1, Player player2, GameRules gameRules, int maxPoints) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameRules = gameRules;
        this.maxPoints = maxPoints;
    }

    public void play() {
        do {
            int player1Choice = player1.getChoice();
            int player2Choice = player2.getChoice();
            int result = gameRules.getResult(player1Choice, player2Choice);
            switch (result) {
                case 0 -> {}
                case 1 -> player1.addPoint();
                case -1 -> player2.addPoint();
            }
            inputOutputController.printResult(player1, player2, player1Choice, player2Choice, result);
        } while (player1.getPoints() < maxPoints && player2.getPoints() < maxPoints);
    }
}
