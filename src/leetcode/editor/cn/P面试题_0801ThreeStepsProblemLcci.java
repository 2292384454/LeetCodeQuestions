package leetcode.editor.cn;
//Java：三步问题

/**
 * <p>三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。</p>
 *
 * <p> <strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：n = 3
 * <strong> 输出</strong>：4
 * <strong> 说明</strong>: 有四种走法
 * </pre>
 *
 * <p> <strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：n = 5
 * <strong> 输出</strong>：13
 * </pre>
 *
 * <p> <strong>提示:</strong></p>
 *
 * <ol>
 * <li>n范围在[1, 1000000]之间</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>记忆化搜索</li><li>数学</li><li>动态规划</li></div></div><p><div><li>👍 59</li><li>👎 0</li></div>
 */
public class P面试题_0801ThreeStepsProblemLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0801ThreeStepsProblemLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToStep(int n) {
            int mod = 1000000007;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - 1]) % mod;
                if (i > 1) {
                    dp[i] = (dp[i] + dp[i - 2]) % mod;
                }
                if (i > 2) {
                    dp[i] = (dp[i] + dp[i - 3]) % mod;
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}