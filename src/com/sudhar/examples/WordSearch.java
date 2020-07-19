package com.sudhar.examples;

public class WordSearch {
    private int[] rowDirs = {0, 0, -1, 1};
    private int[] colDirs = {-1, 1, 0, 0};

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "ABCCED"));
    }

    public boolean exist(char[][] board, String word) {

        final boolean[][] used = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {

                    if(helper(board, used, word, 0, i, j)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, boolean[][] used,
                           String word, int index, int i, int j) {


        if(index >= word.length()) {
            return true;
        } else if(isValid(board, used, i, j) && board[i][j] == word.charAt(index)) {

            used[i][j] = true;

            for(int k = 0; k < 4; k++) {

                int r = i + rowDirs[k];
                int c = j + colDirs[k];

                if(helper(board, used, word, index + 1, r, c)) {
                    return true;
                }
            }

            used[i][j] = false;
        }
        return false;
    }

    private boolean isValid(char[][] board, boolean[][] used, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && ! used[row][col];
    }
}
