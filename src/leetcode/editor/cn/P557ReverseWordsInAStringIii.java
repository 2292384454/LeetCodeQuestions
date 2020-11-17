//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 245 👎 0

package leetcode.editor.cn;

//Java：反转字符串中的单词 III
public class P557ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new P557ReverseWordsInAStringIii().new Solution();
        // TO TEST
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            StringBuilder result = new StringBuilder();
            char s_chars[] = s.toCharArray();
            for (int i = 0, begin = 0, end = 0; i <= s_chars.length; i++) {
                if (i == 0 || (i > 0 && i < s_chars.length && s_chars[i - 1] == ' '))
                    begin = i;
                if (i == s_chars.length || s_chars[i] == ' ')
                    end = i;
                if (begin < end)
                    result.append(reverse(s.substring(begin, end)) + " ");
            }
            return result.toString().trim();
        }

        public String reverse(String s) {
            StringBuilder strbuilder = new StringBuilder(s);
            return strbuilder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}