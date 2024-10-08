package Board;

import Piece.ChessPiece;

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";
                board[endLine][endColumn].check = false;

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean castling0() {
        if (this.nowPlayer.equals("White")) {
            if (this.board[0][0] == null || this.board[0][4] == null) return false;
            if (this.board[0][0].getSymbol().equals("R") && this.board[0][0].check && this.board[0][4].getSymbol().equals("K") && this.board[0][4].check) {
                if (this.board[0][1] == null && this.board[0][2] == null && this.board[0][3] == null) {
                    this.board[0][2] = this.board[0][4];
                    this.board[0][4] = null;
                    this.board[0][3] = this.board[0][0];
                    this.board[0][0] = null;
                    this.nowPlayer = "Black";
                    return true;
                }
            } else return false;
        } else {
            if (this.board[7][0] == null || this.board[7][4] == null) return false;
            if (this.board[7][0].getSymbol().equals("R") && this.board[7][0].check && this.board[7][4].getSymbol().equals("K") && this.board[7][4].check) {
                if (this.board[7][1] == null && this.board[7][2] == null && this.board[7][3] == null) {
                    this.board[7][2] = this.board[7][4];
                    this.board[7][4] = null;
                    this.board[7][3] = this.board[7][0];
                    this.board[7][0] = null;
                    this.nowPlayer = "White";
                    return true;
                }
            } else return false;
        }

        return false;
    }

    public boolean castling7() {
        if (this.nowPlayer.equals("White")) {
            if (this.board[0][7] == null || this.board[0][4] == null) return false;
            if (this.board[0][7].getSymbol().equals("R") && this.board[0][7].check && this.board[0][4].getSymbol().equals("K") && this.board[0][4].check) {
                if (this.board[0][6] == null && this.board[0][5] == null) {
                    this.board[0][6] = this.board[0][4];
                    this.board[0][4] = null;
                    this.board[0][5] = this.board[0][7];
                    this.board[0][7] = null;
                    this.nowPlayer = "Black";
                    return true;
                }
            } else return false;
        } else {
            if (this.board[7][7] == null || this.board[7][4] == null) return false;
            if (this.board[7][7].getSymbol().equals("R") && this.board[7][7].check && this.board[7][4].getSymbol().equals("K") && this.board[7][4].check) {
                if (this.board[7][6] == null && this.board[7][5] == null) {
                    this.board[7][6] = this.board[7][4];
                    this.board[7][4] = null;
                    this.board[7][5] = this.board[7][7];
                    this.board[7][7] = null;
                    this.nowPlayer = "White";
                    return true;
                }
            } else return false;
        }

        return false;
    }
}
