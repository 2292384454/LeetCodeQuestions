//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 498 👎 0

package leetcode.editor.cn;

//Java：两数相除
public class P29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P29DivideTwoIntegers().new Solution();
        // TO TEST
        System.out.println(solution.divide(60, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            long ans = 0, a = dividend, b = divisor;
            //不直接使用Math.abs()是为了避免除数或被除数为-2^31的情况，此时Math.abs()返回将出错
            a = a < 0 ? -a : a;
            b = b < 0 ? -b : b;
            //方法一：
            //示例：60/8=(60-32)/8+4=(60-32-16)/8+2+4=(60-32-16-8)/8+1+2+4=1+2+4=7
            while (a >= b) {
                long cnt = 1, base = b;
                while (a > (base << 1)) {
                    cnt <<= 1;
                    base <<= 1;
                }
                ans += cnt;
                a -= base;
            }
            //方法二：乘法二分查找
            /*
            long left = 0, right = a;
            while (left <= right) {
                long mid = left + (right - left) / 2, temp = mul(mid, b);
                if (temp <= a - b)
                    left = mid + 1;
                else if (temp > a)
                    right = mid - 1;
                else//a-b<temp<=a
                {
                    ans = mid;
                    break;
                }
            }*/

            ans = ((dividend < 0) ^ (divisor < 0)) ? -ans : ans;
            return (int) ((Integer.MAX_VALUE < ans || ans < Integer.MIN_VALUE) ? Integer.MAX_VALUE : ans);
        }
        /*
        public long mul(long a, long k) {
            long ans = 0;
            while (k > 0) {
                if ((k & 1) == 1) ans += a;
                k >>= 1;
                a <<= 1;
            }
            return ans;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
