package buildcode;

public class DefaultGameTerminationStrategy implements GameTerminationStrategy {
    @Override
    public boolean isGameOver(Grid grid, Move move) {
        int x = move.getX();
        int y = move.getY();
        Piece piece = move.getPlayer().getPiece();

        int size = grid.getSize();

        if (grid.getRowCount(piece, x) == size ||
                grid.getColCount(piece, y) == size ||
                grid.getDiagonalCount(piece) == size ||
                grid.getAntiDiagonalCount(piece) == size) {
            return true;
        }

        return false;
    }
}
