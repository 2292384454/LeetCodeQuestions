//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1180 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和
public class P39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> ans = solution.combinationSum(candidates, 7);
        for (List<Integer> l : ans) {
            for (Integer x : l) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<Integer> list = new ArrayList<>();
            help(candidates, target, list);
            return ans;
        }

        //真正实现寻找解集的辅助函数
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
            //candidates[0]可能在list中出现0次，1次，2次……n次，只要n*candidates[0]<=target即可
            for (int j = 0; j <= target; j += candidates[0]) {
                if (j > 0) {
                    copy.add(candidates[0]);
                }
                //对于candidates[0]的每种出现次数，进行递归，在candidates除第0个元素的后缀数组中进行递归
                help(Arrays.copyOfRange(candidates, 1, candidates.length), target - j, copy);
            }


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
