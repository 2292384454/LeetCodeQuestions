//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 745 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：四数之和
public class P18FourSum {
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);//先将数组排序
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 3; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    int[] tempArr = Arrays.copyOfRange(nums, i + 1, nums.length);
                    List<List<Integer>> pre = threeSum(tempArr, target - nums[i]);
                    if (!pre.isEmpty()) {
                        for (List<Integer> list : pre) {
                            list.add(nums[i]);
                            result.add(list);
                        }
                    }
                }
            }
            return result;
        }

        public List<List<Integer>> threeSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp;
            int len = nums.length;
            if (len < 3) return result;
            for (int i = 0; i < len - 2; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    for (int j = i + 1, k = len - 1; j < len - 1 && k > j; j++) {
                        if (j == i + 1 || nums[j] != nums[j - 1]) {
                            // 向左移动指针，直到 a+b+c 不大于 target
                            while (nums[i] + nums[j] + nums[k] > target && k > j) k--;
                            if (j == k) break;
                            if (nums[i] + nums[j] + nums[k] == target) {
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
