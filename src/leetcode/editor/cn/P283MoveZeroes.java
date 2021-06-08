//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 704 👎 0

package leetcode.editor.cn;

//Java：移动零
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
        int nums[] = {0, 1, 0, 3, 12, 41, 25, 3, 1, 5, 0, 1, 4, 0, 2, 5, 3, 0, 1, 0, 0, 2, 0, 4, 0, 0};
        solution.moveZeroes(nums);
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums.length == 0) {
                return;
            }
            int i = 0, j = 0;
            while (true) {
                while (i < nums.length && nums[i] != 0) {
                    i++;//找到第一个零的位置
                }
                j = i + 1;
                while (j < nums.length && nums[j] == 0) {
                    j++;//找到i之后的第一个非零元素的位置
                }
                if (i >= nums.length || j >= nums.length) {
                    break;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}