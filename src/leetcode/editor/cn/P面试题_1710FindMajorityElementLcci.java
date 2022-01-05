package leetcode.editor.cn;
//Java：主要元素

/**
 * <p>数组中占比超过一半的元素称之为主要元素。给你一个<strong> 整数 </strong>数组，找出其中的主要元素。若没有，返回 <code>-1</code> 。请设计时间复杂度为 <code>O(N)</code> 、空间复杂度为 <code>O(1)</code> 的解决方案。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>[1,2,5,9,5,9,5,5,5]
 * <strong>输出：</strong>5</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>[3,2]
 * <strong>输出：</strong>-1</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>[2,2,1,1,1,2,2]
 * <strong>输出：</strong>2</pre>
 * <div><div>Related Topics</div><div><li>数组</li><li>计数</li></div></div><p><div><li>👍 156</li><li>👎 0</li></div>
 */
public class P面试题_1710FindMajorityElementLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_1710FindMajorityElementLcci().new Solution();
        // TO TEST
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution.majorityElement(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            // 投票法找众数
            int tickets = 0;
            int candidate = -1;
            for (int num : nums) {
                if (tickets == 0) {
                    candidate = num;
                }
                tickets += (candidate == num) ? 1 : -1;
            }
            // 验证众数出现次数有没有超过数组总长度的一半
            int count = 0;
            int len = nums.length;
            for (int num : nums) {
                if (num == candidate) {
                    count++;
                }
            }
            return count * 2 > len ? candidate : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}