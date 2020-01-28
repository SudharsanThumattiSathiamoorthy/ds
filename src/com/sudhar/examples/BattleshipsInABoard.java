package com.sudhar.examples;

public class BattleshipsInABoard {

    public static void main(String[] args) {
        char board[][] = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };

        int shipsCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if ((i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
                        shipsCount++;
                    }
                }
            }
        }

        System.out.println("Ships count: " + shipsCount);

    }
}
