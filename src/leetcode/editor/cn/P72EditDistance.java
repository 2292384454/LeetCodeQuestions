package leetcode.editor.cn;
//Java：编辑距离

/**
 * <p>给你两个单词 <code>word1</code> 和 <code>word2</code>，请你计算出将 <code>word1</code> 转换成 <code>word2</code><em> </em>所使用的最少操作数 。</p>
 *
 * <p>你可以对一个单词进行如下三种操作：</p>
 *
 * <ul>
 * <li>插入一个字符</li>
 * <li>删除一个字符</li>
 * <li>替换一个字符</li>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>word1 = "horse", word2 = "ros"
 * <strong>输出：</strong>3
 * <strong>解释：</strong>
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>word1 = "intention", word2 = "execution"
 * <strong>输出：</strong>5
 * <strong>解释：</strong>
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 <= word1.length, word2.length <= 500</code></li>
 * <li><code>word1</code> 和 <code>word2</code> 由小写英文字母组成</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><p><div><li>👍 1694</li><li>👎 0</li></div>
 */
public class P72EditDistance {
    public static void main(String[] args) {
        Solution solution = new P72EditDistance().new Solution();
        // TO TEST
        System.out.println(solution.minDistance("horse", "ros"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();
            // dp[i][j] 代表 word1的 [0,i) 转换成 word2的 [0,j) 需要最少步数
            int[][] dp = new int[n1 + 1][n2 + 1];
            // 第一行
            for (int j = 1; j <= n2; j++) {
                dp[0][j] = j;
            }
            // 第一列
            for (int i = 1; i <= n1; i++) {
                dp[i][0] = i;
            }
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    }
                }
            }
            return dp[n1][n2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}