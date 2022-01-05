//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3201 👎 0

package leetcode.editor.cn;

//Java：最长回文子串
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("aasc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

        /**
         * 动态规划
         */
        public String longestPalindrome(String s) {
            int len = s.length();
            // from包含，to不包含
            int from = 0, to = 1;
            // 动态规划找出所有的回文子串
            // dp[i][j]存储子串str[i,j)是不是回文串(j>=i)。
            boolean[][] dp = new boolean[len + 1][len + 1];
            // 任意长度为0或1的子串都是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
                dp[i][i + 1] = true;
            }
            dp[len][len] = true;
            // 从左下角向右上角填充
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 2; j <= len; j++) {
                    // s[i,j)是回文串当且仅当 “s[i+1,j)是回文串且 s[i]==s[j-1]”
                    dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j - 1));
                    if (dp[i][j] && j - i > to - from) {
                        from = i;
                        to = j;
                    }
                }
            }
            return s.substring(from, to);
        }

        /**
         * 中心扩展法
         */
        // public String longestPalindrome(String s) {
        //     int start = 0, end = 0;
        //     int n = s.length();
        //     for (int i = 0; i < n; i++) {
        //         // 以位置 i 为正中心，长度为奇数的最长回文子串的长度
        //         int len1 = expandAroundCenter(s, i, i);
        //         // 以位置 i+1/2 为正中心，长度为偶数的最长回文子串的长度
        //         int len2 = expandAroundCenter(s, i, i + 1);
        //         int len = Math.max(len1, len2);
        //         if (len > (end - start + 1)) {
        //             start = i - (len - 1) / 2;
        //             end = i + len / 2;
        //         }
        //     }
        //     return s.substring(start, end + 1);
        // }
        //
        // private int expandAroundCenter(String s, int left, int right) {
        //     while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        //         left--;
        //         right++;
        //     }
        //     return right - left - 1;
        // }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
