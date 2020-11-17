//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 112 👎 0

package leetcode.editor.cn;

import java.util.HashSet;

//Java：反转字符串中的元音字母
public class P345ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char s_Array[] = s.toCharArray();
            int len = s_Array.length;
            if (len == 0) return s;
            HashSet<Character> vowels = new HashSet<Character>() {{
                add('a');
                add('o');
                add('e');
                add('i');
                add('u');
                add('A');
                add('O');
                add('E');
                add('I');
                add('U');
            }};
            for (int i = 0, j = len - 1; i < j; i++) {
                if (vowels.contains(s_Array[i])) {
                    while (!vowels.contains(s_Array[j]) && i < j)
                        j--;
                    char temp = s_Array[i];
                    s_Array[i] = s_Array[j];
                    s_Array[j] = temp;
                    j--;
                }
            }
            return new String(s_Array);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}