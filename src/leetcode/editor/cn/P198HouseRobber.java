//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1018 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：打家劫舍
public class P198HouseRobber {
    public static void main(String[] args) {
        Solution solution = new P198HouseRobber().new Solution();
        // TO TEST
        int nums[] = {2, 7, 9, 3, 1, 4, 4, 7, 8, 43, 46, 7, 65, 5, 42, 1, 21, 54, 54, 51, 2, 3, 45, 6, 56, 4, 53, 31, 24, 56, 56, 78, 7, 87, 88, 4, 5, 4, 51, 2, 1, 24, 5, 45, 8, 1};
        System.out.println(solution.rob(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            int dp[] = new int[len + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for (int k = 2; k <= len; k++)
                dp[k] = Math.max(dp[k - 1], nums[k - 1] + dp[k - 2]);
            return dp[len];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}