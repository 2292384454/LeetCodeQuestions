//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 堆 数学 动态规划 
// 👍 644 👎 0

package leetcode.editor.cn;

//Java：丑数 II
public class P264UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new P264UglyNumberIi().new Solution();
        // TO TEST
        System.out.println(solution.nthUglyNumber(1690));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];//dp[i]： 第i个丑数
            dp[1] = 1;
            // pi是有资格同i相乘的最小丑数的位置。
            // 这里资格指的是：如果一个丑数 dp[pi]通过乘以i可以得到下一个丑数，那么这个丑数 dp[pi]就永远失去了同i相乘的资格（没有必要再乘了），我们把pi++让 dp[pi]指向下一个丑数即可。
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; i++) {
                int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
                dp[i] = Math.min(Math.min(num2, num3), num5);
                if (dp[i] == num2) {
                    p2++;
                }
                if (dp[i] == num3) {
                    p3++;
                }
                if (dp[i] == num5) {
                    p5++;
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
