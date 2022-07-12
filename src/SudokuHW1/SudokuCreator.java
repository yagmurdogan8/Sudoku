package SudokuHW1;

import java.util.Random;

public class SudokuCreator extends SudokuSolver {
    public static final int SIZE = 9;

    public SudokuCreator() {
        board = new char[SIZE][SIZE];
    }

    public void generateRandomTable(int bound) {
        board = new char[9][9]; //new sudoku mat
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = getRandomChar(i, j, bound);
            }
        }
    }

    public char getRandomChar(int row, int col, int bound) {
        Random ran = new Random();
        int randomIndices = ran.nextInt(bound);
        if (randomIndices < 9) {
            if (isOk(row, col, assignableChars[randomIndices])) {
                return assignableChars[randomIndices];
            } else {
                return getRandomChar(row, col, bound);
            }
        } else {
            return EMPTY_PLACE;
        }
    }
}
