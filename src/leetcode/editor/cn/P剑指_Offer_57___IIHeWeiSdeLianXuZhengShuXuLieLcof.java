//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 
// 👍 282 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：和为s的连续正数序列
public class P剑指_Offer_57___IIHeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_57___IIHeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int left = 1; // 滑动窗口的左边界，只能向右移动
            int right = 1; // 滑动窗口的右边界，只能向右移动
            int sum = 0; // 滑动窗口中数字的和
            List<int[]> res = new ArrayList<>();
            while (left <= target / 2) {
                if (sum < target) {
                    // 右边界向右移动
                    sum += right;
                    right++;
                } else if (sum > target) {
                    // 左边界向右移动
                    sum -= left;
                    left++;
                } else {
                    // 记录结果
                    int[] arr = new int[right - left];
                    for (int k = left; k < right; k++) {
                        arr[k - left] = k;
                    }
                    res.add(arr);
                    //左边界或右边界向右移动都可以

                    // // 左边界向右移动
                    // sum -= left;
                    // left++;

                    // 右边界向右移动
                    sum += right;
                    right++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}