//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 
// 👍 112 👎 0

package leetcode.editor.cn;

//Java：删除字符串中的所有相邻重复项
public class P1047RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new P1047RemoveAllAdjacentDuplicatesInString().new Solution();
        // TO TEST
        System.out.println(solution.removeDuplicates("abbaca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String S) {
            boolean repeated = false;//repeated记录循环是否结束，即字符串中是否存在两个相邻且相同的字母
            StringBuilder preSB = new StringBuilder(S), newSB = new StringBuilder();
            do {
                repeated = false;
                for (int i = 0; i < preSB.length(); i++) {
                    boolean temp = false;//temp记录本次循环中是否发现了两个相邻且相同的字母
                    //这里的if如果换成while，则可以将删除条件改为n个相邻且相同的字母(n>=2)
                    if (i >= 0 && i < preSB.length() - 1 && preSB.charAt(i) == preSB.charAt(i + 1)) {
                        i++;
                        repeated = true;
                        temp = true;
                    }
                    if (temp)
                        i++;
                    if (i < preSB.length())
                        newSB.append(preSB.charAt(i));
                }
                preSB = newSB;
                newSB = new StringBuilder();
            } while (repeated);
            return preSB.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
