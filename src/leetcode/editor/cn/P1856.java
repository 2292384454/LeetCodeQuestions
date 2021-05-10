package leetcode.editor.cn;//240场周赛第3题
//一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
//
//比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
//给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  109 + 7 取余 的结果。
//
//请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
//
//子数组 定义为一个数组的 连续 部分。
//
// 
//
//示例 1：
//
//输入：nums = [1,2,3,2]
//输出：14
//解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
//2 * (2+3+2) = 2 * 7 = 14 。
//示例 2：
//
//输入：nums = [2,3,3,1,2]
//输出：18
//解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
//3 * (3+3) = 3 * 6 = 18 。
//示例 3：
//
//输入：nums = [3,1,5,6,4,2]
//输出：60
//解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
//4 * (5+6+4) = 4 * 15 = 60 。
// 
//
//提示：
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 107
//

import java.util.Arrays;
import java.util.Stack;

/**
 * 描述.
 * <p>
 * 创建时间: 2021/5/10 15:29
 *
 * @author KevinHwang
 */
public class P1856 {
    public static void main(String[] args) {
        Solution solution = new P1856().new Solution();
        int[] nums = new int[]{2, 3, 3, 1, 2};
        System.out.println(solution.maxSumMinProduct(nums));
    }

    class Solution {
        public int maxSumMinProduct(int[] nums) {
            int len = nums.length;
            Stack<Integer> stack = new Stack<>();
            int[] recordLeft = new int[len];// 元素左边第一个比其小的元素的位置+1，如果没有就为0
            int[] recordRight = new int[len];// 元素右边第一个比其小的元素的位置-1，如果没有就为len-1
            // 计算recordLeft
            Arrays.fill(recordRight, len - 1);
            for (int i = 0; i < len; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    recordRight[stack.pop()] = i - 1;
                }
                stack.push(i);
            }
            // 计算recordLeft
            stack.clear();
            for (int i = len - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    recordLeft[stack.pop()] = i + 1;
                }
                stack.push(i);
            }
            // 计算数组前缀和，preSum[i]为nums[0,i)的和（0<=i<=len）。
            long[] preSum = new long[len + 1];
            for (int i = 1; i <= len; i++) preSum[i] = nums[i - 1] + preSum[i - 1];
            long ans = 0, temp;
            for (int i = 0; i < len; i++) {
                // recordRight[i] + 1为元素右边第一个比其小的元素的位置
                // recordLeft[i]为元素左边第一个比其小的元素的位置
                if ((temp = nums[i] * (preSum[recordRight[i] + 1] - preSum[recordLeft[i]])) > ans)
                    ans = temp;
            }
            return (int) (ans % 1000000007L);
        }
    }
}
