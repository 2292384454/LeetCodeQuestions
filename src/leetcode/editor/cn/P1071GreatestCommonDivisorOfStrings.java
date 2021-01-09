//对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。 
//
// 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
//
// 
//
// 示例 1： 
//
// 
//输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
// 
//
// 示例 2： 
//
// 
//输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：str1 = "LEET", str2 = "CODE"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length <= 1000 
// 1 <= str2.length <= 1000 
// str1[i] 和 str2[i] 为大写英文字母 
// 
// Related Topics 字符串 
// 👍 184 👎 0

package leetcode.editor.cn;

//Java：字符串的最大公因子
public class P1071GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        Solution solution = new P1071GreatestCommonDivisorOfStrings().new Solution();
        // TO TEST
        System.out.println(solution.gcdOfStrings("ABCABC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            //s1为str1和str2中较长的一个
            String s1 = str1.length() > str2.length() ? str1 : str2;
            String s2 = str1.length() <= str2.length() ? str1 : str2;
            if (s1.contains(s2)) {
                int i = s2.length();
                for (; i > 0; i--) {
                    if (s1.length() % i == 0 && s2.length() % i == 0) {
                        break;
                    }
                }
                String result = s2.substring(0, i);
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < (s1.length() / i); j++)
                    temp.append(result);
                if (temp.toString().equals(s1))
                    return result;
                return "";
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
