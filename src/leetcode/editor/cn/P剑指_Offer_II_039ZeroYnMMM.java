package leetcode.editor.cn;
//Java：直方图最大矩形面积

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>给定非负整数数组 <code>heights</code>&nbsp;，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 <code>1</code> 。</p>
 *
 * <p>求在该柱状图中，能够勾勒出来的矩形的最大面积。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <p><img src="https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg" /></p>
 *
 * <pre>
 * <strong>输入：</strong>heights = [2,1,5,6,2,3]
 * <strong>输出：</strong>10
 * <strong>解释：</strong>最大的矩形为图中红色区域，面积为 10
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><img src="https://assets.leetcode.com/uploads/2021/01/04/histogram-1.jpg" /></p>
 *
 * <pre>
 * <strong>输入：</strong> heights = [2,4]
 * <b>输出：</b> 4</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= heights.length &lt;=10<sup>5</sup></code></li>
 * <li><code>0 &lt;= heights[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 84&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/largest-rectangle-in-histogram/">https://leetcode-cn.com/problems/largest-rectangle-in-histogram/</a></p>
 * <div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>单调栈</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_039ZeroYnMMM {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_039ZeroYnMMM().new Solution();
        // TO TEST
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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