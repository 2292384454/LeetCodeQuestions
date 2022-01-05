//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 302 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合总和 III
public class P216CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new P216CombinationSumIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            if (n > k * 9) {
                return ans;
            }
            backtracking(k, n, new ArrayList<>(), 1, 9);
            return ans;
        }

        /**
         * 真正实现“找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。“的方法，采用回溯法.
         *
         * @param k    能够使用的数字数量
         * @param n    要达到的目的和
         * @param list 回溯传参
         * @param min  能用的数字下界
         * @param max  能用的数字上界
         */
        public void backtracking(int k, int n, List<Integer> list, int min, int max) {
            if (n == 0 && k == 0) {
                ans.add(new ArrayList<>(list));
                return;
            } else if (n == 0 || k == 0) {
                return;
            }
            for (int i = min; i <= max; i++) {
                if (i <= n) {
                    list.add(i);
                    backtracking(k - 1, n - i, list, i + 1, max);
                    list.remove(list.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
