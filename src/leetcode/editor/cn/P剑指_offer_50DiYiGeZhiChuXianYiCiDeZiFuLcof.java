//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 107 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：第一个只出现一次的字符
public class P剑指_offer_50DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_50DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        // TO TEST
        System.out.println(solution.firstUniqChar("aadadaad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int count = map.getOrDefault(c, 0) + 1;
                map.put(c, count);
            }
            for (char c : s.toCharArray()) {
                if (map.get(c) == 1) {
                    return c;
                }
            }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}