package leetcode.editor.cn;
//Java：回文子串

/**
 * <p>给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。</p>
 *
 * <p>具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>&quot;abc&quot;
 * <strong>输出：</strong>3
 * <strong>解释：</strong>三个回文子串: &quot;a&quot;, &quot;b&quot;, &quot;c&quot;
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>&quot;aaa&quot;
 * <strong>输出：</strong>6
 * <strong>解释：</strong>6个回文子串: &quot;a&quot;, &quot;a&quot;, &quot;a&quot;, &quot;aa&quot;, &quot;aa&quot;, &quot;aaa&quot;</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>输入的字符串长度不会超过 1000 。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><p><div><li>👍 621</li><li>👎 0</li></div>
 */
public class P647PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new P647PalindromicSubstrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int ans = 0;
            int len = s.length();
            // 动态规划找出所有的回文子串
            // dp[i][j]存储子串str[i,j)是不是回文串(j>=i)。
            boolean[][] dp = new boolean[len + 1][len + 1];
            // 任意长度为0或1的子串都是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
                dp[i][i + 1] = true;
                ans++;
            }
            dp[len][len] = true;
            // 从左下角向右上角填充
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 2; j <= len; j++) {
                    // s[i,j)是回文串当且仅当 “s[i+1,j)是回文串且 s[i]==s[j-1]”
                    dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j - 1));
                    if (dp[i][j]) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}