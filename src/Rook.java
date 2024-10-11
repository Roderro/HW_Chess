public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "R";
    }

    public Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка на то, что фигура не может сходить на то же поле, где она находится
        if (line == toLine && column == toColumn) return false;
        // Проверка на выход за пределы доски
        else if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        // Проверка на то, что ладья ходит по прямой
        if (line == toLine) {
            // Проверка на то, что ладья не может пройти через фигуры движение по горизонтали
            for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++) {
                if (chessBoard.board[line][i] != null) {
                    return false;
                }
            }
        } else if (toColumn == column) {
            // Проверка на то, что ладья не может пройти через фигуры движение по вертикали
            for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {
                if (chessBoard.board[i][column] != null) {
                    return false;
                }
            }
        } else return false;
        // Проверка, что на клетку, на которую идет фигура есть фигура противника или она пустая
        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(color);
    }

}
