package buildcode;

public interface GameTerminationStrategy {
    boolean isGameOver(Grid grid, Move lastMove);
}
