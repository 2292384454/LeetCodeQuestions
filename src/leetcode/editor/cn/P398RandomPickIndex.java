package leetcode.editor.cn;
//Java：随机数索引

import java.util.Random;

/**
 * <p>给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。</p>
 *
 * <p><strong>注意：</strong><br />
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 *
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 * </pre>
 * <div><div>Related Topics</div><div><li>水塘抽样</li><li>哈希表</li><li>数学</li><li>随机化</li></div></div><p><div><li>👍 114</li><li>👎 0</li></div>
 */
public class P398RandomPickIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution solution = new P398RandomPickIndex().new Solution(nums);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int pick(int target) {
            // 水塘抽样
            int count = 0, ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (random.nextInt(++count) == 0) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}