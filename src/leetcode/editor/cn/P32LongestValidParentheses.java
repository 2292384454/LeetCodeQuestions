package leetcode.editor.cn;
//Java：最长有效括号

/**
 * <p>给你一个只包含 <code>'('</code> 和 <code>')'</code> 的字符串，找出最长有效（格式正确且连续）括号子串的长度。</p>
 *
 * <p> </p>
 *
 * <div class="original__bRMd">
 * <div>
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "(()"
 * <strong>输出：</strong>2
 * <strong>解释：</strong>最长有效括号子串是 "()"
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = ")()())"
 * <strong>输出：</strong>4
 * <strong>解释：</strong>最长有效括号子串是 "()()"
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = ""
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 <= s.length <= 3 * 10<sup>4</sup></code></li>
 * <li><code>s[i]</code> 为 <code>'('</code> 或 <code>')'</code></li>
 * </ul>
 * </div>
 * </div>
 * <div><div>Related Topics</div><div><li>栈</li><li>字符串</li><li>动态规划</li></div></div><p><div><li>👍 1362</li><li>👎 0</li></div>
 */
public class P32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.longestValidParentheses("()(()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() < 2) {
                return 0;
            }
            int n = s.length(), ans = 0;
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                    // ……() 的情况
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // (……) 的情况
                    dp[i] = 2 + dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? (dp[i - dp[i - 1] - 2]) : 0);
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}