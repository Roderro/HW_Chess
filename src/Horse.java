public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Boolean canMoveToPosition(ChessBoard chessBoard,
                                     int line, int column,
                                     int toLine, int toColumn) {
        // Проверка на то, что фигура не может сходить на то же поле, где она находится
        if (line == toLine && column == toColumn) return false;
        // Проверка на выход за пределы доски
        else if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        // Проверка, что конь ходит буквой "Г"
        if ((Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) ||
                (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 2)) {
            // Проверка, что на клетку, на которую идет фигура есть фигура противника или она пустая
            return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(color);
        }
        return false;
    }


    public String getSymbol() {
        return "H";
    }
}



