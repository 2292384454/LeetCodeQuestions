package leetcode.editor.cn;
//Java：旋转矩阵

/**
 * <p>给你一幅由 <code>N × N</code> 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。</p>
 *
 * <p>不占用额外内存空间能否做到？</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * 给定 <strong>matrix</strong> =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 *
 * <strong>原地</strong>旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * 给定 <strong>matrix</strong> =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 *
 * <strong>原地</strong>旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * </pre>
 *
 * <p><strong>注意</strong>：本题与主站 48 题相同：<a href="https://leetcode-cn.com/problems/rotate-image/">https://leetcode-cn.com/problems/rotate-image/</a></p>
 * <div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>矩阵</li></div></div><p><div><li>👍 172</li><li>👎 0</li></div>
 */
public class P面试题_0107RotateMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0107RotateMatrixLcci().new Solution();
        // TO TEST
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            // 先水平翻转
            horizontalFlip(matrix);
            // 再按照 / 对角线翻转
            diagonalFlip(matrix);
        }

        public void horizontalFlip(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < (n >> 1); j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = temp;
                }
            }
        }

        public void diagonalFlip(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                    matrix[n - 1 - j][n - 1 - i] = temp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}