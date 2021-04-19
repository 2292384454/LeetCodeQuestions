//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 515 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
        solution.combine(4, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            help(1, n, k, new ArrayList<>());
            return ans;
        }

        public void help(int start, int n, int k, List<Integer> list) {
            List<Integer> copy = new ArrayList<>(list);
            if (k == 0) {
                ans.add(copy);
                return;
            } else if (k == (n - start + 1)) {
                for (int i = start; i <= n; i++)
                    copy.add(i);
                ans.add(copy);
                return;
            } else if (k > (n - start + 1))
                return;
            help(start + 1, n, k, copy);
            copy.add(start);
            help(start + 1, n, k - 1, copy);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
