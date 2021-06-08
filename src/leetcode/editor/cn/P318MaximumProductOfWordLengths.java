//给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 示例 1: 
//
// 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。 
// Related Topics 位运算 
// 👍 166 👎 0

package leetcode.editor.cn;

//Java：最大单词长度乘积
public class P318MaximumProductOfWordLengths {
    public static void main(String[] args) {
        Solution solution = new P318MaximumProductOfWordLengths().new Solution();
        // TO TEST
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(solution.maxProduct(words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            int len = words.length;
            int maxProd = 0;
            int[] masks = new int[len];
            for (int i = 0; i < len; i++) {
                masks[i] = StringToBitMask(words[i]);
            }
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if ((masks[i] & masks[j]) == 0) {
                        maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                    }
                }
            }
            return maxProd;
        }

        /**
         * 计算给定字符串的位掩码（用int型的32位中的26位来记录每一个小写字母是否出现过）
         *
         * @param s 给定字符串
         * @return 位掩码
         */
        private int StringToBitMask(String s) {
            int bitmask = 0;
            for (char ch : s.toCharArray()) {
                bitmask |= 1 << (ch - 'a');
            }
            return bitmask;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
