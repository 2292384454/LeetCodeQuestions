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

    public class Solution {

        public int sumSubarrayMins(int[] A) {
            final int MOD = 1000000007;
            int n = A.length;

            // 第 1 步：单调栈计算当前下标 i 的左边第 1 个比 A[i] 小的元素的下标
            Deque<Integer> stack1 = new LinkedList<>();
            int[] prev = new int[n];
            for (int i = 0; i < n; i++) {
                while (!stack1.isEmpty() && A[i] <= A[stack1.peek()]) {
                    stack1.pop();
                }
                prev[i] = stack1.isEmpty() ? -1 : stack1.peek();
                stack1.push(i);
            }

            // 第 2 步：单调栈计算当前下标 i 的右边第 1 个比 A[i] 小的元素的下标
            Deque<Integer> stack2 = new LinkedList<>();
            int[] next = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                while (!stack2.isEmpty() && A[i] < A[stack2.peek()]) {
                    stack2.pop();
                }
                next[i] = stack2.isEmpty() ? n : stack2.peek();
                stack2.push(i);
            }

            // 第 3 步：计算结果
            long ans = 0;
            for (int i = 0; i < n; ++i) {
                // 注意：乘法可能越界，须要先转成 long 类型
                ans += (long) (i - prev[i]) * (next[i] - i) % MOD * A[i] % MOD;
                ans %= MOD;
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}