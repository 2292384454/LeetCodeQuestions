package leetcode.editor.cn;
//Java：旋转函数

/**
 * <p>给定一个长度为 <em>n</em> 的整数数组&nbsp;<code>A</code>&nbsp;。</p>
 *
 * <p>假设&nbsp;<code>B<sub>k</sub></code>&nbsp;是数组&nbsp;<code>A</code>&nbsp;顺时针旋转 <em>k</em> 个位置后的数组，我们定义&nbsp;<code>A</code>&nbsp;的&ldquo;旋转函数&rdquo;&nbsp;<code>F</code>&nbsp;为：</p>
 *
 * <p><code>F(k) = 0 * B<sub>k</sub>[0] + 1 * B<sub>k</sub>[1] + ... + (n-1) * B<sub>k</sub>[n-1]</code>。</p>
 *
 * <p>计算<code>F(0), F(1), ..., F(n-1)</code>中的最大值。</p>
 *
 * <p><strong>注意:</strong><br />
 * 可以认为<em> n</em> 的值小于 10<sup>5</sup>。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>
 * A = [4, 3, 2, 6]
 *
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 *
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 * </pre>
 * <div><div>Related Topics</div><div><li>数学</li><li>动态规划</li></div></div><p><div><li>👍 78</li><li>👎 0</li></div>
 */
public class P396RotateFunction {
    public static void main(String[] args) {
        Solution solution = new P396RotateFunction().new Solution();
        // TO TEST
        int[] nums = new int[]{4, 3, 2, 6};
        System.out.println(solution.maxRotateFunction(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRotateFunction(int[] nums) {
            int n = nums.length, F = 0, totalSum = 0;
            for (int i = 0; i < n; i++) {
                F += (i * nums[i]);
                totalSum += nums[i];
            }
            int ans = F;
            for (int i = 0; i < n; i++) {
                // sum = sum - (n - 1) * nums[n - 1 - i] + (totalSum - nums[n - 1 - i]);
                F += (totalSum - n * nums[n - 1 - i]);
                ans = Math.max(ans, F);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}