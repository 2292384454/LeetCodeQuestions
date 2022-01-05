//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// Related Topics 动态规划 
// 👍 234 👎 0

package leetcode.editor.cn;

//Java：正则表达式匹配
public class P剑指_offer_19ZhengZeBiaoDaShiPiPeiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_19ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        // TO TEST
        String s = "acaabbaccbbacaabbbb", p = "a*.*b*.*a*aa*a*";
        System.out.println(solution.isMatch(s, p));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            /*
             对字符串p进行转换得到processed，小写字母和'.'原样保留；
             '*'和它的前一个字符结合：
                '[a-z]*'结合成'[A-Z]'保存
                '.*'结合成'/'保存
             */
            StringBuilder sb = new StringBuilder();
            for (int j = p.length() - 1; j >= 0; j--) {
                if (p.charAt(j) == '*') {
                    if (j == 0) {
                        return false;
                    }
                    if (p.charAt(j - 1) >= 'a' && p.charAt(j - 1) <= 'z') {
                        sb.append((char) (p.charAt(j - 1) - 'a' + 'A'));
                    } else if (p.charAt(j - 1) == '.') {
                        sb.append('/');
                    }
                    j--;
                } else {
                    sb.append(p.charAt(j));
                }
            }
            String processed = sb.reverse().toString();
            return helpMatch(s, processed);
        }

        // 递归判断
        private boolean helpMatch(String s, String processed) {
            int i = 0, j = 0;
            while (i < s.length() && j < processed.length()) {
                if (processed.charAt(j) == '/') {
                    // 如果当前遍历到的字符是 '/' ，即 '.*' ，那么可以跳过任意数量的字符
                    for (; i <= s.length(); i++) {
                        if (helpMatch(s.substring(i), processed.substring(j + 1))) {
                            return true;
                        }
                    }
                }
                if (processed.charAt(j) >= 'A' && processed.charAt(j) <= 'Z') {
                    // 如果当前遍历到的字符是大写字母 ，即 '[a-z]*' ，那么可以跳过任意数量的与 processed 前一个字符相等的字符
                    do {
                        if (helpMatch(s.substring(i), processed.substring(j + 1))) {
                            return true;
                        }
                        i++;
                    } while (i <= s.length() && i > 0 && s.charAt(i - 1) - 'a' + 'A' == processed.charAt(j));
                    // 跳过所有与 processed 前一个字符相等的字符后的情况，要单独判断.
                    if (i <= s.length() && i > 0 && s.charAt(i - 1) != processed.charAt(j)) {
                        return false;
                    }
                }
                if (processed.charAt(j) >= 'a' && processed.charAt(j) <= 'z') {
                    // 如果当前遍历到的字符是小写字母
                    if (s.charAt(i) != processed.charAt(j)) {
                        // 如果 s.charAt(i) != processed.charAt(j)，直接返回 false；
                        // 否则退出循环执行 i++;j++;
                        return false;
                    }
                }
                i++;
                j++;
            }
            // 如果s中还有字符没有匹配，那么肯定返回 false
            if (i != s.length()) {
                return false;
            }
            // 如果s中字符已经匹配完，processed中字符也已经匹配完，那么说明匹配成功
            if (j == processed.length()) {
                return true;
            }
            // 如果processed中剩下的字符还有 '[a-z]' 或者 '.' 没有匹配，那么返回 false
            for (; j < processed.length(); j++) {
                if ((processed.charAt(j) >= 'a' && processed.charAt(j) <= 'z') || processed.charAt(j) == '.') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}