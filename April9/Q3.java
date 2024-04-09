//3.Given N x M character matrix A of O's and X's, where O = white, X = black.
//
//
//        Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
//
//
//
//
//Input Format:
//
//The First and only argument is a N x M character matrix.
//Output Format:
//
//Return a single integer denoting number of black shapes.
//        Constraints:
//
//        1 <= N,M <= 1000
//A[i][j] = 'X' or 'O'
//Example:
//
//Input 1:
//A = [ OOOXOOO
//        OOXXOXO
//OXOOOXO  ]
//Output 1:
//        3
//Explanation:
//        3 shapes are  :
//        (i)    X
//X X
//        (ii)
//X
//        (iii)
//X
//        X
//Note: we are looking for connected shapes here.
//
//        XXX
//        XXX
//XXX
//is just one single connected black shape.
package April9;

public class Q3 {

    public int black(String[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        int m = A[0].length();
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i].charAt(j) == 'X' && !visited[i][j]) {
                    dfs(A, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(String[] A, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length() || A[i].charAt(j) == 'O' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        dfs(A, visited, i + 1, j);
        dfs(A, visited, i - 1, j);
        dfs(A, visited, i, j + 1);
        dfs(A, visited, i, j - 1);
    }

    public static void main(String[] args) {
        Q3 bs = new Q3();
        String[] A = {
                "OOOXOOO",
                "OOXXOXO",
                "OXOOOXO"
        };
        System.out.println(bs.black(A)); // Output: 3
    }
}
