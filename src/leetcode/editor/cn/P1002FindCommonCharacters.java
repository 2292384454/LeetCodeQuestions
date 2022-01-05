//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 193 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：查找常用字符
public class P1002FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new P1002FindCommonCharacters().new Solution();
        // TO TEST
        System.out.println(solution.commonChars(new String[]{"bella", "label", "roller"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] A) {
            List<String> result = new ArrayList<>();
            int[] char_count = new int[26];
            char[] chars = A[0].toCharArray();
            for (char aChar : chars) {
                char_count[aChar - 'a']++;
            }

            for (String str : A) {
                int[] char_count_temp = new int[26];
                chars = str.toCharArray();
                for (char aChar : chars) {
                    char_count_temp[aChar - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    char_count[i] = Math.min(char_count[i], char_count_temp[i]);
                }
            }
            for (int i = 0; i < char_count.length; i++) {
                for (int j = 0; j < char_count[i]; j++) {
                    result.add((char) ('a' + i) + "");
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
