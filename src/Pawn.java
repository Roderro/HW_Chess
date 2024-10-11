public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "P";
    }

    public Boolean canMoveToPosition(ChessBoard chessBoard,
                                     int line, int column, int toLine, int toColumn) {
        // Проверка на то, что фигура не может сходить на то же поле, где она находится
        if (line == toLine && column == toColumn) return false;
        // Проверка на выход за пределы доски
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        //Проверка на атаку пешкой наискосок
        if (Math.abs(toColumn - column) == 1 && Math.abs(toLine - line) == 1
                && chessBoard.board[toLine][toColumn] != null) {
            if (!chessBoard.board[toLine][toColumn].getColor().equals(color)
                    && ((color.equals("White") && toLine > line) || (color.equals("Black") && toLine < line)))
                return true;
        }

        //Проверка, что пешка идет вперед на свободное поле
        if (column == toColumn && chessBoard.board[toLine][toColumn] == null) {
            if (color.equals("White")) {
                if (line == 1) return toLine - line == 1 || toLine - line == 2
                        && chessBoard.board[toLine - 1][toColumn] == null;
                else return toLine - line == 1;
            } else if (color.equals("Black")) {
                if (line == 6) return line - toLine == 1
                        || line - toLine == 2 && chessBoard.board[line - 1][toColumn] == null;
                else return line - toLine == 1;
            }
            return false;
        }
        return false;
    }
}

