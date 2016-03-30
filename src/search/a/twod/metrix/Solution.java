package search.a.twod.metrix;

/**
 * Created by yebingxu on 8/18/15.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        /** solution 1 begin **/
        // solution 1 is not fast enough, user solution 2 firstly
        // int i = 0;
        // int j = n-1;

        // while ((i >= 0 && i <= m-1) && (j >= 0 && j <= n-1)) {
        //     if (matrix[i][j] == target) {
        //         return true;
        //     } else if (matrix[i][j] < target) {
        //         i++;
        //     } else {
        //         j--;
        //     }
        // }
        // return false;
        /** solution 1 end **/

        /** solution 2 start **/
        int s = 0;
        int e = m*n - 1;

        while (s + 1 < e) {
            int mid = s + (e-s)/2;
            if (matrix[mid/n][mid%n] == target) {
                return true;
            } else if (matrix[mid/n][mid%n] < target) {
                s = mid;
            } else {
                e = mid;
            }
        }
        if (matrix[s/n][s%n] == target) {
            return true;
        }
        if (matrix[e/n][e%n] == target) {
            return true;
        }
        return false;
        /** solution 2 end **/
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{{1},{3},{5}};
        int target = 0;

        s.searchMatrix(matrix, target);


    }

}
