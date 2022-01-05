//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 示例 1: 
//
// 输入: [1,12,-5,-6,50,3], k = 4
//输出: 12.75
//解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 注意: 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 111 👎 0

package leetcode.editor.cn;

//Java：子数组最大平均数 I
public class P643MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new P643MaximumAverageSubarrayI().new Solution();
        // TO TEST
        System.out.println(solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            if (nums.length < k) {
                return 0;
            }
            double result = 0.0, sum = 0.0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            result = sum;
            for (int i = k; i < nums.length; i++) {
                sum = sum - nums[i - k] + nums[i];
                result = Math.max(result, sum);
            }
            result /= k;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}