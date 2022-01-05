package leetcode.editor.cn;
//Java：接雨水

/**
 * <p>给定 <em>n</em> 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png" style="height: 161px; width: 412px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>height = [4,2,0,3,2,5]
 * <strong>输出：</strong>9
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>n == height.length</code></li>
 * <li><code>0 <= n <= 3 * 10<sup>4</sup></code></li>
 * <li><code>0 <= height[i] <= 10<sup>5</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>双指针</li><li>动态规划</li><li>单调栈</li></div></div><p><div><li>👍 2499</li><li>👎 0</li></div>
 */
public class P42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            if (n == 0) {
                return 0;
            }
            // leftMax[i] 记录 height[0,i] 的最大值
            int[] leftMax = new int[n];
            leftMax[0] = height[0];
            for (int i = 1; i < n; ++i) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            // rightMax[i] 记录 height[i,n-1] 的最大值
            int[] rightMax = new int[n];
            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            int ans = 0;
            // 每一列能存储的水加起来
            for (int i = 0; i < n; ++i) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}