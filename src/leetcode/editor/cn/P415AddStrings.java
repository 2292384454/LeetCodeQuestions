//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 258 👎 0

package leetcode.editor.cn;

//Java：字符串相加
public class P415AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        // TO TEST
        System.out.println(solution.addStrings("0", "0"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            if (num1.length() == 0) return num2;
            if (num2.length() == 0) return num1;
            StringBuilder result = new StringBuilder();
            int carry = 0, a = 0, b = 0;
            char num1_array[] = num1.toCharArray(), num2_array[] = num2.toCharArray();
            for (int i = num1_array.length - 1, j = num2_array.length - 1; i >= 0 || j >= 0; i--, j--) {
                a = i >= 0 ? (num1_array[i] - '0') : 0;
                b = j >= 0 ? (num2_array[j] - '0') : 0;
                result.append((a + b + carry) % 10);
                carry = (a + b + carry) / 10;
            }
            if (carry > 0)
                result.append(carry);
            return result.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}