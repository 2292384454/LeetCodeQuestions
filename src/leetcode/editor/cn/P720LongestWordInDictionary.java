//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
//回答案中字典序最小的单词。 
//
// 若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：
//words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2： 
//
// 输入：
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释：
//"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
// 
//
// 
//
// 提示： 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 哈希表 
// 👍 106 👎 0

package leetcode.editor.cn;

import java.util.Arrays;


//Java：词典中最长的单词
public class P720LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new P720LongestWordInDictionary().new Solution();
        // TO TEST
        String dic[] = new String[]{"w", "wo", "wor", "worl", "world"};
        System.out.println(solution.longestWord(dic));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {
            Arrays.sort(words);
            String lenIsIndex[][] = new String[30][1000], candidates[][] = new String[30][1000];
            int lenofEveryIndex[] = new int[30], lenofCandidates[] = new int[30];
            for (int i = 0; i < words.length; i++) {
                int len = words[i].length();
                if (i == 0 || !words[i].equals(words[i - 1]))//去重
                    lenIsIndex[len - 1][lenofEveryIndex[len - 1]++] = words[i];
            }
            for (int i = 0; i < lenofEveryIndex[0]; i++) {
                candidates[0][i] = lenIsIndex[0][i];
                lenofCandidates[0]++;
            }
            for (int i = 0; i < candidates.length - 1; i++) {
                for (int j = 0; j < lenofCandidates[i]; j++) {
                    String str = candidates[i][j];
                    for (int k = 0; k < lenofEveryIndex[i + 1]; k++) {
                        String sub = lenIsIndex[i + 1][k].substring(0, i + 1);
                        if (str.equals(sub))
                            candidates[i + 1][lenofCandidates[i + 1]++] = lenIsIndex[i + 1][k];
                    }
                }
            }
            for (int i = lenofCandidates.length - 1; i >= 0; i--)
                if (lenofCandidates[i] > 0)
                    return candidates[i][0];
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}