package leetcode.editor.cn;
//Java：和相同的二元子数组

import java.util.HashMap;

/**
 * <p>给你一个二元数组 <code>nums</code> ，和一个整数 <code>goal</code> ，请你统计并返回有多少个和为 <code>goal</code> 的<strong> 非空</strong> 子数组。</p>
 *
 * <p><strong>子数组</strong> 是数组的一段连续部分。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,0,1,0,1], goal = 2
 * <strong>输出：</strong>4
 * <strong>解释：</strong>
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0,0,0,0,0], goal = 0
 * <strong>输出：</strong>15
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= nums.length <= 3 * 10<sup>4</sup></code></li>
 * <li><code>nums[i]</code> 不是 <code>0</code> 就是 <code>1</code></li>
 * <li><code>0 <= goal <= nums.length</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li><li>滑动窗口</li></div></div><p><div><li>👍 205</li><li>👎 0</li></div>
 */
public class P930BinarySubarraysWithSum {
    public static void main(String[] args) {
        Solution solution = new P930BinarySubarraysWithSum().new Solution();
        // TO TEST
        int[] nums = new int[]{1, 0, 1, 0, 1};
        System.out.println(solution.numSubarraysWithSum(nums, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarraysWithSum(int[] nums, int t) {
            int ans = 0, len = nums.length;
            // 前缀和数组
            int[] sum = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            // map: 有 value 个前缀和为 key
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 1; i <= len; i++) {
                int r = sum[i], l = r - t;
                ans += map.getOrDefault(l, 0);
                map.put(r, map.getOrDefault(r, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}