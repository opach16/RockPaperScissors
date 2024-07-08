package pl.kodilla.rps;

public class GameRules {
    private final int[][] rules = new int[][]{
            {0, 1, -1},
            {-1, 0, 1},
            {1, -1, 0}
    };

    public GameRules() {
    }

    public int getResult(int player1Move, int player2Move) {
        return rules[player1Move - 1][player2Move - 1];
    }
}
