//给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j
// 都是数组中的数字，且两数之差的绝对值是 k. 
//
// 示例 1: 
//
// 
//输入: [3, 1, 4, 1, 5], k = 2
//输出: 2
//解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
//尽管数组中有两个1，但我们只应返回不同的数对的数量。
// 
//
// 示例 2: 
//
// 
//输入:[1, 2, 3, 4, 5], k = 1
//输出: 4
//解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
// 
//
// 示例 3: 
//
// 
//输入: [1, 3, 1, 5, 4], k = 0
//输出: 1
//解释: 数组中只有一个 0-diff 数对，(1, 1)。
// 
//
// 注意: 
//
// 
// 数对 (i, j) 和数对 (j, i) 被算作同一数对。 
// 数组的长度不超过10,000。 
// 所有输入的整数的范围在 [-1e7, 1e7]。 
// 
// Related Topics 数组 双指针 
// 👍 96 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：数组中的K-diff数对
public class P532KDiffPairsInAnArray {
    public static void main(String[] args) {
        Solution solution = new P532KDiffPairsInAnArray().new Solution();
        // TO TEST
        int nums[] = {1, 3, 1, 5, 4};
        System.out.println(solution.findPairs(nums, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPairs(int[] nums, int k) {
            Arrays.sort(nums);//先对数组进行排序
            int count = 0;
            //lastLeft和lastRight用来排除重复数对多次计数
            for (int left = 0, right = 1, lastLeft = 0, lastRight = 1; left < nums.length & right < nums.length; ) {
                //保证left指针指向的元素不会在指针移动了的情况下连续取到重复的值
                while (left - 1 >= 0 && left != lastLeft && left < nums.length && nums[left] == nums[lastLeft]) {
                    left++;
                }
                //保证left始终在right的左边
                while (right <= left) {
                    right++;
                }
                //保证right指针指向的元素不会在指针移动了的情况下连续取到重复的值
                while (right - 1 >= 1 && right != lastRight && right < nums.length && nums[right] == nums[lastRight]) {
                    right++;
                }
                //记录下left和right指针的位置
                lastLeft = left;
                lastRight = right;
                //防止溢出
                if (left >= nums.length || right >= nums.length) {
                    break;
                }
                //计数
                if (nums[right] - nums[left] == k) {
                    count++;
                    left++;
                    right++;
                } else if (nums[right] - nums[left] < k) {
                    right++;//如果这个差小于k那么说明要右移right的指针增大减数
                } else {
                    left++;//如果这个差大于k那么说明要右移left的指针增大被减数
                }
                //保证left始终在right的左边
                while (right <= left) {
                    right++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}