//
//3.Problem Description
//
//
//
//How many minimum numbers from the Fibonacci series are required such that the sum of numbers should be equal to a given Number A?
//Note: repetition of numbers is allowed.
//
//
//        Problem Constraints
//1 <= A <= 109
//
//
//Input Format
//The first argument is an integer A.
//
//
//        Output Format
//Return an integer equal to the minimum number of Fibonacci numbers whose sum is equal to A
//
//
//Example Input
//Input 1:
//A = 4
//Input 2:
//A = 7
//
//
//Example Output
//Output 1:
//        2
//Output 2:
//        2
//
//
//Example Explanation
//Explanation 1:
//Two numbers are required, A = 4 which is equal to (2 + 2)
//Explanation 2:
//Two numbers are required, A = 7 which is equal to (2 + 5)
package April8;
import java.util.ArrayList;
import java.util.List;
public class Q3 {

    public int fibsum(int A) {
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(1);

        // Generate Fibonacci numbers up to A
        int nextFib = 0;
        while ((nextFib = fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2)) <= A) {
            fibonacci.add(nextFib);
        }

        // Count the minimum number of Fibonacci numbers needed to form A
        int count = 0;
        int index = fibonacci.size() - 1;
        while (A > 0) {
            while (fibonacci.get(index) > A) {
                index--;
            }
            A -= fibonacci.get(index);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Q3 fs = new Q3();
        System.out.println(fs.fibsum(4)); // Output: 2
        System.out.println(fs.fibsum(7)); // Output: 2
    }
}

