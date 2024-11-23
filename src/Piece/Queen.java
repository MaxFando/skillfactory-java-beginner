package Piece;

import Board.ChessBoard;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.isInvalidPosition(line, column) || isInvalidPosition(toLine, toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        if (line != toLine && column != toColumn) {
            if (Math.abs(line - toLine) != Math.abs(column - toColumn)) {
                return false;
            }
        }

        if (line == toLine) {
            // Движение по горизонтали
            int minCol = Math.min(column, toColumn);
            int maxCol = Math.max(column, toColumn);
            for (int c = minCol + 1; c < maxCol; c++) {
                if (chessBoard.board[line][c] != null) {
                    return false;
                }
            }
        } else if (column == toColumn) {
            // Движение по вертикали
            int minLine = Math.min(line, toLine);
            int maxLine = Math.max(line, toLine);
            for (int l = minLine + 1; l < maxLine; l++) {
                if (chessBoard.board[l][column] != null) {
                    return false;
                }
            }
        } else {
            // Движение по диагонали
            int minLine = Math.min(line, toLine);
            int maxLine = Math.max(line, toLine);
            int minCol = Math.min(column, toColumn);
            int maxCol = Math.max(column, toColumn);
            for (int l = minLine + 1, c = minCol + 1; l < maxLine; l++, c++) {
                if (chessBoard.board[l][c] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
