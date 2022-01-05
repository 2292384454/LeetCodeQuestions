//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 692 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：分割回文串
public class P131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
        // TO TEST
        solution.partition("aabaabaa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 将输入字符串复制为成员变量
        String str;
        // 动态规划数组
        boolean[][] dp;
        // 最终结果
        List<List<String>> ans = new ArrayList<>();

        public List<List<String>> partition(String s) {
            str = s;
            int len = str.length();

            // 动态规划找出所有的回文子串
            // dp[i][j]存储子串str[i,j)是不是回文串(j>=i)。
            dp = new boolean[len + 1][len + 1];
            // 任意长度为0或1的子串都是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
                dp[i][i + 1] = true;
            }
            dp[len][len] = true;
            // 从左下角向右上角填充
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 2; j <= len; j++) {
                    //str[i,j)是回文串当且仅当 “str[i+1,j)是回文串且str[i]==str[j-1]”
                    dp[i][j] = (dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j - 1));
                }
            }
            backTracking(0, new ArrayList<>());
            return ans;
        }

        //回溯法找出所有可能的分割方案
        public void backTracking(int start, List<String> list) {
            int n = dp.length;
            if (start == n - 1) {
                ans.add(new ArrayList<>(list));
            }
            for (int i = start + 1; i < n; i++) {
                if (dp[start][i]) {
                    list.add(str.substring(start, i));
                    backTracking(i, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
