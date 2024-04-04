//2.Problem Description
//
//        Given a 2D character matrix A of size N x M, containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//        A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//
//
//        Problem Constraints
//        1 <= N, M <= 103
//
//
//
//        Input Format
//        First and only argument 2D character matrix A of size N X M.
//
//
//
//        Output Format
//        Make changes to the the input only as matrix is passed by reference.
//
//
//
//        Example Input
//        Input 1:
//
//        A = [  [X, X, X, X],
//        [X, O, O, X],
//        [X, X, O, X],
//        [X, O, X, X]
//        ]
//
//
//        Example Output
//        Output 1:
//
//        A = [  [X, X, X, X],
//        [X, X, X, X],
//        [X, X, X, X],
//        [X, O, X, X]
//        ]
//
//
//        Example Explanation
//        Explanation 1:
//
//        'O' in (4,2) is not surrounded by X from below.
//

package April3;

public class Q2 {

    public static void captureRegions(char[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return;
        }

        int rows = A.length;
        int cols = A[0].length;

        // Traverse the boundary and mark connected 'O's as visited
        for (int i = 0; i < rows; i++) {
            if (A[i][0] == 'O') {
                markVisited(A, i, 0);
            }
            if (A[i][cols - 1] == 'O') {
                markVisited(A, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (A[0][j] == 'O') {
                markVisited(A, 0, j);
            }
            if (A[rows - 1][j] == 'O') {
                markVisited(A, rows - 1, j);
            }
        }

        // Convert unvisited 'O's to 'X's and restore visited back to 'O's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 'O') {
                    A[i][j] = 'X';
                } else if (A[i][j] == '*') {
                    A[i][j] = 'O';
                }
            }
        }
    }

    private static void markVisited(char[][] A, int row, int col) {
        if (row < 0 || row >= A.length || col < 0 || col >= A[0].length || A[row][col] != 'O') {
            return;
        }

        A[row][col] = '*'; // Mark as visited

        markVisited(A, row + 1, col); // Down
        markVisited(A, row - 1, col); // Up
        markVisited(A, row, col + 1); // Right
        markVisited(A, row, col - 1); // Left
    }

    public static void main(String[] args) {
        char[][] A = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        captureRegions(A);

        for (char[] row : A) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

