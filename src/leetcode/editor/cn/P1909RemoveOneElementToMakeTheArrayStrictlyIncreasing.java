package leetcode.editor.cn;
//Java：删除一个元素使数组严格递增

/**
 * <p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> ，如果 <strong>恰好</strong> 删除 <strong>一个</strong> 元素后，数组 <strong>严格递增</strong> ，那么请你返回 <code>true</code> ，否则返回 <code>false</code> 。如果数组本身已经是严格递增的，请你也返回 <code>true</code> 。</p>
 *
 * <p>数组 <code>nums</code> 是 <strong>严格递增</strong> 的定义为：对于任意下标的 <code>1 &lt;= i &lt; nums.length</code> 都满足 <code>nums[i - 1] &lt; nums[i]</code> 。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><b>输入：</b>nums = [1,2,<strong>10</strong>,5,7]
 * <b>输出：</b>true
 * <b>解释：</b>从 nums 中删除下标 2 处的 10 ，得到 [1,2,5,7] 。
 * [1,2,5,7] 是严格递增的，所以返回 true 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><b>输入：</b>nums = [2,3,1,2]
 * <b>输出：</b>false
 * <b>解释：</b>
 * [3,1,2] 是删除下标 0 处元素后得到的结果。
 * [2,1,2] 是删除下标 1 处元素后得到的结果。
 * [2,3,2] 是删除下标 2 处元素后得到的结果。
 * [2,3,1] 是删除下标 3 处元素后得到的结果。
 * 没有任何结果数组是严格递增的，所以返回 false 。</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><b>输入：</b>nums = [1,1,1]
 * <b>输出：</b>false
 * <b>解释：</b>删除任意元素后的结果都是 [1,1] 。
 * [1,1] 不是严格递增的，所以返回 false 。
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre><b>输入：</b>nums = [1,2,3]
 * <b>输出：</b>true
 * <b>解释：</b>[1,2,3] 已经是严格递增的，所以返回 true 。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= nums.length &lt;= 1000</code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li></div></div><p><div><li>👍 10</li><li>👎 0</li></div>
 */
public class P1909RemoveOneElementToMakeTheArrayStrictlyIncreasing {
    public static void main(String[] args) {
        Solution solution = new P1909RemoveOneElementToMakeTheArrayStrictlyIncreasing().new Solution();
        // TO TEST
        int[] nums = new int[]{100, 21, 100};
        System.out.println(solution.canBeIncreasing(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canBeIncreasing(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] <= nums[i - 1]) {
                    return check(nums, i) || check(nums, i - 1);
                }
            }
            return true;
        }

        public boolean check(int[] nums, int skip) {
            for (int i = 0; i < nums.length; i++) {
                if (i == skip) {
                    if (++i >= nums.length) {
                        break;
                    }
                    if (nums[i] <= (i - 2 >= 0 ? nums[i - 2] : Integer.MIN_VALUE)) {
                        return false;
                    }
                } else if (nums[i] <= (i - 2 >= 0 ? nums[i - 1] : Integer.MIN_VALUE)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}