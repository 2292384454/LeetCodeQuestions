//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学

package leetcode.editor.cn;

//Java：整数反转
public class P7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        int result = solution.reverse(-123);
        System.out.println(result);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int result = 0, newresult = 0, temp = 0;
            while (x != 0) {
                temp = x % 10;
                newresult = result * 10 + temp;
                if ((newresult - temp) / 10 != result) {
                    // 如果溢出
                    return 0;
                }
                result = newresult;
                x /= 10;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}