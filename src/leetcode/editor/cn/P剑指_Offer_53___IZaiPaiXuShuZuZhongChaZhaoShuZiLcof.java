//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 145 👎 0

package leetcode.editor.cn;

//Java：在排序数组中查找数字 I
public class P剑指_Offer_53___IZaiPaiXuShuZuZhongChaZhaoShuZiLcof {

    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_53___IZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // TO TEST
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 这一次二分查找运行完之后 left 指向 target 的左边界（即查找8时， [5, 7, 7, 8, 8, 10] 中的第一个 8）
            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] == target) {
                    // 收缩右侧边界
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            int ans = left;
            // 这一次二分查找运行完之后 right 指向 target 的右边界（即查找8时， [5, 7, 7, 8, 8, 10] 中的最后一个 8）
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] == target) {
                    //收缩左侧边界
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            ans = right - ans + 1;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}