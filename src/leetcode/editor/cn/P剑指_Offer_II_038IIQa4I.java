package leetcode.editor.cn;
//Java：每日温度

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>请根据每日 <code>气温</code> 列表 <code>temperatures</code>&nbsp;，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用&nbsp;<code>0</code> 来代替。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> <code>temperatures</code> = [73,74,75,71,69,72,76,73]
 * <strong>输出:</strong>&nbsp;[1,1,4,2,1,1,0,0]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> temperatures = [30,40,50,60]
 * <strong>输出:</strong>&nbsp;[1,1,1,0]
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> temperatures = [30,60,90]
 * <strong>输出: </strong>[1,1,0]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;=&nbsp;temperatures.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>30 &lt;=&nbsp;temperatures[i]&nbsp;&lt;= 100</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 739&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/daily-temperatures/">https://leetcode-cn.com/problems/daily-temperatures/</a></p>
 * <div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>单调栈</li></div></div><p><div><li>👍 4</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_038IIQa4I {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_038IIQa4I().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new LinkedList<>();
            int n = temperatures.length;
            int[] ans = new int[n];
            stack.push(-1);
            for (int i = n - 1; i >= 0; i--) {
                while (stack.peek() != -1 && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                ans[i] = Math.max(stack.peek() - i, 0);
                stack.push(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}