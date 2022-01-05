package leetcode.editor.cn;
//Java：获取生成数组中的最大值

public class P1646GetMaximumInGeneratedArray {
    public static void main(String[] args) {
        Solution solution = new P1646GetMaximumInGeneratedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaximumGenerated(int n) {
            int[] nums = new int[n + 1];
            if (n <= 1) {
                return 0;
            }
            nums[0] = 0;
            nums[1] = 1;
            int max = 0;
            for (int i = 2; i <= n; i++) {
                if (i % 2 == 0) {
                    nums[i] = nums[i >> 1];
                } else {
                    nums[i] = nums[(i - 1) >> 1] + nums[(i - 1) >> 1 + 1];
                }
                max = Math.max(max, nums[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}