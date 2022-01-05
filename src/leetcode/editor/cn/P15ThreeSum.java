//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2434 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            if (n < 3) {
                return ans;
            }
            for (int i = 0; i < n - 2; i++) {
                // 对 i 去重
                if (i == 0 || nums[i] != nums[i - 1]) {
                    for (int j = i + 1, k = n - 1; j < n - 1 && k > j; j++) {
                        // 对 j 去重
                        if (j == i + 1 || nums[j] != nums[j - 1]) {
                            // 向左移动 k 指针，直到 a+b+c 不大于 0
                            while (nums[i] + nums[j] + nums[k] > 0 && k > j) {
                                k--;
                            }
                            if (j == k) {
                                break;
                            }
                            if (nums[i] + nums[j] + nums[k] == 0) {
                                ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
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