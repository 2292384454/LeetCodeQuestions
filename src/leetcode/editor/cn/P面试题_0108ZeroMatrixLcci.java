package leetcode.editor.cn;
//Java：零矩阵

import java.util.Arrays;

/**
 * <p>编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * <strong>输出：</strong>
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * <strong>输出：</strong>
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * </pre>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>矩阵</li></div></div><p><div><li>👍 31</li><li>👎 0</li></div>
 */
public class P面试题_0108ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0108ZeroMatrixLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int m = matrix.length, n = matrix[0].length;
            boolean[] expandRow = new boolean[n];
            boolean[] expandCol = new boolean[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        expandRow[j] = true;
                        expandCol[i] = true;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                if (expandCol[i]) {
                    Arrays.fill(matrix[i], 0);
                }
            }
            for (int j = 0; j < n; j++) {
                if (expandRow[j]) {
                    for (int i = 0; i < m; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}