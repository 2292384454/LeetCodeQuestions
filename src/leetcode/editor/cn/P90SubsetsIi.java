//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 363 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
public class P90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums); //对输入数组排序
            help(nums, 0, new ArrayList<>());
            return result;
        }

        private void help(int[] nums, int start, ArrayList<Integer> temp) {
            result.add(new ArrayList<>(temp));//先把当前子集加入结果
            for (int i = start; i < nums.length; i++) {
                //只有当前数字与上一个数字不相等时才进行下一步
                if (i == start || nums[i] != nums[i - 1]) {
                    temp.add(nums[i]);
                    help(nums, i + 1, temp);//将该数字加入子集进行递归
                    temp.remove(temp.size() - 1);//不将该数字加入子集，继续考察其他数字
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
