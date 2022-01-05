package leetcode.editor.cn;
//Java：字典序排数

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给定一个整数&nbsp;<em>n</em>, 返回从&nbsp;<em>1&nbsp;</em>到&nbsp;<em>n&nbsp;</em>的字典顺序。</p>
 *
 * <p>例如，</p>
 *
 * <p>给定 <em>n</em> =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。</p>
 *
 * <p>请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据&nbsp;<em>n&nbsp;</em>小于等于&nbsp;5,000,000。</p>
 * <div><div>Related Topics</div><div><li>深度优先搜索</li><li>字典树</li></div></div><p><div><li>👍 182</li><li>👎 0</li></div>
 */
public class P386LexicographicalNumbers {
    public static void main(String[] args) {
        Solution solution = new P386LexicographicalNumbers().new Solution();
        // TO TEST
        System.out.println(solution.lexicalOrder(13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> ans = new ArrayList<>();

        public List<Integer> lexicalOrder(int n) {
            for (int i = 1; i < 10; i++) {
                dfs(i, n);
            }
            return ans;
        }

        private void dfs(int cur, int n) {
            if (cur > n) {
                return;
            }
            ans.add(cur);
            for (int i = 0; i < 10; i++) {
                dfs(cur * 10 + i, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}