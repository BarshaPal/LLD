package buildcode;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1", Piece.X);
        Player player2 = new Player("Player 2", Piece.O);

        GameTerminationStrategy strategy = new DefaultGameTerminationStrategy();
        TicTacToeGame ticTacToeGame = new TicTacToeGame(player1, player2, strategy);

        // Simulate a game
        ticTacToeGame.playerMove(player1, 0, 0);
        ticTacToeGame.playerMove(player2, 1, 1);
        ticTacToeGame.playerMove(player1, 0, 1);
        ticTacToeGame.playerMove(player2, 2, 2);
        ticTacToeGame.playerMove(player1, 0, 2); // Player 1 should win here
    }
}
