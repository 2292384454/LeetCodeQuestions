//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 104 
// 0 <= t <= 231 - 1 
// 
// Related Topics 排序 Ordered Map 
// 👍 463 👎 0

package leetcode.editor.cn;

import java.util.TreeSet;

//Java：存在重复元素 III
public class P220ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new P220ContainsDuplicateIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            // 因为nums[i]的范围是整个整数范围，所以加减运算可能超出Integer范围，要用Long比较
            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                // ceiling为大于等于 nums[i]-t 的第一个数，如果不存在就为null
                Long ceiling = set.ceiling((long) nums[i] - (long) t);
                if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                    return true;
                }
                set.add((long) nums[i]);
                // 维护滑动窗口，移除左边到当前位置距离为 k 的元素
                if (i >= k) {
                    set.remove((long) nums[i - k]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
