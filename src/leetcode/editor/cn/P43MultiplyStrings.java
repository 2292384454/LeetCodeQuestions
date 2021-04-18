//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 396 👎 0

package leetcode.editor.cn;

//Java：字符串相乘
public class P43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
        // TO TEST
        String num1 = "0", num2 = "52";
        System.out.println(solution.multiply(num1, num2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";
            int len1 = num1.length(), len2 = num2.length();
            char[] array1 = num1.toCharArray(), array2 = num2.toCharArray();
            String[] tempcounts = new String[len2];
            StringBuilder zeros = new StringBuilder();
            String result = "0";
            for (int i = len2 - 1; i >= 0; i--) {
                int carry = 0;
                StringBuilder tempstr = new StringBuilder();
                for (int j = len1 - 1; j >= 0; j--) {
                    int temp = (array2[i] - '0') * (array1[j] - '0');
                    tempstr.append((temp + carry) % 10);
                    carry = (temp + carry) / 10;
                }
                if (carry > 0)
                    tempstr.append(carry);
                tempcounts[len2 - i - 1] = tempstr.reverse().toString();
            }
            for (int i = 0; i < len2; i++) {
                result = add(result, tempcounts[i] + zeros);
                zeros.append("0");
            }
            return result;
        }

        //字符串数字相加
        public String add(String num1, String num2) {
            int len1 = num1.length(), len2 = num2.length();
            char[] array1 = num1.toCharArray(), array2 = num2.toCharArray();
            int carry = 0;
            StringBuilder result = new StringBuilder();
            for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
                int a = (i >= 0 ? (array1[i] - '0') : 0), b = (j >= 0 ? (array2[j] - '0') : 0), temp = a + b;
                result.append((temp + carry) % 10);
                carry = (temp + carry) / 10;
            }
            if (carry > 0)
                result.append(carry);
            return result.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}