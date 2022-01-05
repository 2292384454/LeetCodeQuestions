package leetcode.editor.cn;
//Java：排序矩阵查找

/**
 * <p>给定M&times;N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <p>现有矩阵 matrix 如下：</p>
 *
 * <pre>[
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * </pre>
 *
 * <p>给定 target&nbsp;=&nbsp;<code>5</code>，返回&nbsp;<code>true</code>。</p>
 *
 * <p>给定&nbsp;target&nbsp;=&nbsp;<code>20</code>，返回&nbsp;<code>false</code>。</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>分治</li><li>矩阵</li></div></div><p><div><li>👍 29</li><li>👎 0</li></div>
 */
public class P面试题_1009SortedMatrixSearchLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_1009SortedMatrixSearchLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int m = matrix.length, n = matrix[0].length;
            int x = m - 1, y = 0;
            while (x >= 0 && y < n) {
                if (matrix[x][y] == target) {
                    return true;
                } else if (matrix[x][y] < target) {
                    y++;
                } else {
                    x--;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}