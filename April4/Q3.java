//3.Problem Description
//
//
//
//Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.
//
//Note: Using the library sort function is not allowed.
//
//
//
//Problem Constraints
//1 <= N <= 1000000
//        0 <= A[i] <= 2
//
//
//Input Format
//First and only argument of input contains an integer array A.
//
//
//        Output Format
//Return an integer array in asked order
//
//
//Example Input
//Input 1 :
//A = [0 1 2 0 1 2]
//Input 2:
//
//A = [0]
//
//
//Example Output
//Output 1:
//        [0 0 1 1 2 2]
//Output 2:
//
//        [0]
//
//
//Example Explanation
//Explanation 1:
//        [0 0 1 1 2 2] is the required order.
package April4;

import java.util.Arrays;

public class Q3 {
    public void sortColors(int[] A) {
        int low = 0, mid = 0, high = A.length - 1;

        while (mid <= high) {
            if (A[mid] == 0) {
                swap(A, low, mid);
                low++;
                mid++;
            } else if (A[mid] == 1) {
                mid++;
            } else {
                swap(A, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        Q3 solution = new Q3();
        int[] A1 = {0, 1, 2, 0, 1, 2};
        solution.sortColors(A1);
        System.out.println(Arrays.toString(A1)); // Output: [0, 0, 1, 1, 2, 2]

        int[] A2 = {0};
        solution.sortColors(A2);
        System.out.println(Arrays.toString(A2)); // Output: [0]
    }
}

