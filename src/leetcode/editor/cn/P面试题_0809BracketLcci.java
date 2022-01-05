package leetcode.editor.cn;
//Java：括号

import java.util.ArrayList;
import java.util.List;

/**
 * <p>括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。</p>
 *
 * <p>说明：解集不能包含重复的子集。</p>
 *
 * <p>例如，给出 n = 3，生成结果为：</p>
 *
 * <pre>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * </pre>
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li><li>回溯</li></div></div><p><div><li>👍 77</li><li>👎 0</li></div>
 */
public class P面试题_0809BracketLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0809BracketLcci().new Solution();
        // TO TEST
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans;

        public List<String> generateParenthesis(int n) {
            ans = new ArrayList<>();
            helper(n, 0, 0, "");
            return ans;
        }

        /**
         * 回溯法.
         *
         * @param n     括号总对数
         * @param state 当前状态（每添加一个左括号状态 +1 ，添加一个右括号状态 -1 ）
         * @param count 当前左括号数量
         * @param cur   当前字符串
         */
        private void helper(int n, int state, int count, String cur) {
            if (cur.length() == (n << 1)) {
                ans.add(cur);
                return;
            }
            if (state > 0) {
                // 左括号比右括号多，可以插入右括号
                helper(n, state - 1, count, cur + ")");
            }
            if (count < n) {
                // 左括号还没有用完，可以插入左括号
                helper(n, state + 1, count + 1, cur + "(");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}