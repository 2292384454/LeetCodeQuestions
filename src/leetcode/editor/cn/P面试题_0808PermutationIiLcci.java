package leetcode.editor.cn;
//Java：有重复字符串的排列组合

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>：S = &quot;qqe&quot;
 * <strong> 输出</strong>：[&quot;eqq&quot;,&quot;qeq&quot;,&quot;qqe&quot;]
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：S = &quot;ab&quot;
 * <strong> 输出</strong>：[&quot;ab&quot;, &quot;ba&quot;]
 * </pre>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ol>
 * <li>字符都是英文字母。</li>
 * <li>字符串长度在[1, 9]之间。</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>字符串</li><li>回溯</li></div></div><p><div><li>👍 41</li><li>👎 0</li></div>
 */
public class P面试题_0808PermutationIiLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0808PermutationIiLcci().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.permutation("www")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> ans;

        public String[] permutation(String S) {
            ans = new HashSet<>();
            helper(S, 0, "");
            return ans.toArray(new String[0]);
        }

        private void helper(String S, int used, String str) {
            if (str.length() == S.length()) {
                ans.add(str);
                return;
            }
            for (int i = 0; i < S.length(); i++) {
                if ((used & (1 << i)) == 0) {
                    helper(S, used | (1 << i), str + S.charAt(i));
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}