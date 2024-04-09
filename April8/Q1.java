//1.Problem Description
//
//There are A coins (Assume A is even) in a line.
//
//Two players take turns to take a coin from one of the ends of the line until there are no more coins left.
//
//The player with the larger amount of money wins, Assume that you go first.
//
//Return the maximum amount of money you can win.
//
//        NOTE:
//
//You can assume that opponent is clever and plays optimally.
//
//
//Problem Constraints
//1 <= length(A) <= 500
//
//        1 <= A[i] <= 105
//
//
//
//Input Format
//The first and the only argument of input contains an integer array A.
//
//
//
//        Output Format
//Return an integer representing the maximum amount of money you can win.
//
//
//
//Example Input
//Input 1:
//
//A = [1, 2, 3, 4]
//Input 2:
//
//A = [5, 4, 8, 10]
//
//
//Example Output
//Output 1:
//
//        6
//Output 2:
//
//        15
//
//
//Example Explanation
//Explanation 1:
//
//You      : Pick 4
//Opponent : Pick 3
//You      : Pick 2
//Opponent : Pick 1
//
//
//Total money with you : 4 + 2 = 6
//
//Explanation 2:
//
//You      : Pick 10
//Opponent : Pick 8
//You      : Pick 5
//Opponent : Pick 4
//
//
//Total money with you : 10 + 5 = 15
package April8;

public class Q1 {

    public int maxMoney(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];

        // Initialize the dp array for single coins
        for (int i = 0; i < n; i++) {
            dp[i][i] = A[i];
        }

        // Fill the dp array for coins taking 2 at a time, 3 at a time, and so on
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int a = i + 2 <= j ? dp[i + 2][j] : 0;
                int b = i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0;
                int c = i <= j - 2 ? dp[i][j - 2] : 0;
                dp[i][j] = Math.max(A[i] + Math.min(a, b), A[j] + Math.min(b, c));
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Q1 cil = new Q1();
        int[] A1 = {1, 2, 3, 4};
        int[] A2 = {5, 4, 8, 10};
        System.out.println(cil.maxMoney(A1)); // Output: 6
        System.out.println(cil.maxMoney(A2)); // Output: 15
    }
}

