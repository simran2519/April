//2.Problem Description
//
//
//
//Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
//
//Assume that there will only be one solution.
//
//
//
//Problem Constraints
//-3 * 108 <= B <= 3 * 108
//        1 <= N <= 104
//        -108 <= A[i] <= 108
//
//
//Input Format
//First argument is an integer array A of size N.
//
//Second argument is an integer B denoting the sum you need to get close to.
//
//
//
//        Output Format
//Return a single integer denoting the sum of three integers which is closest to B.
//
//
//
//        Example Input
//Input 1:
//
//A = [-1, 2, 1, -4]
//B = 1
//Input 2:
//
//
//A = [1, 2, 3]
//B = 6
//
//
//Example Output
//Output 1:
//
//        2
//Output 2:
//
//        6
//
//
//Example Explanation
//Explanation 1:
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
//Explanation 2:
//
//Take all elements to get exactly 6.

package April4;

import java.util.Arrays;

public class Q2 {
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 2; i++) {
            int left = i + 1;
            int right = A.length - 1;

            while (left < right) {
                int sum = A[i] + A[left] + A[right];
                int diff = Math.abs(sum - B);

                if (diff == 0) {
                    return sum;
                }

                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }

                if (sum < B) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        Q2 solution = new Q2();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // Output: 2
        System.out.println(solution.threeSumClosest(new int[]{1, 2, 3}, 6)); // Output: 6
    }
}
