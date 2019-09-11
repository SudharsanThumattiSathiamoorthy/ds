package com.sudhar.examples;

public class ValidSudoku {

    public static void main(final String[] args)
    {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(char[][] board) {

        boolean[][] col = new boolean[9][9];
        boolean[][] squ = new boolean[3][9];

        for (int i = 0; i< 9; i++) {

            boolean[] row = new boolean[9];

            if (i %3  == 0) {
                squ = new boolean[3][9];
            }
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {

                    int num = board[i][j] - 49;
                    if (col[j][num] || row[num] || squ[j/3][num]) {
                        return false;
                    } else {
                        col[j][num] = row[num] = squ[j/3][num] = true;
                    }
                }
            }
        }
        return true;
    }

}
