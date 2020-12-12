//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串 
// 👍 68 👎 0

package leetcode.editor.cn;

//Java：仅仅反转字母
public class P917ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new P917ReverseOnlyLetters().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String S) {
            if (S.length() < 2) return S;
            int i = 0, j = S.length() - 1;
            char[] S_chars = S.toCharArray();
            while (i < j) {
                while (i < j && !Character.isLetter(S_chars[i]))
                    i++;
                while (i < j && !Character.isLetter(S_chars[j]))
                    j--;
                char temp = S_chars[i];
                S_chars[i] = S_chars[j];
                S_chars[j] = temp;
                i++;
                j--;
            }
            return new String(S_chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}