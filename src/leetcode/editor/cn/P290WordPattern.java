//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 183 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：单词规律
public class P290WordPattern {
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        // TO TEST
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String words[] = str.split(" ");
            char patternArray[] = pattern.toCharArray();
            if (words.length != patternArray.length) {
                return false;
            }
            HashMap<Character, String> mymap = new HashMap<>();
            HashMap<String, Character> mymap2 = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                if (mymap.containsKey(patternArray[i]) && !mymap.get(patternArray[i]).equals(words[i])) {
                    return false;
                }
                if (mymap2.containsKey(words[i]) && !mymap2.get(words[i]).equals(patternArray[i])) {
                    return false;
                }
                mymap.put(patternArray[i], words[i]);
                mymap2.put(words[i], patternArray[i]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}