package leetcode.editor.cn;
//Java：最高频元素的频数

import java.util.Arrays;

/**
 * <p>元素的 <strong>频数</strong> 是该元素在一个数组中出现的次数。</p>
 *
 * <p>给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> 。在一步操作中，你可以选择 <code>nums</code> 的一个下标，并将该下标对应元素的值增加 <code>1</code> 。</p>
 *
 * <p>执行最多 <code>k</code> 次操作后，返回数组中最高频元素的 <strong>最大可能频数</strong> <em>。</em></p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,4], k = 5
 * <strong>输出：</strong>3<strong>
 * 解释：</strong>对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,4,8,13], k = 5
 * <strong>输出：</strong>2
 * <strong>解释：</strong>存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [3,9,6], k = 2
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
 * <li><code>1 <= nums[i] <= 10<sup>5</sup></code></li>
 * <li><code>1 <= k <= 10<sup>5</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>前缀和</li><li>滑动窗口</li></div></div><p><div><li>👍 160</li><li>👎 0</li></div>
 */
public class P1838FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        Solution solution = new P1838FrequencyOfTheMostFrequentElement().new Solution();
        // TO TEST
        System.out.println(solution.maxFrequency(new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975,
                9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907,
                9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954,
                9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966}, 3056));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxFrequency(int[] nums, int k) {
            Arrays.sort(nums);
            int len = nums.length, ans = 1;
            int l = 0;
            // total：需要执行的自增操作次数
            int total = 0;
            for (int r = 1; r < len; r++) {
                total += (nums[r] - nums[r - 1]) * (r - l);
                // 当当前需要执行的自增操作次数超过 k 次时，左端点右移
                while (total > k) {
                    total -= (nums[r] - nums[l++]);
                }
                ans = Math.max(ans, r - l + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}