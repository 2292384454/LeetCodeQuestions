//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变
//化后可能得到：
// 
// 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4] 
// 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7] 
// 
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], 
//..., a[n-2]] 。 
//
// 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,5]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,0,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转 
// 
//
// 
//
// 进阶： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 367 👎 0

package leetcode.editor.cn;

//Java：寻找旋转排序数组中的最小值 II
public class P154FindMinimumInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new P154FindMinimumInRotatedSortedArrayIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            if (nums.length == 1) {
                return nums[0];//如果只有一个元素就返回之
            }
            int n = nums.length;
            int low = 0, high = n - 1, mid;
            while (high >= 0 && nums[high] == nums[0]) {
                high--;
            }
            // 所有元素均相等的情况
            if (high < 0) {
                return nums[0];
            }
            // 没有旋转或者旋转次数是 n 的倍数的情况
            if (nums[0] < nums[high]) {
                return nums[0];
            }
            while (low <= high) {
                mid = (low + high) >> 1;
                // mid 指向最小值左边，去右半边查找
                if (nums[mid] >= nums[0]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return nums[low];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}