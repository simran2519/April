//2.Problem Description
//
//
//
//Given an array A of N integers, find the index of values that satisfy P + Q = R + S, where P, Q, R & S are integers values in the array
//
//Expected time complexity O(N2)
//
//NOTE:
//        1) Return the indices A1 B1 C1 D1, so that
//A[A1] + A[B1] = A[C1] + A[D1]
//A1 < B1, C1 < D1
//A1 < C1, B1 != D1, B1 != C1
//2) If there are more than one solutions,
//then return the tuple of values which are lexicographical smallest.
//
//Assume we have two solutions
//S1 : A1 B1 C1 D1 ( these are values of indices in the array )
//S2 : A2 B2 C2 D2
//
//S1 is lexicographically smaller than S2 if:
//A1 < A2 OR
//A1 = A2 AND B1 < B2 OR
//A1 = A2 AND B1 = B2 AND C1 < C2 OR
//A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
//If no solution is possible, return an empty list.
//
//
//        Problem Constraints
//1 <= N <= 1000
//
//        0 <= A[i] <= 1000
//
//
//
//Input Format
//First and only argument is an integer array A of length N.
//
//
//
//Output Format
//Return an array of size four which contains indices of values P, Q, R, and S.
//
//
//
//        Example Input
//Input 1:
//
//A = [3, 4, 7, 1, 2, 9, 8]
//Input 2:
//
//A = [2, 5, 1, 6]
//
//
//Example Output
//Output 1:
//
//        [0, 2, 3, 5]
//Output 2:
//
//        [0, 1, 2, 3]
//
//
//Example Explanation
//Explanation 1:
//
//A[0] + A[2] = A[3] + A[5]
//Note: indexes returned should be 0-based.
//        Explanation 2:
//
//A[0] + A[1] = A[2] + A[3]
package April9;

import java.util.*;

public class Q2 {

    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A.get(i) + A.get(j);
                if (map.containsKey(sum)) {
                    ArrayList<Integer> list = map.get(sum);
                    int p = list.get(0);
                    int q = list.get(1);
                    if (p < q && i < j && p < i && q != j && q != i) {
                        result.add(p);
                        result.add(q);
                        result.add(i);
                        result.add(j);
                        return result;
                    }
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(sum, list);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Q2 es = new Q2();
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8));
        System.out.println(es.equal(A1)); // Output: [0, 2, 3, 5]

        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(2, 5, 1, 6));
        System.out.println(es.equal(A2)); // Output: [0, 1, 2, 3]
    }
}

