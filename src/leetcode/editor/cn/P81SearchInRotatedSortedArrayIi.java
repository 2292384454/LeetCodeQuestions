//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。 
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。 
//
// 示例 1: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
// 
//
// 示例 2: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false 
//
// 进阶: 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 304 👎 0

package leetcode.editor.cn;

//Java：搜索旋转排序数组 II
public class P81SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new P81SearchInRotatedSortedArrayIi().new Solution();
        // TO TEST
        int[] array = new int[]{1, 2};
        System.out.println(solution.search(array, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            if (nums.length == 0) return false;//数组长度为0
            if (nums[0] == target) return true;//数组第一个元素就是target（主要为了防止数组元素全部相等的情况）
            int low = 0, high = nums.length - 1, mid;
            if (nums[low] == nums[high]) {//如果数组刚好第一个元素与最后一个元素相等
                while (high >= 0 && nums[high] == nums[low]) high--;//就跳过最后的所有与nums[0]相等的元素
            }

            while (low <= high) {
                mid = (high + low) / 2;
                if (nums[mid] == target)
                    return true;
                if ((nums[mid] < target && target < nums[0]) || (nums[0] <= nums[mid] && (nums[mid] < target || target < nums[0])))
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
