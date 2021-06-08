//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 
// 👍 47 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：“气球” 的最大数量
public class P1189MaximumNumberOfBalloons {
    public static void main(String[] args) {
        Solution solution = new P1189MaximumNumberOfBalloons().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfBalloons(String text) {
            int result = Integer.MAX_VALUE;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
                put('b', 1);
                put('a', 1);
                put('l', 2);
                put('o', 2);
                put('n', 1);
            }};//"balloon"中b出现1次，a出现1次，l出现2次，o出现2次，n出现1次
            int char_count[] = new int[26];
            for (char c : text.toCharArray()) {
                char_count[c - 'a']++;
            }
            for (char c : map.keySet()) {
                result = Math.min(result, char_count[c - 'a'] / map.get(c));
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
