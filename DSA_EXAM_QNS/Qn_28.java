package DSA_EXAM_QNS;

public class Qn_28 {
// Explain in brief the Backtracking approach for algorithm design. How it differs with recursion? Explain the N-Queen problem and algorithm using backtracking and analyze its time complexity.

// Backtracking is a systematic way of trying out different sequences of decisions until you find one that "works." It builds a solution incrementally, one decision at a time, and abandons (“backtracks”) a decision as soon as it determines that this choice cannot possibly lead to a valid solution.

// Backtracking vs. Recursion
// Recursion is a programming technique where a function calls itself. It is a general tool used to solve problems that can be broken down into similar sub-problems.
// Backtracking is a specific use of recursion used for searching through all possible configurations in problems (like puzzles or combinatorial problems).
// In backtracking, at each step you make a decision and then recursively explore further decisions.
// If a decision leads to a dead end (i.e., violates a constraint), you undo that decision (backtrack) and try another option.
// Not every recursive algorithm involves such systematic “pruning” of the solution space.


// The N-Queen Problem
// The N-Queen problem asks you to place N queens on an N×N chessboard so that no two queens can attack each other. This means:

// No two queens share the same row.
// No two queens share the same column.
// No two queens share the same diagonal.

// Backtracking Algorithm for N-Queens
// Incremental Placement:
// Start placing queens one column at a time (or one row at a time). For each column, try every row and check if placing a queen there is safe.

// Safety Check (isSafe):
// Before placing a queen, check if:
// The same row already has a queen.
// The upper-left and lower-left diagonals (if placing queens column by column) are free of queens.
// Because queens are placed column by column, you don’t need to check the right side.



// Typical Bound:
// In many analyses, the N-Queen problem is approximated to have a time complexity around O(N!) because the first queen has N choices, the second queen roughly N–1 (in an ideal scenario), and so on. However, the exact bound is hard to pinpoint due to the irregular nature of the pruning process.

// In summary, while the worst-case is exponential, the backtracking algorithm is efficient for many practical values of N due to early elimination of invalid configurations.

}