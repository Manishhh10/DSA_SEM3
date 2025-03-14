package DSA_EXAM_QNS;
import java.util.*;

public class Qn_28 {
// Explain in brief the Backtracking approach for algorithm design. How it differs with recursion? Explain the N-Queen problem and algorithm using backtracking and analyze its time complexity.

// Backtracking is a systematic way of exploring all potential solutions by making a number of choices and "backtracking" (i.e., undoing the last decision) when a path does not lead to a usable solution. It is particularly useful in restricted satisfaction problems.

// Backtracking vs. Recursion
// Recursion is a general technique where a function calls itself to solve a smaller instance of a problem.
// Backtracking uses recursion but adds a layer of decision-making: it explores choices and undoes (backtracks) them when they lead to dead ends. In other words, every recursive call in backtracking represents a decision point that can be reversed if needed.


// The N-Queen Problem
// The N-Queen problem asks you to place N queens on an N×N chessboard so that no two queens can attack each other. This means:

// No two queens share the same row.
// No two queens share the same column.
// No two queens share the same diagonal.

// Backtracking Algorithm for N-Queens

public class NQueen {
    // Check if a queen can be placed at board[row][col]
    static boolean isSafe(char[][] board, int row, int col) {
        // Check row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') return false;
        }
        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // Check lower-left diagonal
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    
    // Recursive function to solve the board from a given column
    static void solve(char[][] board, int col, List<List<String>> solutions) {
        if (col == board.length) {
            List<String> solution = new ArrayList<>();
            for (char[] row : board)
                solution.add(new String(row));
            solutions.add(solution);
            return;
        }
        
        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, col + 1, solutions);
                board[row][col] = '.';  // Backtrack
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        // Initialize the board with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> solutions = new ArrayList<>();
        solve(board, 0, solutions);
        
        // Print all solutions
        for (List<String> sol : solutions) {
            for (String s : sol) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}

// N-Queen Problem using Backtracking:
// The N-Queen problem involves placing N queens on an N×N chessboard so that no two queens attack each other (i.e., no two queens share the same row, column, or diagonal).

// Algorithm Steps:
// Place Queen Row by Row: Place a queen in the first row, then recursively try to place queens in the subsequent rows.
// Safety Check: For each row, check each column to see if placing a queen there is safe (i.e., no other queen is in the same column or diagonal).
// Backtracking: If no valid column is found for a row, backtrack to the previous row and move the queen to a different column.
// Solution Found: Once queens are placed in all rows, record the solution.

// Typical Bound:
// In many analyses, the N-Queen problem is approximated to have a time complexity around O(N!) because the first queen has N choices, the second queen roughly N–1 (in an ideal scenario), and so on. However, the exact bound is hard to pinpoint due to the irregular nature of the pruning process.

// In summary, while the worst-case is exponential, the backtracking algorithm is efficient for many practical values of N due to early elimination of invalid configurations.

}