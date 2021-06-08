//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 动态规划 
// 👍 295 👎 0

package leetcode.editor.cn;

//Java：最长递增子序列的个数
public class P673NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P673NumberOfLongestIncreasingSubsequence().new Solution();
        // TO TEST
        int[] nums = new int[]{2, 2, 2, 2, 2};
        System.out.println(solution.findNumberOfLIS(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // dp[i][0]存储截止nums[i]，nums中以nums[i]为最后元素的递增子序列的最大长度
            // dp[i][1]存储截止nums[i]，拥有这样长度的递增子序列的数量
            int[][] dp = new int[nums.length][2];
            int largestSize = 1, ans = 1;
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < 2; j++) {
                    dp[i][j] = 1;
                }
            }
            for (int i = 1; i < nums.length; i++) {
                int max = 0;//所有元素都比nums[i]小的递增子序列中最长的长度
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        if (dp[j][0] > max) {
                            max = dp[j][0];
                            dp[i][1] = dp[j][1];
                        } else if (dp[j][0] == max) {
                            dp[i][1] += dp[j][1];
                        }
                    }
                }
                dp[i][0] += max;
                if (dp[i][0] > largestSize) {
                    largestSize = dp[i][0];
                    ans = dp[i][1];
                } else if (dp[i][0] == largestSize) {
                    ans += dp[i][1];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
