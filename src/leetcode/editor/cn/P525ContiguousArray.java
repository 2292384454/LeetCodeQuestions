package leetcode.editor.cn;
//Java：连续数组

import java.util.Arrays;

/**
 * <p>给定一个二进制数组 <code>nums</code> , 找到含有相同数量的 <code>0</code> 和 <code>1</code> 的最长连续子数组，并返回该子数组的长度。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [0,1]
 * <strong>输出:</strong> 2
 * <strong>说明:</strong> [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [0,1,0]
 * <strong>输出:</strong> 2
 * <strong>说明:</strong> [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。</pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
 * <li><code>nums[i]</code> 不是 <code>0</code> 就是 <code>1</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li></div></div><p><div><li>👍 431</li><li>👎 0</li></div>
 */
public class P525ContiguousArray {
    public static void main(String[] args) {
        Solution solution = new P525ContiguousArray().new Solution();
        // TO TEST
        int[] nums = new int[]{0, 1};
        System.out.println(solution.findMaxLength(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int n = nums.length;
            // sum[i]: 前缀和，即 nums[0,i) 区间的和
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
            }
            int ans = 0;
            /*
            // 使用哈希表 map 来记录「某个前缀和出现的最小下标」是多少。
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 2; i <= n; i++) {
                if (!map.containsKey(sum[i - 2])) map.put(sum[i - 2], i - 2);
                if (map.containsKey(sum[i])) ans = Math.max(ans, i - map.get(sum[i]));
            }*/

            // 使用数组 hash 来记录「某个前缀和出现的最小下标」是多少。
            // 可能的前缀和范围为 [-n,n] 共 2*n+1 个数
            int[] hash = new int[2 * n + 1];
            Arrays.fill(hash, -1);
            for (int i = 2; i <= n; i++) {
                if (hash[sum[i - 2] + n] == -1) {
                    hash[sum[i - 2] + n] = i - 2;
                }
                if (hash[sum[i] + n] != -1) {
                    ans = Math.max(ans, i - hash[sum[i] + n]);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}