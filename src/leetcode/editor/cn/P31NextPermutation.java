//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 951 👎 0

package leetcode.editor.cn;

//Java：下一个排列
public class P31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void nextPermutation(int[] nums) {
            // i：从数组右边界开始遍历；low：需要和第i个数交换的位置，一开始左边界的数还没确定，因此定为-1
            // high：记录和low交换过的i的位置，为了和下一次的有效位置比较
            int i = nums.length - 1, low = -1, high = 0;
            while (i >= 0) {
                int last = nums[i], r = i - 1;
                while (r >= 0) {
                    // 这个判断是本题的关键点。low要尽量靠右（前提）；当low位置一样的时候，要选一个值最小的i位置（比如[1, 3, 2]这种情形）
                    if (low < r && nums[r] < last || low == r && nums[high] > nums[i]) {
                        low = r;
                        high = i;
                    }
                    r--;
                }
                i--;
            }
            if (high == 0) {
                // high为0表示上面遍历中从未找到过合适交换的数字，代表输入的数组已经是倒序的了，只需要排序即可（这里可以直接逆序，不一定要快排）
                sort(nums, 0, nums.length - 1);
            } else {
                // 交换最优的low和high的值，然后需要将low后面的一段进行排序
                swap(nums, low, high);
                sort(nums, low + 1, nums.length - 1);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // quick sort
        private void sort(int[] nums, int i, int j) {
            if (i >= j) {
                return;
            }
            int stan = nums[i];
            int low = i;
            int high = j;
            while (low < high) {
                while (high > low && nums[high] >= stan) {
                    high--;
                }
                nums[low] = nums[high];
                while (low < high && nums[low] <= stan) {
                    low++;
                }
                nums[high] = nums[low];
            }
            nums[low] = stan;
            sort(nums, i, low - 1);
            sort(nums, low + 1, j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
