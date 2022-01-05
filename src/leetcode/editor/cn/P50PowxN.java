//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。 
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
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 595 👎 0

package leetcode.editor.cn;


//Java：Pow(x, n)
public class P50PowxN {
    public static void main(String[] args) {
        Solution solution = new P50PowxN().new Solution();
        // TO TEST
        System.out.println(solution.myPow(2.0, -2147483647));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (x == 1.0 || n == 0) {
                return 1.0;
            }
            byte[] binaryStr = new byte[32];//binaryStr存储n的绝对值转成二进制后的每一位
            int maxIndex = 0;//maxIndex记录n除符号位外最高位的位置
            if (n == Integer.MIN_VALUE) {
                binaryStr[31] = 1;
                maxIndex = 31;
            } else {
                int abs = Math.abs(n), i = 0;
                while (abs != 0) {
                    if ((abs & 1) == 1) {
                        binaryStr[i] = 1;
                        maxIndex = i;
                    }
                    i++;
                    abs >>= 1;
                }
            }

            int index = 0;//index的值将依次是0,1,2,4,8,16,……
            double ans = 1, num = x;//num的值将依次是x的0,1,2,4,8,16,……次方
            while (index <= maxIndex) {
                if (binaryStr[index] == 1) {
                    ans *= num;
                }
                num *= num;
                index++;
            }
            return n < 0 ? (1.0 / ans) : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
