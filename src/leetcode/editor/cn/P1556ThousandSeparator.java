//给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。 
//
// 
//
// 示例 1： 
//
// 输入：n = 987
//输出："987"
// 
//
// 示例 2： 
//
// 输入：n = 1234
//输出："1.234"
// 
//
// 示例 3： 
//
// 输入：n = 123456789
//输出："123.456.789"
// 
//
// 示例 4： 
//
// 输入：n = 0
//输出："0"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n < 2^31 
// 
// Related Topics 字符串 
// 👍 6 👎 0

package leetcode.editor.cn;

//Java：千位分隔数
public class P1556ThousandSeparator {
    public static void main(String[] args) {
        Solution solution = new P1556ThousandSeparator().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String thousandSeparator(int n) {
            if (n == 0) {
                return "0";
            }
            int count = 0;
            StringBuilder result = new StringBuilder();
            while (n > 0) {
                int num = n % 10;
                if (count == 3) {
                    result.append('.');
                    count = 0;
                }
                result.append(num);
                count++;
                n /= 10;
            }
            return result.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
