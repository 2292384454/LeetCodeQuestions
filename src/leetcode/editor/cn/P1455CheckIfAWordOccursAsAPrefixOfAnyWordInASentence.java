//给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。 
//
// 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。 
//
// 
// 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。 
// 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。 
// 如果 searchWord 不是任何单词的前缀，则返回 -1 。 
// 
//
// 字符串 S 的 「前缀」是 S 的任何前导连续子字符串。 
//
// 
//
// 示例 1： 
//
// 输入：sentence = "i love eating burger", searchWord = "burg"
//输出：4
//解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。 
//
// 示例 2： 
//
// 输入：sentence = "this problem is an easy problem", searchWord = "pro"
//输出：2
//解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
// 
//
// 示例 3： 
//
// 输入：sentence = "i am tired", searchWord = "you"
//输出：-1
//解释："you" 不是句子中任何单词的前缀。
// 
//
// 示例 4： 
//
// 输入：sentence = "i use triple pillow", searchWord = "pill"
//输出：4
// 
//
// 示例 5： 
//
// 输入：sentence = "hello from the other side", searchWord = "they"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sentence.length <= 100 
// 1 <= searchWord.length <= 10 
// sentence 由小写英文字母和空格组成。 
// searchWord 由小写英文字母组成。 
// 前缀就是紧密附着于词根的语素，中间不能插入其它成分，并且它的位置是固定的——-位于词根之前。（引用自 前缀_百度百科 ） 
// 
// Related Topics 字符串 
// 👍 13 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：检查单词是否为句中其他单词的前缀
public class P1455CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public static void main(String[] args) {
        Solution solution = new P1455CheckIfAWordOccursAsAPrefixOfAnyWordInASentence().new Solution();
        // TO TEST
       /* String sentence = "i love eating  burger";
        String searchWord = "burg";
        System.out.println(solution.isPrefixOfWord(sentence, searchWord));*/
        String sentence = "hellohello hellohellohello";
        String searchWord = "ell";
        System.out.println(solution.isPrefixOfWord(sentence, searchWord));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            /* 本解法还适用于 sentence 用一个或多个空格分隔的情况 */
            int sentenceLen = sentence.length(), searchLen = searchWord.length();
            int wordCnt = 0;
            for (int i = 0, j = 0; i < sentenceLen; i++) {
                char c = sentence.charAt(i);
                // 对单词进行计数，并且在每一个单词开始时把 j 置为 0
                if (c != ' ' && (i == 0 || sentence.charAt(i - 1) == ' ')) {
                    wordCnt++;
                    j = 0;
                }
                // 如果匹配就继续后移，否则 i 直接移动到本单词结束
                if (c == searchWord.charAt(j)) {
                    j++;
                } else {
                    while (i < sentenceLen && sentence.charAt(i) != ' ') {
                        i++;
                    }
                }
                // 如果 searchWord 全部匹配上了，就返回
                if (j >= searchLen) {
                    return wordCnt;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
