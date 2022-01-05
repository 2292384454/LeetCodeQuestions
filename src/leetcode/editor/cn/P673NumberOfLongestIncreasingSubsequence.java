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

import java.util.Arrays;

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
            int n = nums.length;
            // len[i]存储截止nums[i]，nums中以nums[i]为最后元素的递增子序列的最大长度
            // count[i]存储截止nums[i]，拥有这样长度的递增子序列的数量
            int[] len = new int[n], count = new int[n];
            Arrays.fill(len, 1);
            Arrays.fill(count, 1);
            int largestSize = 1, ans = 1;
            for (int i = 1; i < nums.length; i++) {
                //所有元素都比nums[i]小的递增子序列中最长的长度
                int maxLen = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        if (len[j] > maxLen) {
                            maxLen = len[j];
                            count[i] = count[j];
                        } else if (len[j] == maxLen) {
                            count[i] += count[j];
                        }
                    }
                }
                len[i] += maxLen;
                if (len[i] > largestSize) {
                    largestSize = len[i];
                    ans = count[i];
                } else if (len[i] == largestSize) {
                    ans += count[i];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
