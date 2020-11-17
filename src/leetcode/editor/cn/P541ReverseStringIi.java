//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 91 👎 0

package leetcode.editor.cn;

//Java：反转字符串 II
public class P541ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new P541ReverseStringIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            StringBuilder result = new StringBuilder();
            int i = 0;
            String substr;
            for (i = 2 * k; i < s.length(); i += (2 * k)) {
                substr = s.substring(i - 2 * k, i - k);
                substr = reverse(substr);
                result.append(substr);
                result.append(s.substring(i - k, i));
            }
            if (i - k < s.length()) {
                substr = s.substring(i - 2 * k, i - k);
                substr = reverse(substr);
                result.append(substr);
                result.append(s.substring(i - k, s.length()));
            } else {
                substr = s.substring(i - 2 * k, s.length());
                substr = reverse(substr);
                result.append(substr);
            }
            return result.toString();
        }

        public String reverse(String s) {
            StringBuilder strbuilder = new StringBuilder(s);
            return strbuilder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}