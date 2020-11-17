//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

package leetcode.editor.cn;

//Java：最大子序和
public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        // TO TEST
        int array[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(array);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0) return 0;
            int max = nums[0];    // 全局最大值
            int subMax = nums[0];  // 前一个子组合的最大值,状态压缩
            for (int i = 1; i < nums.length; i++) {
                if (subMax > 0) {
                    // 前一个子组合最大值大于0，正增益
                    subMax = subMax + nums[i];
                } else {
                    // 前一个子组合最大值小于0，抛弃前面的结果
                    subMax = nums[i];
                }
                // 计算全局最大值
                max = Math.max(max, subMax);
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}