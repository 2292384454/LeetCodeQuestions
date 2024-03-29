//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 291 👎 0

package leetcode.editor.cn;

//Java：连续子数组的最大和
public class P剑指_offer_42LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_42LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int ans = nums[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}