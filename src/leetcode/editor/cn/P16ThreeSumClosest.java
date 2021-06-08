//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 689 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        // TO TEST
        int[] arr = new int[]{1,1,-1,-1,3};
        System.out.println(solution.threeSumClosest(arr, -1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);//先将数组排序
            int ans = Integer.MAX_VALUE;
            int len = nums.length;
            if (len < 3) {
                return ans;
            }
            for (int i = 0; i < len - 2; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    for (int j = i + 1, k = len - 1; j < len - 1 && k > j; j++) {
                        if (j == i + 1 || nums[j] != nums[j - 1]) {
                            // 向左移动指针，直到 a+b+c 不大于 target
                            while (nums[i] + nums[j] + nums[k] > target && k > j) {
                                k--;
                            }
                            if (k + 1 < len) {
                                if (nums[i] + nums[j] + nums[k + 1] - target < Math.abs(ans - target)) {
                                    ans = nums[i] + nums[j] + nums[k + 1];
                                }
                            }
                            if (j == k) {
                                break;
                            }
                            if (target - nums[i] - nums[j] - nums[k] < Math.abs(ans - target)) {
                                ans = nums[i] + nums[j] + nums[k];
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
