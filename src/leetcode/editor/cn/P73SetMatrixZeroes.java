//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2: 
//
// 输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//] 
//
// 进阶: 
//
// 
// 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个常数空间的解决方案吗？ 
// 
// Related Topics 数组 
// 👍 381 👎 0

package leetcode.editor.cn;

//Java：矩阵置零
public class P73SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new P73SetMatrixZeroes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean firstColFlag = false;
            //如果第一列有0，firstColFlag置true
            for (int[] ints : matrix) {
                if (ints[0] == 0) {
                    firstColFlag = true;
                    break;
                }
            }
            //如果第一行有0，将matrix[0][0]置零
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    matrix[0][0] = 0;
                    break;
                }
            }
            //遍历除了第一行和第一列的整个数组，如果第i行第j列的元素为0，那么就将第i行第0列和第0行第j列元素置0
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < m; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            //如果matrix[0][0]为0，说明第0行全部要置0
            if (matrix[0][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }
            //如果firstColFlag为true，说明第0列全部要置0
            if (firstColFlag) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
