package leetcode.editor.cn;
//Java：回文子字符串的个数

/**
 * <p>给定一个字符串 <code>s</code> ，请计算这个字符串中有多少个回文子字符串。</p>
 *
 * <p>具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "abc"
 * <strong>输出：</strong>3
 * <strong>解释：</strong>三个回文子串: "a", "b", "c"
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s =<strong> </strong>"aaa"
 * <strong>输出：</strong>6
 * <strong>解释：</strong>6个回文子串: "a", "a", "a", "aa", "aa", "aaa"</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * <li><code>s</code> 由小写英文字母组成</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 647 题相同：<a href="https://leetcode-cn.com/problems/palindromic-substrings/">https://leetcode-cn.com/problems/palindromic-substrings/</a>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_020A7VOhD {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_020A7VOhD().new Solution();
        // TO TEST
        String s = "aba";
        System.out.println(solution.countSubstrings(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length();
            // dp[i][j] 存储子串 s[i,j) 是不是回文子串（i<=j）
            boolean[][] dp = new boolean[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][i] = true;
                if (i < n) {
                    dp[i][i + 1] = true;
                }
            }
            int ans = n;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 2; j <= n; j++) {
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