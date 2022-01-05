//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。 
//
// 示例: 
//
// 输入: 2
//输出: 91 
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
// 
// Related Topics 数学 动态规划 回溯算法 
// 👍 131 👎 0

package leetcode.editor.cn;

//Java：计算各个位数不同的数字个数
public class P357CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        Solution solution = new P357CountNumbersWithUniqueDigits().new Solution();
        // TO TEST
        System.out.println(solution.countNumbersWithUniqueDigits(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            int[] dp = new int[n + 1];//dp[i]为[10^(i-1),10^i)范围内各位数字都不同的数字的个数(i>=1)。
            int ans = 0;
            dp[0] = 1;
            ans += dp[0];
            if (n == 0) {
                return ans;
            }
            dp[1] = 9;
            ans += dp[1];
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] * (11 - i);
                ans += dp[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
