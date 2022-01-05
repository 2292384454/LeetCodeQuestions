//给定一个整数，将其转化为7进制，并以字符串形式输出。 
//
// 示例 1: 
//
// 
//输入: 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: -7
//输出: "-10"
// 
//
// 注意: 输入范围是 [-1e7, 1e7] 。 
// 👍 58 👎 0

package leetcode.editor.cn;

//Java：七进制数
public class P504Base7 {
    public static void main(String[] args) {
        Solution solution = new P504Base7().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            int abs_num = Math.abs(num);
            if (num == 0) {
                return "0";
            }
            StringBuilder res = new StringBuilder();
            while (abs_num > 0) {
                res.append((char) (abs_num % 7 + '0'));
                abs_num /= 7;
            }
            if (num < 0) {
                res.append('-');
            }
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}