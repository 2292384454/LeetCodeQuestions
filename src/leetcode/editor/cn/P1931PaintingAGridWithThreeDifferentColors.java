package leetcode.editor.cn;
//Java：用三种不同颜色为网格涂色

/**
 * <p>给你两个整数 <code>m</code> 和 <code>n</code> 。构造一个 <code>m x n</code> 的网格，其中每个单元格最开始是白色。请你用 <strong>红、绿、蓝</strong> 三种颜色为每个单元格涂色。所有单元格都需要被涂色。</p>
 *
 * <p>涂色方案需要满足：<strong>不存在相邻两个单元格颜色相同的情况</strong> 。返回网格涂色的方法数。因为答案可能非常大， 返回 <strong>对 </strong><code>10<sup>9</sup> + 7</code><strong> 取余</strong> 的结果。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/22/colorthegrid.png" style="width: 200px; height: 50px;" />
 * <pre>
 * <strong>输入：</strong>m = 1, n = 1
 * <strong>输出：</strong>3
 * <strong>解释：</strong>如上图所示，存在三种可能的涂色方案。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/22/copy-of-colorthegrid.png" style="width: 321px; height: 121px;" />
 * <pre>
 * <strong>输入：</strong>m = 1, n = 2
 * <strong>输出：</strong>6
 * <strong>解释：</strong>如上图所示，存在六种可能的涂色方案。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>m = 5, n = 5
 * <strong>输出：</strong>580986
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= m <= 5</code></li>
 * <li><code>1 <= n <= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>动态规划</li></div></div><p><div><li>👍 19</li><li>👎 0</li></div>
 */
public class P1931PaintingAGridWithThreeDifferentColors {
    public static void main(String[] args) {
        Solution solution = new P1931PaintingAGridWithThreeDifferentColors().new Solution();
        // TO TEST
        System.out.println(solution.colorTheGrid(3, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        final int MOD = 1000000007;

        public int colorTheGrid(int m, int n) {
            long[][] dp = new long[m][n];
            dp[0][0] = 1;
            for (int i = 1; i < m; i++) {
                dp[i][0] = (dp[i - 1][0] << 1) % MOD;
            }
            // 对于只有一行的情况，同理
            for (int j = 1; j < n; j++) {
                dp[0][j] = (dp[0][j - 1] << 1) % MOD;
            }
            // 对于不是第一行也不是第一列的情况
            // 不能与上面的邻居或左边的邻居颜色相同
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    // 左上角与当前位置颜色相同时，有 4 种涂法；
                    // 左上角与当前位置颜色不同时，各有一种涂法。
                    dp[i][j] = (dp[i - 1][j - 1] * 6) % MOD;
                }
            }
            return (int) (dp[m - 1][n - 1] * 3) % MOD;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}