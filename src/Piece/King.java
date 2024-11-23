package Piece;

import Board.ChessBoard;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isInvalidPosition(line, column) || isInvalidPosition(toLine, toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        int lineDiff = Math.abs(toLine - line);
        int columnDiff = Math.abs(toColumn - column);

        if (lineDiff > 1 || columnDiff > 1) {
            return false;
        }

        ChessPiece destinationPiece = chessBoard.board[toLine][toColumn];
        if (destinationPiece != null && destinationPiece.getColor().equals(this.getColor())) {
            return false;
        }

        return !isUnderAttack(chessBoard, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    private boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.board[i][j];
                if (piece != null && !piece.getColor().equals(this.getColor())) {
                    if (piece.canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
