package leetcode.editor.cn;
//Java：和大于等于 target 的最短子数组

/**
 * <p>给定一个含有&nbsp;<code>n</code><strong>&nbsp;</strong>个正整数的数组和一个正整数 <code>target</code><strong> 。</strong></p>
 *
 * <p>找出该数组中满足其和<strong> </strong><code>&ge; target</code><strong> </strong>的长度最小的 <strong>连续子数组</strong>&nbsp;<code>[nums<sub>l</sub>, nums<sub>l+1</sub>, ..., nums<sub>r-1</sub>, nums<sub>r</sub>]</code> ，并返回其长度<strong>。</strong>如果不存在符合条件的子数组，返回 <code>0</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>target = 7, nums = [2,3,1,2,4,3]
 * <strong>输出：</strong>2
 * <strong>解释：</strong>子数组&nbsp;<code>[4,3]</code>&nbsp;是该条件下的长度最小的子数组。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>target = 4, nums = [1,4,4]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>target = 11, nums = [1,1,1,1,1,1,1,1]
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p>提示：</p>
 *
 * <ul>
 * <li><code>1 &lt;= target &lt;= 10<sup>9</sup></code></li>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p>进阶：</p>
 *
 * <ul>
 * <li>如果你已经实现<em> </em><code>O(n)</code> 时间复杂度的解法, 请尝试设计一个 <code>O(n log(n))</code> 时间复杂度的解法。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 209&nbsp;题相同：<a href="https://leetcode-cn.com/problems/minimum-size-subarray-sum/">https://leetcode-cn.com/problems/minimum-size-subarray-sum/</a></p>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>前缀和</li><li>滑动窗口</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_008TwoVG8Kg {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_008TwoVG8Kg().new Solution();
        // TO TEST
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(7, nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE, n = nums.length;
            int l = 0, sum = 0;
            for (int r = 0; r < n; r++) {
                sum += (nums[r]);
                while (sum >= target) {
                    ans = Math.min(ans, r - l + 1);
                    sum -= (nums[l++]);
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}