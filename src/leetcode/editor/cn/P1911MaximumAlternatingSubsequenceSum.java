package leetcode.editor.cn;
//Java：最大子序列交替和

/**
 * <p>一个下标从 <strong>0</strong> 开始的数组的 <strong>交替和</strong> 定义为 <strong>偶数</strong> 下标处元素之 <strong>和</strong> 减去 <strong>奇数</strong> 下标处元素之 <strong>和</strong> 。</p>
 *
 * <ul>
 * <li>比方说，数组 <code>[4,2,5,3]</code> 的交替和为 <code>(4 + 5) - (2 + 3) = 4</code> 。</li>
 * </ul>
 *
 * <p>给你一个数组 <code>nums</code> ，请你返回 <code>nums</code> 中任意子序列的 <strong>最大交替和</strong> （子序列的下标 <strong>重新</strong> 从 0 开始编号）。</p>
 *
 * <ul>
 * </ul>
 *
 * <p>一个数组的 <strong>子序列</strong> 是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，<code>[2,7,4]</code> 是 <code>[4,<strong>2</strong>,3,<strong>7</strong>,2,1,<strong>4</strong>]</code> 的一个子序列（加粗元素），但是 <code>[2,4,2]</code> 不是。</p>
 *
 * <p> </p>
 *
 * <p><b>示例 1：</b></p>
 *
 * <pre><b>输入：</b>nums = [<strong>4</strong>,<strong>2</strong>,<strong>5</strong>,3]
 * <b>输出：</b>7
 * <b>解释：</b>最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><b>输入：</b>nums = [5,6,7,<strong>8</strong>]
 * <b>输出：</b>8
 * <b>解释：</b>最优子序列为 [8] ，交替和为 8 。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><b>输入：</b>nums = [<strong>6</strong>,2,<strong>1</strong>,2,4,<strong>5</strong>]
 * <b>输出：</b>10
 * <b>解释：</b>最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><p><div><li>👍 14</li><li>👎 0</li></div>
 */
public class P1911MaximumAlternatingSubsequenceSum {
    public static void main(String[] args) {
        Solution solution = new P1911MaximumAlternatingSubsequenceSum().new Solution();
        // TO TEST
        int[] nums = new int[]{4, 2, 5, 3};
        System.out.println(solution.maxAlternatingSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxAlternatingSum(int[] nums) {
            int n = nums.length;
            // odd：以当前元素为最后一个奇数位元素时的结果
            // even：以当前元素为最后一个偶数位元素时的结果
            long odd = 0, even = nums[0];
            for (int i = 1; i < n; ++i) {
                odd = Math.max(even - nums[i], odd);
                even = Math.max(odd + nums[i], even);
            }
            return even;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}