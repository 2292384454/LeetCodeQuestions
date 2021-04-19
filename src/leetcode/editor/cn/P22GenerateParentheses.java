//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1560 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            help("", n, n);
            return ans;
        }

        public void help(String str, int left, int right) {
            if (left == 0) {
                for (int i = 0; i < right; i++)
                    str += ")";
                ans.add(str);
            } else if (left == right) {
                help(str + "(", left - 1, right);
            } else if (left < right) {
                help(str + "(", left - 1, right);
                help(str + ")", left, right - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
