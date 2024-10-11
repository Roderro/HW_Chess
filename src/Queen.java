public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "Q";
    }

    public Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка на то, что фигура не может сходить на то же поле, где она находится
        if (line == toLine && column == toColumn) return false;
            // Проверка на выход за пределы доски
        else if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        // Проверка на то, что ферзь ходит по прямой или по диагонали
        if (line == toLine || toColumn == column
                || Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            // Проверка, что ферзь не может пройти через фигуры при движении
            if (line == toLine) {
                // По горизонтали
                for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            } else if (toColumn == column) {
                // По вертикали
                for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            } else {
                // По диагонали
                int directionLine = (toLine - line) > 0 ? 1 : -1;
                int directionColumn = (toColumn - column) > 0 ? 1 : -1;
                for (int i = 1; i < Math.abs(toLine - line); i++) {
                    if (chessBoard.board[line + i * directionLine][column + i * directionColumn] != null) {
                        return false;
                    }
                }
            }
        }

        // Проверка, что на клетку, на которую идет фигура есть фигура противника или она пустая
        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(color);
    }

}
