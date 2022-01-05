//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 163 👎 0

package leetcode.editor.cn;

//Java：数值的整数次方
public class P剑指_offer_16ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_16ShuZhiDeZhengShuCiFangLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (x == 1.0) return 1.0;
            boolean isNeg = (n < 0);
            // 快速幂
            double ans = 1;
            // 考虑 n=-2147483648 的情况
            if (n == Integer.MIN_VALUE) {
                n += 1;
                ans = x;
            }
            n = Math.abs(n);
            while (n != 0) {
                if ((n & 1) == 1) {
                    ans *= x;
                }
                x *= x;
                n >>= 1;
            }
            return isNeg ? 1.0 / ans : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}