package leetcode.editor.cn;
//Java：和为 k 的子数组

import java.util.HashMap;

/**
 * <p>给定一个正整数数组和一个整数&nbsp;<code>k</code><strong> ，</strong>请找到该数组中和为&nbsp;<code>k</code><strong>&nbsp;</strong>的连续子数组的个数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1 :</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>nums = [1,1,1], k = 2
 * <strong>输出:</strong> 2
 * <strong>解释:</strong> 此题 [1,1] 与 [1,1] 为两种不同的情况
 * </pre>
 *
 * <p><strong>示例 2&nbsp;:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>nums = [1,2,3], k = 3
 * <strong>输出:</strong> 2
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>1000 &lt;= nums[i] &lt;= 1000</code></li>
 * <li>
 * <p><code>-10<sup>7</sup>&nbsp;&lt;= k &lt;= 10<sup>7</sup></code></p>
 * </li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p>注意：本题与主站 560&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/subarray-sum-equals-k/">https://leetcode-cn.com/problems/subarray-sum-equals-k/</a></p>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_010QTMn0o {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_010QTMn0o().new Solution();
        // TO TEST
        int[] nums = new int[]{-1, -1, 1};
        System.out.println(solution.subarraySum(nums, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int pre = 0, count = 0;
            // map 存储前缀和 key 出现了多少次
            HashMap<Integer, Integer> mp = new HashMap<>();
            mp.put(0, 1);
            for (int num : nums) {
                pre += num;
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}