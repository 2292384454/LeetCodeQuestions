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
            Arrays.sort(nums);//先将数组排序
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp;
            int len = nums.length;
            if (len < 3) return result;
            for (int i = 0; i < len - 2; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    for (int j = i + 1, k = len - 1; j < len - 1 && k > j; j++) {
                        if (j == i + 1 || nums[j] != nums[j - 1]) {
                            // 向左移动指针，直到 a+b+c 不大于 0
                            while (nums[i] + nums[j] + nums[k] > 0 && k > j) k--;
                            if (j == k) break;
                            if (nums[i] + nums[j] + nums[k] == 0) {
                                temp = new ArrayList<>();
                                temp.add(nums[i]);
                                temp.add(nums[j]);
                                temp.add(nums[k]);
                                result.add(temp);
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}