package leetcode.editor.cn;
//Java：有序矩阵中第 K 小的元素

/**
 * <p>给你一个 <code>n x n</code><em> </em>矩阵 <code>matrix</code> ，其中每行和每列元素均按升序排序，找到矩阵中第 <code>k</code> 小的元素。<br />
 * 请注意，它是 <strong>排序后</strong> 的第 <code>k</code> 小元素，而不是第 <code>k</code> 个 <strong>不同</strong> 的元素。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * <strong>输出：</strong>13
 * <strong>解释：</strong>矩阵中的元素为 [1,5,9,10,11,12,13,<strong>13</strong>,15]，第 8 小元素是 13
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>matrix = [[-5]], k = 1
 * <strong>输出：</strong>-5
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>n == matrix.length</code></li>
 * <li><code>n == matrix[i].length</code></li>
 * <li><code>1 <= n <= 300</code></li>
 * <li><code>-10<sup>9</sup> <= matrix[i][j] <= 10<sup>9</sup></code></li>
 * <li>题目数据 <strong>保证</strong> <code>matrix</code> 中的所有行和列都按 <strong>非递减顺序</strong> 排列</li>
 * <li><code>1 <= k <= n<sup>2</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>矩阵</li><li>排序</li><li>堆（优先队列）</li></div></div><p><div><li>👍 616</li><li>👎 0</li></div>
 */
public class P378KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new P378KthSmallestElementInASortedMatrix().new Solution();
        // TO TEST
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(solution.kthSmallest(matrix, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int[][] copy = new int[m][n];
            for (int i = 0; i < m; i++) {
                System.arraycopy(matrix[i], 0, copy[i], 0, n);
            }
            int ans = 0;
            for (int i = 0; i < k; i++) {
                //出堆
                ans = copy[0][0];
                copy[0][0] = Integer.MAX_VALUE;
                int x = 0, y = 0;
                while (true) {
                    int left = x + 1 < m ? copy[x + 1][y] : Integer.MAX_VALUE;
                    int right = y + 1 < n ? copy[x][y + 1] : Integer.MAX_VALUE;
                    if (left >= copy[x][y] && right >= copy[x][y]) {
                        break;
                    }
                    if (left < right) {
                        swap(copy, x, y, ++x, y);
                    } else {
                        swap(copy, x, y, x, ++y);
                    }
                }
            }
            return ans;
        }

        private void swap(int[][] mat, int i1, int j1, int i2, int j2) {
            int temp = mat[i1][j1];
            mat[i1][j1] = mat[i2][j2];
            mat[i2][j2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}