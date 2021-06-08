//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
//
// 
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
//
// 
//
// 示例： 
//
// 
//给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设矩阵不可变。 
// 会多次调用 sumRegion 方法。 
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。 
// 
// Related Topics 动态规划 
// 👍 251 👎 0

package leetcode.editor.cn;

//Java：二维区域和检索 - 矩阵不可变
public class P304RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new P304RangeSumQuery2dImmutable().new NumMatrix(matrix);
        // TO TEST
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        int[][] numMatrix;//numMatrix[i][j]存储矩阵matrix以(0,0)为左上角，(i,j)为右下角的子矩阵的元素和

        public NumMatrix(int[][] matrix) {
            int rows = matrix.length, columns = matrix[0].length;
            numMatrix = new int[rows][columns];
            numMatrix[0][0] = matrix[0][0];
            for (int j = 1; j < columns; j++) {
                numMatrix[0][j] = numMatrix[0][j - 1] + matrix[0][j];//填充numMatrix第一行
            }
            for (int i = 1; i < rows; i++) {
                int tempSum = 0;
                for (int j = 0; j < columns; j++) {
                    tempSum += matrix[i][j];
                    numMatrix[i][j] = numMatrix[i - 1][j] + tempSum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = numMatrix[row2][col2];
            if (row1 > 0) {
                sum -= numMatrix[row1 - 1][col2];//减去上方
            }
            if (col1 > 0) {
                sum -= numMatrix[row2][col1 - 1];//减去左边
            }
            if (row1 > 0 && col1 > 0) {
                sum += numMatrix[row1 - 1][col1 - 1];//加上被重复减去的左上角
            }
            return sum;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
