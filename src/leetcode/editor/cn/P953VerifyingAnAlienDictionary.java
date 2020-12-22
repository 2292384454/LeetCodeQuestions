//某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。 
//
// 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 fals
//e。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//输出：true
//解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。 
//
// 示例 2： 
//
// 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//输出：false
//解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。 
//
// 示例 3： 
//
// 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//输出：false
//解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅'
// 是空白字符，定义为比任何其他字符都小（更多信息）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// 在 words[i] 和 order 中的所有字符都是英文小写字母。 
// 
// Related Topics 哈希表 
// 👍 64 👎 0

package leetcode.editor.cn;

//Java：验证外星语词典
public class P953VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        Solution solution = new P953VerifyingAnAlienDictionary().new Solution();
        // TO TEST
        String[] words = new String[]{"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(solution.isAlienSorted(words, order));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] character_order = new int[26];
            for (int i = 0; i < order.length(); i++)
                character_order[order.charAt(i) - 'a'] = i;
            for (int i = 0; i < words.length - 1; i++) {
                if (!compare(words[i], words[i + 1], character_order))
                    return false;
            }
            return true;
        }

        public boolean compare(String s1, String s2, int[] character_order) {
            int i = 0;
            for (; i < s1.length() && i < s2.length(); i++) {
                if (character_order[s1.charAt(i) - 'a'] < character_order[s2.charAt(i) - 'a'])
                    return true;
                else if (character_order[s1.charAt(i) - 'a'] > character_order[s2.charAt(i) - 'a'])
                    return false;
            }
            return i != s2.length() || i >= s1.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
