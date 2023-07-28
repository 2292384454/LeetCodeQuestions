package leetcode.editor.cn;

public class P813LargestSumOfAverages {
    public static void main(String[] args) {
        Solution solution = new P813LargestSumOfAverages().new Solution();
        // TO TEST
        int[] nums = new int[]{9, 1, 2, 3, 9};
        System.out.println(solution.largestSumOfAverages(nums, 3));
    }

    //Java：最大平均值和的分组
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestSumOfAverages(int[] nums, int m) {
            int n = nums.length;
            double[] preSum = new double[n];
            preSum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            double[][] dp = new double[n][m]; //dp[i][j]为前i+1个数最多划分成j+1个子数组的平均值之和最大值
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= Math.min(m - 1, i); j++) {
                    if (j == 0) {
                        // 如果j=0，即 i+1 个数的平均值
                        dp[i][j] = preSum[i] / (i + 1);
                    } else {
                        // 如果 j!=0 ，那么取前 k+1 个数分成 j 组，k+2 到 i+1 共计 i-k 个数组成一组，计算平均数最大值
                        for (int k = j - 1; k < i; k++) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + (preSum[i] - preSum[k]) / (i - k));
                        }
                    }
                }
            }
            return dp[n - 1][m - 1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}