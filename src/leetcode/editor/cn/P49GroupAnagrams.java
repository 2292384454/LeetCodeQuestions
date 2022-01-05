//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 668 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//Java：字母异位词分组
public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> mymap = new HashMap<>();
            for (String str : strs) {
                char[] counts = new char[26];
                for (char c : str.toCharArray()) {
                    counts[c - 'a']++;
                }
                String keyStr = new String(counts);
                List<String> list = mymap.getOrDefault(keyStr, new ArrayList<>());
                list.add(str);
                mymap.put(keyStr, list);
            }
            return new ArrayList<>(mymap.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
