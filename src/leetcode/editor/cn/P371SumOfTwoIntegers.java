//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 298 👎 0

package leetcode.editor.cn;

//Java：两整数之和
public class P371SumOfTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P371SumOfTwoIntegers().new Solution();
        // TO TEST
        System.out.println(solution.getSum(7893, 54323));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            int lower;
            int carrier;
            while (true) {
                lower = a ^ b;    // 计算低位
                carrier = a & b;  // 计算进位
                if (carrier == 0) {
                    break;
                }
                a = lower;
                b = carrier << 1;
            }
            return lower;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}