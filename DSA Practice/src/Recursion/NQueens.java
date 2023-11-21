package Recursion;

public class NQueens {
	static final int N = 4; // Define the size of the chessboard as 4x4

    public static void main(String[] args) {
        int[][] board = new int[4][4]; // Create a 4x4 chessboard
        boolean ansNQueen = nQueen(board, 0); // Find a solution for the N-Queens problem
        System.out.println(ansNQueen); // Print whether a solution exists
    }

    // Function to solve the N-Queens problem
    public static boolean nQueen(int[][] board, int row) {
        if (row == board.length) {
            return true; // If all queens are placed, return true
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) { // If it's safe to place a queen in this cell
                board[row][col] = 1; // Place a queen
                if (nQueen(board, row + 1)) {
                    return true; // Recursively try to solve for the next row
                }

                board[row][col] = 0; // If no solution found, backtrack by removing the queen
            }
        }

        return false; // If no solution is found for the current configuration, return false
    }

    // Function to check if it's safe to place a queen in the current cell
    public static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check this row on the left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false; // Check if another queen is in the same row to the left
            }
        }

        // Check upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false; // Check the upper left diagonal for another queen
            }
        }

        // Check lower diagonal on the left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false; // Check the lower left diagonal for another queen
            }
        }

        return true; // If no conflicts are found, it's safe to place a queen in this cell
    }

}
