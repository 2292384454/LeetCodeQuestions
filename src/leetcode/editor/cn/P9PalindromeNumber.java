//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学

package leetcode.editor.cn;

//Java：回文数
public class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {//调用p7的整数反转方法，反转后如果与原数字相等则是回文数（注意负数都不是回文数）

        public int reverse(int x) {
            int result = 0, newresult = 0, temp = 0;
            while (x != 0) {
                temp = x % 10;
                newresult = result * 10 + temp;
                if ((newresult - temp) / 10 != result)//判断是否溢出
                    return 0;
                result = newresult;
                x /= 10;
            }
            return result;
        }

        public boolean isPalindrome(int x) {
            if (x >= 0) {
                int reversed = reverse(x);
                if (x == reversed) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}