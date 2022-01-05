package leetcode.editor.cn;
//Java：布尔运算

/**
 * <p>给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 <code>0</code> (false)、<code>1</code> (true)、<code>&amp;</code> (AND)、 <code>|</code> (OR) 和 <code>^</code> (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入: </strong>s = &quot;1^0|0|1&quot;, result = 0
 *
 * <strong>输出: </strong>2
 * <strong>解释:</strong>&nbsp;两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>s = &quot;0&amp;0&amp;0&amp;1^1|0&quot;, result = 1
 *
 * <strong>输出: </strong>10</pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>运算符的数量不超过 19 个</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>记忆化搜索</li><li>字符串</li><li>动态规划</li></div></div><p><div><li>👍 45</li><li>👎 0</li></div>
 */
public class P面试题_0814BooleanEvaluationLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0814BooleanEvaluationLcci().new Solution();
        // TO TEST
        System.out.println(solution.countEval("1^0|0|1", 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countEval(String s, int result) {
            int n = s.length();
            // dp[i][j][0] 表示从i到j的子串运算结果为0的可能的方法数
            int[][][] dp = new int[n][n][2];
            // 子串长度为 1 时的结果
            for (int i = 0; i < n; i += 2) {
                dp[i][i][0] = s.charAt(i) == '0' ? 1 : 0;
                dp[i][i][1] = s.charAt(i) == '1' ? 1 : 0;
            }
            // len表示每一段的长度,只有len是奇数才是符合要求的，即有n个数字的话必有n-1个运算符
            for (int len = 3; len <= n; len += 2) {
                // i表示起始坐标，数字只在偶数位
                for (int i = 0; i + len <= n; i += 2) {
                    // j 表示终止坐标,则j < n, 即 i+len-1 < n 即, i+len <= n
                    int j = i + len - 1;
                    for (int k = i + 1; k < j; k += 2) {
                        switch (s.charAt(k)) {
                            case '&':
                                dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];// 0 & 0 = 0
                                dp[i][j][0] += dp[i][k - 1][1] * dp[k + 1][j][0];// 1 & 0 = 0
                                dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][1];// 0 & 1 = 0
                                dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][1];// 1 & 1 = 1
                                break;
                            case '|':
                                dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];// 0 | 0 = 0
                                dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][0];// 1 | 0 = 1
                                dp[i][j][1] += dp[i][k - 1][0] * dp[k + 1][j][1];// 0 | 1 = 1
                                dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][1];// 1 | 1 = 1
                                break;
                            case '^':
                                dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];// 0 ^ 0 = 0
                                dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][0];// 1 ^ 0 = 1
                                dp[i][j][1] += dp[i][k - 1][0] * dp[k + 1][j][1];// 0 ^ 1 = 1
                                dp[i][j][0] += dp[i][k - 1][1] * dp[k + 1][j][1];// 1 ^ 1 = 0
                                break;
                        }
                    }
                }
            }
            return dp[0][n - 1][result];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}