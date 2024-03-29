//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 
// 👍 280 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：滑动窗口的最大值
public class P剑指_Offer_59___IHuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_59___IHuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k == 0) {
                return new int[0];
            }
            int n = nums.length;
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[n - k + 1];
            for (int i = 1 - k, j = 0; j < n; i++, j++) {
                // 删除 deque 中对应的 nums[i-1]
                if (i > 0 && deque.peekFirst() == nums[i - 1])
                    deque.removeFirst();
                // 保持 deque 递减
                while (!deque.isEmpty() && deque.peekLast() < nums[j])
                    deque.removeLast();
                deque.addLast(nums[j]);
                // 记录窗口最大值
                if (i >= 0)
                    res[i] = deque.peekFirst();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}