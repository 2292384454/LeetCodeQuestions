//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 133 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

//Java：调整数组顺序使奇数位于偶数前面
public class P剑指_offer_21DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_21DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        // TO TEST
        int[] nums = new int[20];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(solution.exchange(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            // 双指针法，时间复杂度O(n)，空间复杂度O(1)
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left < right) {
                if ((nums[left] & 1) == 0) {
                    // 如果left遍历到偶数，right向左移动直到遇到第一个奇数，然后交换left和right指向的数字
                    while (right > left && (nums[right] & 1) == 0) {
                        right--;
                    }
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}