package SudokuHW1;

import java.util.Scanner;

public interface Main {
    public static void main(String[] args) {
        SudokuCreator sudokuGenerator = new SudokuCreator();
        SudokuSolver sudokuSolver = new SudokuSolver();
        System.out.println("Sudoku of the day: \n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Press 'C' for creating sudoku board.");
        String x = scan.next();
        if (x.equalsIgnoreCase("C")) {
            sudokuGenerator.generateRandomTable(30);
            sudokuSolver.display();
        } else {
            System.out.println("Enter 'C' for creating!");
        }
        System.out.println("Press 'S' for the solved board.");
        String y = scan.next();
        if (y.equalsIgnoreCase("S")) {
            if (sudokuSolver.solve()) {
                System.out.println("\nThe solution of Sudoku: \n");
                sudokuSolver.display();
            } else {
                System.out.println("\n\nThis Sudoku is unsolvable.");
            }
        } else {
            System.out.println("Press 'S' for solving!");
        }

    }


}
