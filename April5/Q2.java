//2.Given A, B, C, find whether C is formed by the interleaving of A and B.
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

package April5;

public class Q2 {

    public static int isInterleave(String A, String B, String C) {
        int m = A.length();
        int n = B.length();

        if (m + n != C.length()) {
            return 0;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1))
                            || (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
                }
            }
        }

        return dp[m][n] ? 1 : 0;
    }

    public static void main(String[] args) {
        String A1 = "aabcc";
        String B1 = "dbbca";
        String C1 = "aadbbcbcac";
        System.out.println(isInterleave(A1, B1, C1));  // Output: 1

        String A2 = "aabcc";
        String B2 = "dbbca";
        String C2 = "aadbbbaccc";
        System.out.println(isInterleave(A2, B2, C2));  // Output: 0
    }
}

