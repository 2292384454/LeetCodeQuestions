package leetcode.editor.cn;
//Java：矩阵中最大的矩形

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>给定一个由&nbsp;<code>0</code> 和 <code>1</code>&nbsp;组成的矩阵 <code>matrix</code>&nbsp;，找出只包含 <code>1</code> 的最大矩形，并返回其面积。</p>
 *
 * <p><strong>注意：</strong>此题 <code>matrix</code>&nbsp;输入格式为一维 <code>01</code> 字符串数组。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg" style="width: 402px; height: 322px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>matrix = ["10100","10111","11111","10010"]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>最大矩形如上图所示。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>matrix = []
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>matrix = ["0"]
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>matrix = ["1"]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p><strong>示例 5：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>matrix = ["00"]
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>rows == matrix.length</code></li>
 * <li><code>cols == matrix[0].length</code></li>
 * <li><code>0 &lt;= row, cols &lt;= 200</code></li>
 * <li><code>matrix[i][j]</code> 为 <code>'0'</code> 或 <code>'1'</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p>注意：本题与主站 85 题相同（输入参数格式不同）：&nbsp;<a href="https://leetcode-cn.com/problems/maximal-rectangle/">https://leetcode-cn.com/problems/maximal-rectangle/</a></p>
 * <div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>动态规划</li><li>矩阵</li><li>单调栈</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_040PLYXKQ {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_040PLYXKQ().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(String[] matrix) {
            int m = matrix.length;
            if (m == 0) {
                return 0;
            }
            int n = matrix[0].length();
            if (n == 0) {
                return 0;
            }
            // heights[i] 表示以当前行为结尾，某一列的最高高度
            int[] heights = new int[n];
            int ans = 0;
            for (String s : matrix) {
                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) == '0') {
                        heights[j] = 0;
                    } else {
                        heights[j]++;
                    }
                }
                ans = Math.max(ans, largestRectangleArea(heights));
            }
            return ans;
        }

        // 直方图最大矩形面积
        public int largestRectangleArea(int[] heights) {
            // 单调递增栈
            Deque<Integer> stack = new LinkedList<>();
            int n = heights.length;
            // leftArea[i] 记录从位置 i 向左延伸能达到的最大面积（包含自身）
            int[] leftArea = new int[n];
            // leftArea[i] 记录从位置 i 向右延伸能达到的最大面积（包含自身）
            int[] rightArea = new int[n];
            stack.push(-1);
            for (int i = 0; i < n; i++) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                leftArea[i] = heights[i] * (i - stack.peek());
                stack.push(i);
            }
            stack.clear();
            stack.push(n);
            for (int i = n - 1; i >= 0; i--) {
                while (stack.peek() != n && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                rightArea[i] = heights[i] * (stack.peek() - i);
                stack.push(i);
            }
            // 计算真实面积（左+右-自己）
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, leftArea[i] + rightArea[i] - heights[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}