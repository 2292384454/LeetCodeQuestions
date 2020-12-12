//给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。） 
//
// 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。 
//
// 返回所有不常用单词的列表。 
//
// 您可以按任何顺序返回列表。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = "this apple is sweet", B = "this apple is sour"
//输出：["sweet","sour"]
// 
//
// 示例 2： 
//
// 输入：A = "apple apple", B = "banana"
//输出：["banana"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 200 
// 0 <= B.length <= 200 
// A 和 B 都只包含空格和小写字母。 
// 
// Related Topics 哈希表 
// 👍 73 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;

//Java：两句话中的不常见单词
public class P884UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        Solution solution = new P884UncommonWordsFromTwoSentences().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] uncommonFromSentences(String A, String B) {
            HashMap<String, int[]> str_count = new HashMap<>();
            String[] A_array = A.split(" "), B_array = B.split(" ");
            ArrayList<String> result = new ArrayList<>();
            int[] counts = new int[2];
            for (String A_str : A_array) {
                counts = str_count.getOrDefault(A_str, new int[]{0, 0});
                counts[0]++;
                str_count.put(A_str, counts);
            }
            for (String B_str : B_array) {
                counts = str_count.getOrDefault(B_str, new int[]{0, 0});
                counts[1]++;
                str_count.put(B_str, counts);
            }
            for (String str : str_count.keySet()) {
                if (str_count.get(str)[0] + str_count.get(str)[1] == 1)
                    result.add(str);
            }
            return result.toArray(new String[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}