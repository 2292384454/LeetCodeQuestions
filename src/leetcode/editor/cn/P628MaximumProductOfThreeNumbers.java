//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: 6
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: 24
// 
//
// 注意: 
//
// 
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。 
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 
// 
// Related Topics 数组 数学 
// 👍 177 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：三个数的最大乘积
public class P628MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new P628MaximumProductOfThreeNumbers().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumProduct(int[] nums) {
            int len = nums.length;
            Arrays.sort(nums);
            if (nums[0] >= 0) {
                return nums[len - 1] * nums[len - 2] * nums[len - 3];
            } else {
                return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}