//3.Problem Description
//
//Given a 2D character matrix A of size N x M, containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//
//
//        Problem Constraints
//1 <= N, M <= 103
//
//
//
//Input Format
//First and only argument 2D character matrix A of size N X M.
//
//
//
//Output Format
//Make changes to the the input only as matrix is passed by reference.
//
//
//
//        Example Input
//Input 1:
//
//A = [  [X, X, X, X],
//        [X, O, O, X],
//        [X, X, O, X],
//        [X, O, X, X]
//        ]
//
//
//Example Output
//Output 1:
//
//A = [  [X, X, X, X],
//        [X, X, X, X],
//        [X, X, X, X],
//        [X, O, X, X]
//        ]
//
//
//Example Explanation
//Explanation 1:
//
//        'O' in (4,2) is not surrounded by X from below.
package April5;

import java.util.Arrays;

public class Q3 {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Mark the 'O's on the border and their neighbors as non-flippable
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                markNonFlippable(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                markNonFlippable(board, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                markNonFlippable(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                markNonFlippable(board, rows - 1, j);
            }
        }

        // Flip 'O's that are not marked as non-flippable
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markNonFlippable(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = '-';
        markNonFlippable(board, row - 1, col);
        markNonFlippable(board, row + 1, col);
        markNonFlippable(board, row, col - 1);
        markNonFlippable(board, row, col + 1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        Q3 sr = new Q3();
        sr.solve(board);

        // Print the modified board
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
