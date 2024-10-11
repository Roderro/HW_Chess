public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "B";
    }

    public Boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // Проверка на то, что фигура не может сходить на то же поле, где она находится
        if (line == toLine && column == toColumn) return false;
        // Проверка на выход за пределы доски
        else if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) return false;
        // Проверка, что слон ходит по диагонали
        if(Math.abs(toLine - line) == Math.abs(toColumn - column)){
            int directionLine = (toLine - line) > 0 ? 1 : -1;
            int directionColumn = (toColumn - column) > 0 ? 1 : -1;
            //Проверка, что на пути слона нет других фигур
            for (int i = 1; i < Math.abs(toLine - line); i++) {
                if (chessBoard.board[line + i * directionLine][column + i * directionColumn] != null) {
                    return false;
                }
            }
        }else return false;
        // Проверка, что на клетку, на которую идет фигура есть фигура противника или она пустая
        return chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(color);
    }
}
