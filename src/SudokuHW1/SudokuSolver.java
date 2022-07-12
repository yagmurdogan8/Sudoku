package SudokuHW1;

public class SudokuSolver {
    public static char[][] board;
    public static final char EMPTY_PLACE = ' ';
    public final char assignableChars[] = {'C', 'N', 'G', 'B', 'I', 'M', '2', '1', '3'};

    private boolean isInRow(int row, char element) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == element) {
                return false;
            }
        }
        return true;
    }

    private boolean isInColumn(int col, char element) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == element) {
                return false;
            }
        }
        return true;
    }

    //check if possible in box or not
    private boolean isInBox(int row, int col, char element) {
        for (int i = row - (row % 3); i < row - (row % 3) + 3; i++) {
            for (int j = col - (col % 3); j < col - (col % 3) + 3; j++) {
                if (board[i][j] == element) {
                    return false;
                }
            }
        }
        return true;
    }

    //check possibility for position for both row and column
    public boolean isOk(int row, int col, char element) {
        return isInRow(row, element) && isInColumn(col, element) && isInBox(row, col, element);
    }

    public void display() {
        System.out.println("*******************************");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("*******************************");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + board[i][j] + " ");
                if (j == 8) {
                    System.out.print("|");
                }
            }
            System.out.println("");
        }
        System.out.println("*******************************");
    }


    public boolean solve() {
        for (int i = 0; i < 9; i++) { //row
            for (int j = 0; j < 9; j++) { //column
                if (board[i][j] == EMPTY_PLACE) {
                    for (int index = 0; index < 9; index++) {
                        if (isOk(i, j, assignableChars[index])) {
                            board[i][j] = assignableChars[index];
                            if (solve()) {
                                return true;
                            } else { //tell empty and continue
                                board[i][j] = EMPTY_PLACE;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}

