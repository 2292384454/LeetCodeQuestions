//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例: 
//
// 输入：
//s = "abcd"
//t = "abcde"
//
//输出：
//e
//
//解释：
//'e' 是那个被添加的字母。
// 
// Related Topics 位运算 哈希表 
// 👍 151 👎 0

package leetcode.editor.cn;

//Java：找不同
public class P389FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new P389FindTheDifference().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            String newstr = s + t;
            char str_array[] = newstr.toCharArray();
            int result = 0;
            for (char x : str_array)
                result = result ^ x;
            return (char) result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}