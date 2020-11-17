//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 
// 👍 57 👎 0

package leetcode.editor.cn;

//Java：字符串中的单词数
public class P434NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Solution solution = new P434NumberOfSegmentsInAString().new Solution();
        // TO TEST
        System.out.println(solution.countSegments("      "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {
            if (s.length() == 0) return 0;
            int result = 0;
            s.trim();//去除开头和结尾的多余空格

            //方法一：直接调用split()方法，100%
            /*
            String words[] = s.split(" ");
            for (String x : words)
                if (x.length() > 0)
                    result++;
            return result;
            */

            //方法二：进行循环,100%
            char s_array[] = s.toCharArray();
            for (int i = 0; i < s_array.length; i++) {
                if (i + 1 >= s_array.length && s_array[i] != ' ') return ++result;
                if (s_array[i] != ' ' && s_array[i + 1] == ' ')
                    result++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}