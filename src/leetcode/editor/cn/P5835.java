package leetcode.editor.cn;

/**
 * 描述.
 * <p>
 * 创建时间: 2021/8/21 22:43
 *
 * @author KevinHwang
 */
public class P5835 {
    public static void main(String[] args) {
        P5835 solution = new P5835();
        int[][] mat = new int[][]{{-3, 0, 0}, {0, 0, 0}, {0, 3, 2}};
        System.out.println(solution.maxMatrixSum(mat));
    }

    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        // 先记录下当前方阵和
        int posSum = 0, maxNeg = Integer.MIN_VALUE, negCnt = 0, negSum = 0;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= 0) {
                    posSum += matrix[i][j];
                } else {
                    negCnt += 1;
                    negSum += matrix[i][j];
                    if (matrix[i][j] > maxNeg) {
                        maxNeg = matrix[i][j];
                        x = i;
                        y = j;
                    }

                }
            }
        }
        if (negCnt % 2 == 1) {
            // 如果负数个数为奇数
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (x != i || y != j) {
                        matrix[i][j] = Math.abs(matrix[i][j]);
                    }
                    sum += matrix[i][j];
                }
            }
            if (x > 0 && matrix[x - 1][y] == 0) {
                sum += (-2 * matrix[x][y]);
            }
            else if (x < n - 1 && matrix[x + 1][y] == 0) {
                sum += (-2 * matrix[x][y]);
            }
            else if (y > 0 && matrix[x][y - 1] == 0) {
                sum += (-2 * matrix[x][y]);
            }
            else if (y < n - 1 && matrix[x][y + 1] == 0) {
                sum += (-2 * matrix[x][y]);
            }
            return sum;
        } else {
            // 如果负数个数为偶数
            return posSum - negSum;
        }
    }
}
