package leetcode.editor.cn;

public class P915PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        Solution solution = new P915PartitionArrayIntoDisjointIntervals().new Solution();
        // TO TEST
        int[] nums = new int[]{5, 0, 3, 8, 6};
        System.out.println(solution.partitionDisjoint(nums));
    }

    //Java：分割数组
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length, maxFromLeft = Integer.MIN_VALUE;
            int[] minValFromRight = new int[n];
            minValFromRight[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                minValFromRight[i] = Math.min(minValFromRight[i + 1], nums[i]);
            }
            for (int i = 0; i < n - 1; i++) {
                maxFromLeft = Math.max(maxFromLeft, nums[i]);
                if (maxFromLeft <= minValFromRight[i + 1]) {
                    return i + 1;
                }
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}