package buildcode;

public class TicTacToeGame {
    private final Grid grid;
    private final Player player1;
    private final Player player2;
    private Player playerTurn;
    private final GameTerminationStrategy gameOverStrategy;

    public TicTacToeGame(Player player1, Player player2, GameTerminationStrategy gameOverStrategy) {
        this.gameOverStrategy = gameOverStrategy;
        grid=new Grid();
        this.player1 = player1;
        this.player2 = player2;
        if(player1.getPiece().equals('X')) {
            this.playerTurn = player1;
        } else {
            this.playerTurn = player2;
        }
    }

    public void playerMove(Player player,int x,int y)
    {
        if(playerTurn != player) {
            System.out.println("It's not " + player.getName() + "'s turn!");
        return;
    }

        if(!grid.getCell(x,y).isEmpty()) {
            System.out.println("Cell is already occupied!");
            return;
        }
        Move move=new Move(x,y,player);
        makeMove(move);
    }



    public void resetGame() {
        // reset Game
        grid.resetGridCells();
    }

    private void switchTurn() {
        if(playerTurn == player1) {
            playerTurn = player2;
        } else {
            playerTurn = player1;
        }
    }

    public void makeMove(Move move) {
        grid.setCell(move);
        grid.displayGrid();

        if (gameOverStrategy.isGameOver(grid, move)) {
            System.out.println("Game Over! " + move.getPlayer().getName() + " wins!");
            resetGame();
        } else if (grid.isFull()) {
            System.out.println("It's a draw!");
            resetGame();
        } else {
            switchTurn();
        }
    }
}
