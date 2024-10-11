public abstract class ChessPiece {
    String color;
    Boolean check;

    public ChessPiece(String color) {
        this.color = color;
        check = true;
    }

    public abstract String getColor();

    public abstract Boolean canMoveToPosition(ChessBoard chessBoard,
                                              int line, int column,
                                              int toLine, int toColumn);

    public abstract String getSymbol();
}


