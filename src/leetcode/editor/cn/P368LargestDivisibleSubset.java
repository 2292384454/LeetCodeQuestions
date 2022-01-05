//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 109 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数学 动态规划 
// 👍 214 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：最大整除子集
public class P368LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new P368LargestDivisibleSubset().new Solution();
        // TO TEST
        int[] nums = new int[]{2, 3, 4, 9, 8};
        System.out.println(solution.largestDivisibleSubset(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);//对nums进行排序
            //以下所有叙述中的nums均指排序后的nums
            int n = nums.length;
            LinkedList[] dp = new LinkedList[n];
            LinkedList<Integer> list0 = new LinkedList<>();
            list0.add(nums[0]);
            dp[0] = list0;
            int listSize = 0;
            LinkedList<Integer> ans = list0;
            for (int i = 1; i < n; i++) {
                int maxSize = 0;
                LinkedList<Integer> largestList = new LinkedList<>();
                for (int j = 0; j < i; j++) {
                    LinkedList<Integer> linkedList = dp[j];
                    if (nums[i] % linkedList.peekLast() == 0 && linkedList.size() > maxSize) {
                        maxSize = linkedList.size();
                        largestList = new LinkedList<>(linkedList);
                    }
                }
                dp[i] = new LinkedList(largestList);
                dp[i].add(nums[i]);
                if (maxSize + 1 > listSize) {
                    listSize = maxSize + 1;
                    ans = dp[i];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
