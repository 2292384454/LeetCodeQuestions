//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 178 👎 0

package leetcode.editor.cn;

//Java：丑数
public class P剑指_offer_49ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_49ChouShuLcof().new Solution();
        // TO TEST
        System.out.println(solution.nthUglyNumber(12));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            if (n <= 6) {
                return n;
            }
            int[] dp = new int[n];
            dp[0] = 1;
            int n_2 = 0, n_3 = 0, n_5 = 0;
            for (int i = 1; i < n; i++) {
                int x = Math.min(Math.min(dp[n_2] * 2, dp[n_3] * 3), dp[n_5] * 5);
                if (x == dp[n_2] * 2) {
                    n_2++;
                }
                if (x == dp[n_3] * 3) {
                    n_3++;
                }
                if (x == dp[n_5] * 5) {
                    n_5++;
                }
                dp[i] = x;
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}