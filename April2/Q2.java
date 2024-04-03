//2.Problem statement
//        Given a chain of matrices A1, A2, A3,.....An. Your task is to find out the minimum cost to multiply these matrices. The cost of matrix multiplication is defined as the number of scalar multiplications. A Chain of matrices A1, A2, A3,.....An is represented by a sequence of numbers in an array ‘arr’ where the dimension of 1st matrix is equal to arr[0] * arr[1] , 2nd matrix is arr[1] * arr[2], and so on.
//
//        For example:
//        For arr[ ] = { 10, 20, 30, 40}, matrix A1 = [10 * 20], A2 = [20 * 30], A3 = [30 * 40]
//
//        Scalar multiplication of matrix with dimension 10 * 20 is equal to 200.
//        Detailed explanation ( Input/output format, Notes, Images )
//        Sample Input 1:
//        2
//        4
//        4 5 3 2
//        4
//        10 15 20 25
//        Sample Output 1:
//        70
//        8000
//        Sample Output Explanation 1:
//        In the first test case, there are three matrices of dimensions A = [4 5], B = [5 3] and C = [3 2]. The most efficient order of multiplication is A * ( B * C).
//        Cost of ( B * C ) = 5 * 3 * 2 = 30  and (B * C) = [5 2] and A * (B * C) = [ 4 5] * [5 2] = 4 * 5 * 2 = 40. So the overall cost is equal to 30 + 40 =70.
//
//        In the second test case, there are two ways to multiply the chain - A1*(A2*A3) or (A1*A2)*A3.
//
//        If we multiply in order- A1*(A2*A3), then the number of multiplications required is 11250.
//
//        If we multiply in order- (A1*A2)*A3, then the number of multiplications required is 8000.
//
//        Thus a minimum number of multiplications required is 8000.
//        Sample Input 2:
//        1
//        4
//        1 4 3 2
//        Sample Output 2:
//        18
//        Explanation of Sample Output 2:
//        In the first test case, there are three matrices of dimensions A = [1 4], B = [4 3] and C = [3 2]. The most efficient order of multiplication is (A *  B) * C .
package April2;

public class Q2 {
    public static int matrixChainOrder(int[] arr) {
        int n = arr.length - 1; // Number of matrices
        int[][] dp = new int[n][n];

        // Initialize dp[i][i] to 0
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // Chain length 'len' from 2 to n-1
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i - 1][j - 1] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = dp[i - 1][k - 1] + dp[k][j - 1] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i - 1][j - 1]) {
                        dp[i - 1][j - 1] = cost;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[][] matrices = {
                {4, 5, 3, 2},
                {10, 15, 20, 25},
                {1, 4, 3, 2}
        };

        for (int[] matrix : matrices) {
            System.out.println(matrixChainOrder(matrix));
        }
    }
}
