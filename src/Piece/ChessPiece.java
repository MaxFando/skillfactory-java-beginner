package Piece;

import Board.ChessBoard;

public abstract class ChessPiece {
    protected String color;
    public boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    protected boolean isInvalidPosition(int line, int column) {
        return line < 0 || line >= 8 || column < 0 || column >= 8;
    }
}
