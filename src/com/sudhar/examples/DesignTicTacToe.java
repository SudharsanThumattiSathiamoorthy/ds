package com.sudhar.examples;

public class DesignTicTacToe {

    int[] cols;
    int[] rows;
    int diagnalCount;
    int invertedDiagnalCount;

    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        cols = new int[n];
        rows = new int[n];
        diagnalCount = 0;
        invertedDiagnalCount = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;

        rows[row] += val;
        cols[col] += val;

        if (row == col) {
            diagnalCount += val;
        }

        if (col == (cols.length - row - 1)) {
            invertedDiagnalCount += val;
        }

        int targetSize = rows.length;

        if (Math.abs(rows[row]) == targetSize ||
            Math.abs(cols[col]) == targetSize ||
            Math.abs(diagnalCount) == targetSize ||
            Math.abs(invertedDiagnalCount) == targetSize) {
            return player;
        }
        return 0;
    }

}
