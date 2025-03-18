package buildcode;

public enum Piece {
    X('X'),
    O('O');

    private final char symbol;

    Piece(char symbol) {
        this.symbol = symbol;
    }

    public char getPiece() {
        return symbol;
    }
}
