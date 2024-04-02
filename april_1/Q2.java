//2.Problem statement
//        You are given a triangular array/list 'TRIANGLE'. Your task is to return the minimum path sum to reach from the top to the bottom row.
//
//        The triangle array will have N rows and the i-th row, where 0 <= i < N will have i + 1 elements.
//
//        You can move only to the adjacent number of row below each step. For example, if you are at index j in row i, then you can move to i or i + 1 index in row j + 1 in each step.
//
//        For Example :
//        If the array given is 'TRIANGLE' = [[1], [2,3], [3,6,7], [8,9,6,1]] the triangle array will look like:
//
//        1
//        2,3
//        3,6,7
//        8,9,6,10
//
//        For the given triangle array the minimum sum path would be 1->2->3->8. Hence the answer would be 14.
//        Detailed explanation ( Input/output format, Notes, Images )
//        Constraints :
//        1 <= T <= 5
//        1 <= N <= 10^3
//        -10^6 <= TRIANGLE[i][pos] <= 10^6 ,
//
//        Where 'TRIANGLE[i][pos]' is the element at row = 'i' & position = 'pos' in triangle array.
//
//        Time limit: 1 sec
//        Sample Input 1 :
//        2
//        4
//        2
//        3 4
//        6 5 7
//        4 1 8 3
//        1
//        -10
//        Sample output 1 :
//        11
//        -10
//        Sample Input explanation:
//        Test case 1:
//        Here our triangle array is:
//
//        2
//        3 4
//        6 5 7
//        4 1 8 3
//
//        In this array, the minimum path will be 2->3->5->1, so the minimum sum path would be 2+3+5+1=11
//
//        Test case 2:
//        In this case, there is one row. Thus, the minimum path will be -10, and the minimum sum path=-10.
//        Sample input 2 :
//        2
//        4
//        1
//        2 3
//        4 5 6
//        7 8 9 10
//        3
//        5
//        -1 3
//        22 1 -9
//        Sample Output 2 :
//        14
//        -1
package april_1;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of test cases
        int t = scanner.nextInt();

        while (t-- > 0) {
            // Input the number of rows
            int n = scanner.nextInt();

            // Input the triangular array
            int[][] triangle = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = scanner.nextInt();
                }
            }

            // Calculate the minimum path sum
            int minPathSum = calculateMinimumPathSum(triangle, n);
            System.out.println(minPathSum);
        }

        scanner.close();
    }

    private static int calculateMinimumPathSum(int[][] triangle, int n) {
        // Bottom-up dynamic programming approach
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // Choose the minimum of the two adjacent numbers in the next row
                triangle[i][j] += Math.min(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        // Minimum path sum will be the value at the top of the triangle
        return triangle[0][0];
    }
}

