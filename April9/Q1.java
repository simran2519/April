//1. Problem Description
//
//
//
//Given A and B you have to find all stepping numbers in the range A to B (both inclusive).
//
//The stepping number:
//
//A number is called as a stepping number if the adjacent digits have a difference of 1.
//
//For e.g. 123 is a stepping number, but 358 is not a stepping number
//
//
//
//
//
//Problem Constraints
//0 <= A <= 104
//        1 <= B <= 107
//A <= B
//
//
//Input Format
//First argument is an integer A.
//
//Second argument is an integer B.
//
//
//
//
//
//Output Format
//Return a integer array sorted in ascending order denoting the stepping numbers between A and B.
//
//
//
//Example Input
//Input 1:
//
//A = 10
//B = 20
//
//
//
//
//Example Output
//Output 1:
//
//        [10, 12]
//
//
//
//
//Example Explanation
//Explanation 1:
//
//The stepping numbers in range [10, 20] are 10, and 12.
package April9;
import java.util.*;

public class Q1 {

    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Add seed stepping numbers (single digits) to the queue
        for (int i = 1; i <= 9; i++) {
            queue.add(i);
        }

        // Add 0 as a special case for A = 0
        if (A == 0) {
            result.add(0);
        }

        // Perform BFS to find all stepping numbers in the range [A, B]
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num >= A && num <= B) {
                result.add(num);
            }
            if (num > B) {
                continue;
            }
            int lastDigit = num % 10;
            int nextNum1 = num * 10 + lastDigit - 1;
            int nextNum2 = num * 10 + lastDigit + 1;
            if (lastDigit > 0 && nextNum1 <= B) {
                queue.add(nextNum1);
            }
            if (lastDigit < 9 && nextNum2 <= B) {
                queue.add(nextNum2);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Q1 sn = new Q1();
        System.out.println(sn.stepnum(10, 20)); // Output: [10, 12]
    }
}

