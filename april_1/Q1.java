
//        For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order.
//
//        Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.
//
//        For example:
//        [1, 2, 3, 4] is a strictly increasing array, while [2, 1, 4, 3] is not.
//        Detailed explanation ( Input/output format, Notes, Images )
//        Sample Input :
//        6
//        5 4 11 1 16 8
//        Sample Output 1 :
//        3
//        Explanation of Sample Input 1:
//        Length of longest subsequence is 3 i.e. [5, 11, 16] or [4, 11, 16].
//        Sample Input 2:
//        3
//        1 2 2
//        Sample Output 2 :
//        2
package april_1;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        int n = scanner.nextInt();

        // Input the array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find the length of the longest strictly increasing subsequence
        int maxLength = findLongestIncreasingSubsequence(arr, n);
        System.out.println(maxLength);

        scanner.close();
    }

    private static int findLongestIncreasingSubsequence(int[] arr, int n) {
        int[] lis = new int[n];
        lis[0] = 1;

        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > maxLength) {
                maxLength = lis[i];
            }
        }

        return maxLength;
    }
}
