//1. Given A, B, C, find whether C is formed by the interleaving of A and B.
//
//Input Format:*
//
//The first argument of input contains a string, A.
//The second argument of input contains a string, B.
//The third argument of input contains a string, C.
//Output Format:
//
//Return an integer, 0 or 1:
//        => 0 : False
//    => 1 : True
//Constraints:
//
//        1 <= length(A), length(B), length(C) <= 150
//Examples:
//
//Input 1:
//A = "aabcc"
//B = "dbbca"
//C = "aadbbcbcac"
//
//Output 1:
//        1
//
//Explanation 1:
//        "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
//
//Input 2:
//A = "aabcc"
//B = "dbbca"
//C = "aadbbbaccc"
//
//Output 2:
//        0
//
//Explanation 2:
//It is not possible to get C by interleaving A and B.
package April4;

public class Q1 {
    public int isInterleave(String A, String B, String C) {
        int m = A.length(), n = B.length();
        if (m + n != C.length()) {
            return 0;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && A.charAt(i - 1) == C.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && B.charAt(j - 1) == C.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
            }
        }

        return dp[m][n] ? 1 : 0;
    }

    public static void main(String[] args) {
        Q1 solution = new Q1();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac")); // Output: 1
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc")); // Output: 0
    }
}

