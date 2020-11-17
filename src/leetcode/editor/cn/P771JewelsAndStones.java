//给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。 
//
// J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。 
//
// 示例 1: 
//
// 输入: J = "aA", S = "aAAbbbb"
//输出: 3
// 
//
// 示例 2: 
//
// 输入: J = "z", S = "ZZ"
//输出: 0
// 
//
// 注意: 
//
// 
// S 和 J 最多含有50个字母。 
// J 中的字符不重复。 
// 
// Related Topics 哈希表 
// 👍 605 👎 0

package leetcode.editor.cn;

//Java：宝石与石头
public class P771JewelsAndStones {
    public static void main(String[] args) {
        Solution solution = new P771JewelsAndStones().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numJewelsInStones(String J, String S) {
            byte char_count[] = new byte[100], result = 0;
            char S_Array[] = S.toCharArray(), J_Array[] = J.toCharArray();
            for (char x : S_Array)
                char_count[x - 'A']++;
            for (char x : J_Array)
                result += (char_count[x - 'A']);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}