//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 855 👎 0

package leetcode.editor.cn;

//Java：搜索旋转排序数组
public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();
        // TO TEST
        int nums[] = {3, 1};
        System.out.println(solution.search(nums, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }
            int low = 0, high = nums.length - 1, mid;
            while (low <= high) {
                mid = (high + low) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                // 去右边查找的情况：
                // 1、nums[mid] < target < nums[0]，即当前位置和 target 所处位置都位于最小值右边且 nums[mid] < target
                // 2、target > nums[mid] >= nums[0]，即当前位置和 target 所处位置都位于最小值左边且 nums[mid] < target
                // 3、nums[mid] >= nums[0] && target < nums[0]，即当前位置在最小值左边且 target 所处位置位于最小值右边
                if ((nums[mid] < target && target < nums[0]) || (nums[mid] < target && nums[mid] >= nums[0])
                        || (nums[mid] >= nums[0] && target < nums[0])) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}