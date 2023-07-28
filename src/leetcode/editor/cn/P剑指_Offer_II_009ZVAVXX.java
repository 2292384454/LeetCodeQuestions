package leetcode.editor.cn;
//Java：乘积小于 K 的子数组

/**
 * <p>给定一个正整数数组&nbsp;<code>nums</code>和整数 <code>k</code>&nbsp;，请找出该数组内乘积小于&nbsp;<code>k</code>&nbsp;的连续的子数组的个数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [10,5,2,6], k = 100
 * <strong>输出:</strong> 8
 * <strong>解释:</strong> 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [1,2,3], k = 0
 * <strong>输出:</strong> 0</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:&nbsp;</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
 * <li><code>0 &lt;= k &lt;= 10<sup>6</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 713&nbsp;题相同：<a href="https://leetcode-cn.com/problems/subarray-product-less-than-k/">https://leetcode-cn.com/problems/subarray-product-less-than-k/</a>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>滑动窗口</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_009ZVAVXX {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_009ZVAVXX().new Solution();
        // TO TEST
        int[] nums = new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        System.out.println(solution.numSubarrayProductLessThanK(nums, 19));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k <= 1) {return 0;}
            int prod = 1, ans = 0, l = 0;
            for (int r = 0; r < nums.length; r++) {
                prod *= nums[r];
                while (prod >= k) {
                    prod /= nums[l++];
                }
                ans += r - l + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}