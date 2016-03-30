package range.sum.query.iid.immutable;

/**
 * @author yebingxu
 */
public class NumMatrix {

    // 思路: 动态规划, 根据输入矩阵构建一个新矩阵f,
    //       其中f[i][j]的值表示以matrix[0][0]为左上角, matrix[i][j]为右下角的矩阵的所有元素的sum和
    //   则: sumRegion(x1, y1, x2, y2) = f[x2][y2] - f[x2][y1-1] - f[x1-1][y2] + f[x1-1][y1-1]

    int[][] f;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        // 假设输入矩阵合法
        int m = matrix.length;
        int n = matrix[0].length;
        f = new int[m][n];

        // 构造f的第一行和第一列
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                f[0][0] = matrix[0][0];
            } else {
                f[0][j] = f[0][j-1] + matrix[0][j];
            }
        }
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i-1][0] + matrix[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i][j-1] + f[i-1][j] - f[i-1][j-1] + matrix[i][j];
            }
        }
    }

    // sum
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = f[row2][col2];
        int b = 0; // 用于保存f[row2][col1-1]的值
        int c = 0; // 用于保存f[row1-1][col2]的值
        int d = 0; // 用于保存f[row1-1][col1-1]的值
        if (col1 >= 1) { // col1 - 1 >= 0, 说明col1没有越界
            b = f[row2][col1-1];
        }
        if (row1 >= 1) { // row1 - 1 >= 0, 说明row1没有越界
            c = f[row1-1][col2];
            if (col1 >= 1) {
                d = f[row1-1][col1-1];
            }
        }

        return a - b - c + d;
    }


    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},
                          {5, 6, 3, 2, 1},
                          {1, 2, 0, 1, 5},
                          {4, 1, 0, 1, 7},
                          {1, 0, 3, 0, 5}};
        NumMatrix n = new NumMatrix(matrix);
        int m = n.sumRegion(2, 1, 4, 3);
        System.out.println(m);
    }
}

