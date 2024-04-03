//3.Problem statement
//        Given a ‘N’ * ’M’ maze with obstacles, count and return the number of unique paths to reach the right-bottom cell from the top-left cell. A cell in the given maze has a value '-1' if it is a blockage or dead-end, else 0. From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only. Since the answer can be large, print it modulo 10^9 + 7.
//
//        For Example :
//        Consider the maze below :
//        0 0 0
//        0 -1 0
//        0 0 0
//
//        There are two ways to reach the bottom left corner -
//
//        (1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
//        (1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)
//
//        Hence the answer for the above test case is 2.
//        Detailed explanation ( Input/output format, Notes, Images )
//        Constraints :
//        1 <= T <= 10
//        1 <= N,M <= 200
//
//        Note: It is guaranteed that the top-left cell does not have an obstacle.
//
//        Time Limit: 1 sec
//        Sample Input 1 :
//        2
//        2 2
//        0 0
//        0 0
//        3 3
//        0 0 0
//        0 -1 0
//        0 0 0
//        Sample Output 1 :
//        2
//        2
//        Explanation For Sample Output 1 :
//        For the first test case, there are two possible paths to reach (2, 2) from (1, 1) :
//        (1, 1) -> (1, 2) -> (2, 2)
//        (1, 1) -> (2, 1) -> (2, 2)
//
//        For the second test case, there are two ways to reach the bottom left corner -
//        (1, 1) -> (1, 2) -> (1, 3) -> (2, 3) -> (3, 3)
//        (1, 1) -> (2, 1) -> (3, 1) -> (3, 2) -> (3, 3)
//        Sample Input 2 :
//        1
//        2 2
//        0 -1
//        -1  0
//        Sample Output 2 :
//        0
package April2;

public class Q3 {
    public static int uniquePaths(int N, int M, int[][] maze) {
        int[][] dp = new int[N][M];
        int mod = 1000000007;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == -1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
                }
            }
        }

        return dp[N - 1][M - 1];
    }

    public static void main(String[] args) {
        int[][] maze1 = {
                {0, 0},
                {0, 0}
        };
        int[][] maze2 = {
                {0, -1},
                {-1, 0}
        };
        System.out.println(uniquePaths(2, 2, maze1)); // Output: 2
        System.out.println(uniquePaths(2, 2, maze2)); // Output: 0
    }
}
