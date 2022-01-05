//给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。 
//
// 
//
// 示例 1: 
//
// 输入: [1,3,5,4,7]
//输出: 3
//解释: 最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
// 
//
// 示例 2: 
//
// 输入: [2,2,2,2,2]
//输出: 1
//解释: 最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 注意：数组长度不会超过10000。 
// Related Topics 数组 
// 👍 118 👎 0

package leetcode.editor.cn;

//Java：最长连续递增序列
public class P674LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P674LongestContinuousIncreasingSubsequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            int result = 0, temp = 1;
            for (int i = 1; i < nums.length; i++) {
                while (i < nums.length && nums[i] > nums[i - 1]) {
                    i++;
                    temp++;
                }
                result = Math.max(result, temp);
                temp = 1;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}