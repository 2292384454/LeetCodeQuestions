//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 223 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：最长回文串
public class P409LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new P409LongestPalindrome().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("abccccdd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            if (s == "") {
                return 0;
            }
            int result = 0;
            short char_count[] = new short[60];
            boolean hasodd = false;
            char s_array[] = s.toCharArray();
            for (char x : s_array) {
                char_count[x - 'A']++;
            }
            Arrays.sort(char_count);
            for (int i = char_count.length - 1; i >= 0; i--) {
                if (char_count[i] == 0) {
                    break;
                }
                if (char_count[i] % 2 == 0) {
                    result += char_count[i];
                } else if (!hasodd) {
                    result += char_count[i];
                    hasodd = true;
                } else {
                    result += (char_count[i] - 1);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}