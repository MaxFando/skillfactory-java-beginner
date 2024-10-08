package Piece;

import Board.ChessBoard;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
