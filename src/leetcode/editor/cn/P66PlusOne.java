//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.Arrays;

//Java：加一
public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length, carry = 1;//因为要加一，所以carry初始值置1
            int result[] = Arrays.copyOf(digits, len);//拷贝数组，保护原始数据
            for (int i = len - 1; i >= 0; i--) {
                result[i] = (digits[i] + carry) % 10;
                carry = (digits[i] + carry) / 10;
                if (carry == 0)
                    return result;
            }
            int newresult[] = new int[len + 1];
            newresult[0] = 1;
            for (int i = 1; i < len + 1; i++)
                newresult[i] = result[i - 1];
            return newresult;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}