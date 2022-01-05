//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1397 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：柱状图中最大的矩形
public class P84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        // TO TEST
        int[] heights = new int[]{5, 4, 3, 1, 5, 2};
        System.out.println(solution.largestRectangleArea(heights));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            // left[i]记录第i个位置左边的第一个比heights[i]矮的元素的位置，如果没有就记录成-1
            int[] left = new int[n];
            // right[i]记录第i个位置右边的第一个比heights[i]矮的元素的位置，如果没有就记录成n
            int[] right = new int[n];
            // mono_stack，单调栈，从栈底到栈顶对应的元素严格单调递增
            Stack<Integer> mono_stack = new Stack<>();
            // 从左往右遍历
            for (int i = 0; i < n; i++) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    mono_stack.pop();
                }
                left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
                mono_stack.push(i);
            }
            mono_stack.clear();
            // 从右往左遍历
            for (int i = n - 1; i >= 0; i--) {
                while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                    mono_stack.pop();
                }
                right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
                mono_stack.push(i);
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}