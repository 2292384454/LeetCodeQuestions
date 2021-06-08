//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串

package leetcode.editor.cn;

//Java：二进制求和
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
        String a = "11";
        String b = "1";
        System.out.println(solution.addBinary(a, b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();
            int len_a = a.length(), len_b = b.length();
            short carry = 0, temp = 0;
            int i = 0, j = 0;
            for (i = len_a - 1, j = len_b - 1; i >= 0 || j >= 0; i--, j--) {
                short a_value = (i >= 0 ? (short) (a.charAt(i) - '0') : 0);
                short b_value = (j >= 0 ? (short) (b.charAt(j) - '0') : 0);
                temp = (short) (a_value + b_value + carry);
                result.insert(0, (char) (temp % 2 + '0'));
                carry = (short) (temp / 2);
            }
            if (carry != 0) {
                result.insert(0, (char) (carry + '0'));
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}