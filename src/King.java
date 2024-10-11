public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "K";
    }

    public Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка на то, что фигура не может сходить на то же поле, где она находится
        if (line == toLine && column == toColumn) return false;
        // Проверка на выход за пределы доски
        else if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        // Проверка на то, что король ходит на одну клетку
        if (Math.abs(toLine - line) > 1 || Math.abs(toColumn - column) > 1) {
            return false;
        }
        // Проверка, что на клетку, на которую идет фигура есть фигура противника или она пустая
        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(color);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        // Проверка на атаку со стороны всех фигур противника
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null && !board.board[i][j].getColor().equals(color)) {
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

