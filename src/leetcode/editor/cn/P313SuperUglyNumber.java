//编写一段程序来查找第 n 个超级丑数。 
//
// 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。 
//
// 示例: 
//
// 输入: n = 12, primes = [2,7,13,19]
//输出: 32 
//解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26
//,28,32] 。 
//
// 说明: 
//
// 
// 1 是任何给定 primes 的超级丑数。 
// 给定 primes 中的数字以升序排列。 
// 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。 
// 第 n 个超级丑数确保在 32 位有符整数范围内。 
// 
// Related Topics 堆 数学 
// 👍 163 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：超级丑数
public class P313SuperUglyNumber {
    public static void main(String[] args) {
        Solution solution = new P313SuperUglyNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] dp = new int[n + 1];//dp[i]： 第i个丑数
            dp[1] = 1;
            // p[i]是有资格同primes[i]相乘的最小丑数的位置。
            // 这里资格指的是：如果一个丑数 dp[p[i]]通过乘以primes[i]可以得到下一个丑数，那么这个丑数 dp[p[i]]就永远失去了同primes[i]相乘的资格（没有必要再乘了），我们把p[i]++让 dp[p[i]]指向下一个丑数即可。
            int len = primes.length;
            int[] p = new int[len];
            int[] nums = new int[len];
            Arrays.fill(p, 1);
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < len; j++) {
                    nums[j] = dp[p[j]] * primes[j];
                }
                dp[i] = min(nums);// 找到nums中最小值
                // 有哪些位置的元素等于这个最小值
                for (int j = 0; j < len; j++) {
                    if (dp[i] == nums[j]) {
                        p[j]++;
                    }
                }
            }
            return dp[n];
        }

        private int min(int[] nums) {
            int ans = Integer.MAX_VALUE;
            for (int num : nums) {
                ans = Math.min(ans, num);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
