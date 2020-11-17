//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package leetcode.editor.cn;

//Java：最长公共前缀
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
        String[] test = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefix(test);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder stringBuilder = new StringBuilder();
            char tempchar;
            if (strs.length == 0) return stringBuilder.toString();
            for (int i = 0; i >= 0; i++) {
                if (i < strs[0].length())
                    tempchar = strs[0].charAt(i);
                else
                    return stringBuilder.toString();
                for (String s : strs) {
                    if (i < s.length()) {
                        if (s.charAt(i) != tempchar)
                            return stringBuilder.toString();
                    } else return stringBuilder.toString();

                }
                stringBuilder.append(tempchar);
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}