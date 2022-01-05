//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法 
// 👍 443 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：单词拆分 II
public class P140WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new P140WordBreakIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();
        Set<String> wordDictSet;
        boolean[] dp;

        public List<String> wordBreak(String s, List<String> wordDict) {
            //借助p140的动态规划算法确定是否有解
            wordDictSet = new HashSet(wordDict);
            dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            //如果有解，回溯求解
            if (dp[s.length()]) {
                dfs(s, "");
            }
            return ans;
        }

        public void dfs(String s, String ansStr) {
            if (s.length() == 0) {
                ans.add(ansStr.trim());
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                String sub = s.substring(i);
                if (wordDictSet.contains(sub) && dp[i]) {
                    dfs(s.substring(0, i), sub + " " + ansStr);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
