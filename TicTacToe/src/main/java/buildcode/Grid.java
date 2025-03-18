package buildcode;

import java.util.HashMap;
import java.util.Map;

public class Grid {
    private final int size=3;
    private final Cell[][]cells;

    private final Map<Piece, int[]> rowCounts;
    private final Map<Piece, int[]> colCounts;
    private final Map<Piece, Integer> diagCounts;
    private final Map<Piece, Integer> antiDiagCounts;


    public Grid() {
        cells = new Cell[size][size];
        rowCounts = new HashMap<>();
        colCounts = new HashMap<>();
        diagCounts = new HashMap<>();
        antiDiagCounts = new HashMap<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        for (Piece piece : Piece.values()) {
            rowCounts.put(piece, new int[size]);
            colCounts.put(piece, new int[size]);
            diagCounts.put(piece, 0);
            antiDiagCounts.put(piece, 0);
        }
    }
        public boolean isFull() {
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    if (cells[i][j].isEmpty()) return false;
            return true;
        }
    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
    public void setCell(Move move) {
        int x = move.getX(), y = move.getY();
        Piece piece = move.getPlayer().getPiece();
        cells[x][y].setPiece(piece);

        rowCounts.get(piece)[x]++;
        colCounts.get(piece)[y]++;
        if (x == y) {
            diagCounts.put(piece, diagCounts.get(piece) + 1);
        }
        if (x + y == size - 1) {
            antiDiagCounts.put(piece, antiDiagCounts.get(piece) + 1);
        }
    }

    public void displayGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Piece p = cells[i][j].getPiece();
                System.out.print((p == null ? "-" : p) + " ");
            }
            System.out.println();
        }
    }
    public void resetGridCells() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                cells[i][j].setPiece(null);

        for (Piece piece : Piece.values()) {
            rowCounts.put(piece, new int[size]);
            colCounts.put(piece, new int[size]);
            diagCounts.put(piece, 0);
            antiDiagCounts.put(piece, 0);
        }
    }


    public int getSize() {
        return size;
    }

    public int getRowCount(Piece piece, int row) {
        return rowCounts.get(piece)[row];
    }

    public int getColCount(Piece piece, int col) {
        return colCounts.get(piece)[col];
    }

    public int getDiagonalCount(Piece piece) {
        return diagCounts.get(piece);
    }

    public int getAntiDiagonalCount(Piece piece) {
        return antiDiagCounts.get(piece);
    }


}





