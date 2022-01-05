package leetcode.editor.cn;
//Java：0 和 1 个数相同的子数组

import java.util.HashMap;
import java.util.Map;

/**
 * <p>给定一个二进制数组 <code>nums</code> , 找到含有相同数量的 <code>0</code> 和 <code>1</code> 的最长连续子数组，并返回该子数组的长度。</p>
 *
 * <p>&nbsp;</p>
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
 * <strong>说明:</strong> [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>nums[i]</code> 不是 <code>0</code> 就是 <code>1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 525&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/contiguous-array/">https://leetcode-cn.com/problems/contiguous-array/</a></p>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_011A1NYOS {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_011A1NYOS().new Solution();
        // TO TEST
        int[] nums = new int[]{0, 1};
        System.out.println(solution.findMaxLength(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int sum = 0, ans = 0, n = nums.length;
            // map 记录前缀和与对应的索引位置
            Map<Integer, Integer> map = new HashMap<>(n);
            map.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] == 0 ? -1 : 1);
                if (map.containsKey(sum)) {
                    ans = Math.max(ans, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}