//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 2 * 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 栈 
// 👍 520 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//Java：132 模式
public class P456One32Pattern {
    public static void main(String[] args) {
        Solution solution = new P456One32Pattern().new Solution();
        // TO TEST
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(solution.find132pattern(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 枚举i的做法
     */
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            // 维护一个元素值比 nums[i] 大的单调递减栈（非严格递减）
            Deque<Integer> stack = new LinkedList<>();
            // max 维护 “ 对于当前的nums[i]，有资格做nums[j]的最大元素 ”
            int max = Integer.MIN_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                // 如果 nums[i] 比 max 小，那么 max 就是 nums[j]
                if (nums[i] < max) {
                    return true;
                }
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    max = stack.poll();
                }
                stack.push(nums[i]);
            }
            return false;
        }
    }

    /**
     * 枚举j的做法
     */
    // class Solution {
    //     public boolean find132pattern(int[] nums) {
    //         int len = nums.length;
    //         if (len < 3) {
    //             return false;
    //         }
    //         //min[i]表示 子数组nums[0:i] 的最小值
    //         int[] min = new int[len];
    //         min[0] = nums[0];
    //         for (int i = 1; i < len; i++) {
    //             min[i] = Math.min(min[i - 1], nums[i]);
    //         }
    //         // 维护一个元素值比 min[i] 大的单调递减栈
    //         Deque<Integer> stack = new LinkedList<>();
    //         stack.push(nums[len - 1]);
    //         for (int j = len - 2; j >= 1; j--) {
    //             if (nums[j] > min[j]) {
    //                 while (!stack.isEmpty() && stack.peek() <= min[j]) {
    //                     stack.pop();
    //                 }
    //                 //此时栈顶元素一定大于min[j]
    //                 if (!stack.isEmpty() && nums[j] > stack.peek()) {
    //                     return true;
    //                 }
    //                 stack.push(nums[j]);
    //             }
    //         }
    //         return false;
    //     }
    // }
//leetcode submit region end(Prohibit modification and deletion)

}