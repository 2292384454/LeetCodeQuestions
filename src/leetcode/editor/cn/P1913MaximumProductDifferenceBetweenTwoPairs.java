package leetcode.editor.cn;
//Java：两个数对之间的最大乘积差

import java.util.Arrays;

/**
 * <p>两个数对 <code>(a, b)</code> 和 <code>(c, d)</code> 之间的 <strong>乘积差</strong> 定义为 <code>(a * b) - (c * d)</code> 。</p>
 *
 * <ul>
 * <li>例如，<code>(5, 6)</code> 和 <code>(2, 7)</code> 之间的乘积差是 <code>(5 * 6) - (2 * 7) = 16</code> 。</li>
 * </ul>
 *
 * <p>给你一个整数数组 <code>nums</code> ，选出四个 <strong>不同的</strong> 下标 <code>w</code>、<code>x</code>、<code>y</code> 和 <code>z</code> ，使数对 <code>(nums[w], nums[x])</code> 和 <code>(nums[y], nums[z])</code> 之间的 <strong>乘积差</strong> 取到 <strong>最大值</strong> 。</p>
 *
 * <p>返回以这种方式取得的乘积差中的 <strong>最大值</strong> 。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [5,6,2,7,4]
 * <strong>输出：</strong>34
 * <strong>解释：</strong>可以选出下标为 1 和 3 的元素构成第一个数对 (6, 7) 以及下标 2 和 4 构成第二个数对 (2, 4)
 * 乘积差是 (6 * 7) - (2 * 4) = 34
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [4,2,5,9,7,4,8]
 * <strong>输出：</strong>64
 * <strong>解释：</strong>可以选出下标为 3 和 6 的元素构成第一个数对 (9, 8) 以及下标 1 和 5 构成第二个数对 (2, 4)
 * 乘积差是 (9 * 8) - (2 * 4) = 64
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>4 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>排序</li></div></div><p><div><li>👍 4</li><li>👎 0</li></div>
 */
public class P1913MaximumProductDifferenceBetweenTwoPairs {
    public static void main(String[] args) {
        Solution solution = new P1913MaximumProductDifferenceBetweenTwoPairs().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProductDifference(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            return nums[len - 1] * nums[len - 2] - nums[0] * nums[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}