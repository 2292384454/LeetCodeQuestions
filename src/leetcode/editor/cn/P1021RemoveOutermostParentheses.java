//有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"
//，"(())()" 和 "(()(()))" 都是有效的括号字符串。 
//
// 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。 
//
// 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。 
//
// 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。 
//
// 
//
// 示例 1： 
//
// 输入："(()())(())"
//输出："()()()"
//解释：
//输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
//删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 
//
// 示例 2： 
//
// 输入："(()())(())(()(()))"
//输出："()()()()(())"
//解释：
//输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
//删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
// 
//
// 示例 3： 
//
// 输入："()()"
//输出：""
//解释：
//输入字符串为 "()()"，原语化分解得到 "()" + "()"，
//删除每个部分中的最外层括号后得到 "" + "" = ""。
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 10000 
// S[i] 为 "(" 或 ")" 
// S 是一个有效括号字符串 
// 
// Related Topics 栈 
// 👍 150 👎 0

package leetcode.editor.cn;

//Java：删除最外层的括号
public class P1021RemoveOutermostParentheses {
    public static void main(String[] args) {
        Solution solution = new P1021RemoveOutermostParentheses().new Solution();
        // TO TEST
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeOuterParentheses(String S) {
            StringBuilder result = new StringBuilder();
            char[] sArray = S.toCharArray();
            int firstIndex = 0, top = -1;//栈顶指针
            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i] == '(') {//如果遍历到'('，将'('的位置入栈
                    if (top == -1) {
                        firstIndex = i;
                    }
                    top++;
                } else if (top != 0) {//如果遍历到')'并且栈顶指针没有指向第一个'('，那么出栈一个'('的位置
                    top--;
                } else {//如果遍历到')'并且栈顶指针指向第一个'('，说明此时从第一个'('的下一个位置到当前遍历的位置的子串应当加入到结果中
                    for (int j = firstIndex + 1; j < i; j++) {
                        result.append(sArray[j]);
                    }
                    top--;
                }
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
