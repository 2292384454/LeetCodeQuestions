//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 506 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和 II
public class P40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<Integer> list = new ArrayList<>();
            help(candidates, target, list);

            return ans;
        }

        public void help(int[] candidates, int target, List<Integer> list) {
            List<Integer> copy = new ArrayList<>(list);//对原List进行复制，以下都针对复制的copy进行操作，以实现类似值传递的效果
            if (target == 0) {//如果target==0，说明目前list里的元素和就等于target了，在ans中添加list返回即可
                ans.add(copy);
                return;
            }
            //如果candidates长度为0了或者target < candidates[0]了，说明不可能在这轮找到符合条件的list了，退出辅助函数
            if (candidates.length == 0 || target < candidates[0]) {
                return;
            }
            //i记录candidates[0]最后一次出现的位置，同时也是次数减1
            int i = 0;
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
            //candidates[0]可能在list中出现0次，1次，2次……n次，只要n<=(i + 1)并且n*candidates[0]<=target即可
            for (int j = 0; j <= (i + 1) * candidates[0] && j <= target; j += candidates[0]) {
                if (j > 0) {
                    copy.add(candidates[0]);
                }
                //对于candidates[0]的每种出现次数，进行递归，在candidates除第0个元素的后缀数组中进行递归
                help(Arrays.copyOfRange(candidates, i + 1, candidates.length), target - j, copy);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
