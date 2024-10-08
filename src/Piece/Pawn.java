package Piece;

import Board.ChessBoard;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int direction = this.color.equals("White") ? -1 : 1;
        int startLine = this.color.equals("White") ? 6 : 1;

        if (line == startLine) {
            return (toLine == line + direction || toLine == line + 2 * direction) && toColumn == column;
        } else {
            return toLine == line + direction && toColumn == column;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}