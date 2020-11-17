//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
//
// 
//
// 
//
// 
//
// 示例： 
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
// 
//
// 
//
// 注意： 
//
// 
// 你可以重复使用键盘上同一字符。 
// 你可以假设输入的字符串将只包含字母。 
// Related Topics 哈希表 
// 👍 105 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;

//Java：键盘行
public class P500KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new P500KeyboardRow().new Solution();
        // TO TEST
        String words[] = {"Hello", "Alaska", "Dad", "Peace"};
        String result[] = solution.findWords(words);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {
            if (words.length == 0) return words;
            int char_keylinenum[] = new int[60];
            ArrayList<String> result = new ArrayList<>();
            char array[][] = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                    {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                    {'z', 'x', 'c', 'v', 'b', 'n', 'm'}};
            for (int i = 0; i < array.length; i++)
                for (char x : array[i]) {
                    char_keylinenum[x - 'A'] = i;
                    char_keylinenum[x - 'a'] = i;
                }
            for (String str : words) {
                char[] str_array = str.toCharArray();
                if (str_array.length == 0) {
                    result.add(str);
                    continue;
                }
                int index = str_array[0] - 'a' >= 0 ? str_array[0] - 'a' : str_array[0] - 'A', linenumm = char_keylinenum[index];
                int i = 0;
                for (i = 0; i < str_array.length; i++) {
                    index = str_array[i] - 'a' >= 0 ? str_array[i] - 'a' : str_array[i] - 'A';
                    if (char_keylinenum[index] != linenumm)
                        break;
                }
                if (i == str_array.length)
                    result.add(str);
            }
            return result.toArray(new String[result.size()]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}