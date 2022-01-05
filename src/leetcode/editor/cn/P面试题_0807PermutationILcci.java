package leetcode.editor.cn;
//Java：无重复字符串的排列组合

import java.util.Arrays;

/**
 * <p>无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。</p>
 *
 * <p> <strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：S = "qwe"
 * <strong> 输出</strong>：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * </pre>
 *
 * <p> <strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：S = "ab"
 * <strong> 输出</strong>：["ab", "ba"]
 * </pre>
 *
 * <p> <strong>提示:</strong></p>
 *
 * <ol>
 * <li>字符都是英文字母。</li>
 * <li>字符串长度在[1, 9]之间。</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>字符串</li><li>回溯</li></div></div><p><div><li>👍 49</li><li>👎 0</li></div>
 */
public class P面试题_0807PermutationILcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0807PermutationILcci().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.permutation("HRBFIi")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] ans;
        int count = 0;

        public String[] permutation(String S) {
            int n = S.length();
            int ansLen = 1;
            while (n > 0) {
                ansLen *= (n--);
            }
            // 所有排列组合的数量是 n!
            ans = new String[ansLen];
            helper(S, 0, "");
            return ans;
        }

        private void helper(String S, int used, String str) {
            if (str.length() == S.length()) {
                ans[count++] = str;
                return;
            }
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (((1 << i) & used) == 0) {
                    helper(S, used | (1 << i), str + c);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}