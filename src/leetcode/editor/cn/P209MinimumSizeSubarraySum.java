//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 628 👎 0

package leetcode.editor.cn;

//Java：长度最小的子数组
public class P209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();
        // TO TEST
        int[] nums = new int[]{5334, 6299, 4199, 9663, 8945, 3566, 9509, 3124, 6026, 6250, 7475, 5420, 9201, 9501, 38,
                5897, 4411, 6638, 9845, 161, 9563, 8854, 3731, 5564, 5331, 4294, 3275, 1972, 1521, 2377, 3701, 6462,
                6778, 187, 9778, 758, 550, 7510, 6225, 8691, 3666, 4622, 9722, 8011, 7247, 575, 5431, 4777, 4032, 8682,
                5888, 8047, 3562, 9462, 6501, 7855, 505, 4675, 6973, 493, 1374, 3227, 1244, 7364, 2298, 3244, 8627, 5102,
                6375, 8653, 1820, 3857, 7195, 7830, 4461, 7821, 5037, 2918, 4279, 2791, 1500, 9858, 6915, 5156, 970,
                1471, 5296, 1688, 578, 7266, 4182, 1430, 4985, 5730, 7941, 3880, 607, 8776, 1348, 2974, 1094, 6733,
                5177, 4975, 5421, 8190, 8255, 9112, 8651, 2797, 335, 8677, 3754, 893, 1818, 8479, 5875, 1695, 8295,
                7993, 7037, 8546, 7906, 4102, 7279, 1407, 2462, 4425, 2148, 2925, 3903, 5447, 5893, 3534, 3663, 8307,
                8679, 8474, 1202, 3474, 2961, 1149, 7451, 4279, 7875, 5692, 6186, 8109, 7763, 7798, 2250, 2969, 7974,
                9781, 7741, 4914, 5446, 1861, 8914, 2544, 5683, 8952, 6745, 4870, 1848, 7887, 6448, 7873, 128, 3281,
                794, 1965, 7036, 8094, 1211, 9450, 6981, 4244, 2418, 8610, 8681, 2402, 2904, 7712, 3252, 5029, 3004,
                5526, 6965, 8866, 2764, 600, 631, 9075, 2631};
        System.out.println(solution.minSubArrayLen(697439, nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int res = Integer.MAX_VALUE;
            int left = 0, right = 0, sum = 0;
            while (right < n) {
                sum += nums[right];
                while ((sum - nums[left]) >= target) {
                    sum -= nums[left];
                    left++;
                }
                if (sum >= target) {
                    res = Math.min(res, right - left + 1);
                }
                right++;
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
