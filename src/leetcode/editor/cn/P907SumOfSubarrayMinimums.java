package leetcode.editor.cn;
//Java：子数组的最小值之和

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>给定一个整数数组 <code>arr</code>，找到 <code>min(b)</code> 的总和，其中 <code>b</code> 的范围为 <code>arr</code> 的每个（连续）子数组。</p>
 *
 * <p>由于答案可能很大，因此<strong> 返回答案模 <code>10^9 + 7</code></strong> 。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>arr = [3,1,2,4]
 * <strong>输出：</strong>17
 * <strong>解释：
 * </strong>子数组为<strong> </strong>[3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>arr = [11,81,94,43,3]
 * <strong>输出：</strong>444
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= arr.length <= 3 * 10<sup>4</sup></code></li>
 * <li><code>1 <= arr[i] <= 3 * 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p> </p>
 * <div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>动态规划</li><li>单调栈</li></div></div><p><div><li>👍 260</li><li>👎 0</li></div>
 */
public class P907SumOfSubarrayMinimums {
    public static void main(String[] args) {
        Solution solution = new P907SumOfSubarrayMinimums().new Solution();
        // TO TEST
        int[] arr = new int[]{3, 1, 2, 4};
        System.out.println(solution.sumSubarrayMins(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            long ans = 0;
            final int MOD = 1000000007;
            Deque<Integer> monoStack = new ArrayDeque<>();
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                while (!monoStack.isEmpty() && arr[monoStack.peek()] > arr[i]) {
                    monoStack.pop();
                }
                int k = monoStack.isEmpty() ? (i + 1) : (i - monoStack.peek());
                dp[i] = k * arr[i] + (monoStack.isEmpty() ? 0 : dp[i - k]);
                ans = (ans + dp[i]) % MOD;
                monoStack.push(i);
            }
            return (int) ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}