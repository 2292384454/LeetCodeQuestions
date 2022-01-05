//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 138 👎 0

package leetcode.editor.cn;

//Java：数字序列中某一位的数字
public class P剑指_offer_44ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_44ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            if (n < 0) return 0;
            else if (n <= 9) return n;
            else {
                long temp = 0;
                long base = 1;
                long num = 9;
                char res;
                while ((temp + base * num) < (long) n) {
                    temp += base * num;
                    base += 1;
                    num *= 10;
                }
                long a = ((long) n - temp) / base;
                long b = ((long) n - temp) % base;
                if (b != 0) {
                    long c = (long) (Math.pow(10, base - 1) + a);
                    res = String.valueOf(c).charAt((int) b - 1);
                } else {
                    long c = (long) (Math.pow(10, base - 1) + a - 1);
                    res = String.valueOf(c).charAt((int) base - 1);
                }
                return Integer.parseInt(String.valueOf(res));
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}