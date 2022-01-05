//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 数学 
// 👍 189 👎 0

package leetcode.editor.cn;

//Java：1～n 整数中 1 出现的次数
public class P剑指_offer_43OneNzhengShuZhong1chuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_43OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
        // TO TEST
        System.out.println(solution.countDigitOne(1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dp;

        public int countDigitOne(int n) {
            int copy = n;
            // numCount 计算十进制位数
            int numCount = 0;
            while (copy > 0) {
                numCount++;
                copy /= 10;
            }
            // dp[i] 存储从 1 到 10^(i+1)-1 这 10^(i+1) 个整数的十进制表示中1出现的次数
            dp = new int[numCount - 1];
            int k = 1;
            for (int i = 0; i < numCount - 1; i++, k *= 10) {
                dp[i] = (i + 1) * k;
            }
            return help(n, numCount, k);
        }

        /**
         * @param n        输入参数
         * @param numCount n的十进制位数
         * @param k        10^(numCount-1)
         * @return 1～n这n个整数的十进制表示中1出现的次数
         */
        private int help(int n, int numCount, int k) {
            if (n < 10) {
                return n == 0 ? 0 : 1;
            }
            int ret = 0;
            // num 为最高位数字
            int num = n / k;
            // 这里计算的是在前面补 1 时一共补了多少个 1
            if (num > 1) {
                ret += k;
            } else if (num == 1) {
                ret += (n % k + 1);
            }
            // (dp[numCount - 2]) * num 计算的是在每个 numCount - 1 前补充0、1……num-1 的 num 种情况
            // help(n % k, numCount - 1, k / 10) 递归计算的是在 n % k 前面补 num 的这种情况
            ret += ((dp[numCount - 2]) * num + help(n % k, numCount - 1, k / 10));
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}