package leetcode.editor.cn;
//Java：最长公共子序列

/**
 * <p>给定两个字符串 <code>text1</code> 和 <code>text2</code>，返回这两个字符串的最长 <strong>公共子序列</strong> 的长度。如果不存在 <strong>公共子序列</strong> ，返回 <code>0</code> 。</p>
 *
 * <p>一个字符串的 <strong>子序列</strong><em> </em>是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。</p>
 *
 * <ul>
 * <li>例如，<code>"ace"</code> 是 <code>"abcde"</code> 的子序列，但 <code>"aec"</code> 不是 <code>"abcde"</code> 的子序列。</li>
 * </ul>
 *
 * <p>两个字符串的 <strong>公共子序列</strong> 是这两个字符串所共同拥有的子序列。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>text1 = "abcde", text2 = "ace"
 * <strong>输出：</strong>3
 * <strong>解释：</strong>最长公共子序列是 "ace" ，它的长度为 3 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>text1 = "abc", text2 = "abc"
 * <strong>输出：</strong>3
 * <strong>解释：</strong>最长公共子序列是 "abc" ，它的长度为 3 。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>text1 = "abc", text2 = "def"
 * <strong>输出：</strong>0
 * <strong>解释：</strong>两个字符串没有公共子序列，返回 0 。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= text1.length, text2.length <= 1000</code></li>
 * <li><code>text1</code> 和 <code>text2</code> 仅由小写英文字符组成。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><p><div><li>👍 620</li><li>👎 0</li></div>
 */
public class P1143LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new P1143LongestCommonSubsequence().new Solution();
        // TO TEST
        System.out.println(solution.longestCommonSubsequence("psnw", "vozsh"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length(), len2 = text2.length();
            // dp[i][j] 存储 text1[i,j) 与 text2[i,j) 的最长公共子序列
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = 1; i <= len1; i++) {
                char c1 = text1.charAt(i - 1);
                for (int j = 1; j <= len2; j++) {
                    char c2 = text2.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[len1][len2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}