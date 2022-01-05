//如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。 
//
// 例如，以下数列为等差数列: 
//
// 
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9 
//
// 以下数列不是等差数列。 
//
// 
//1, 1, 2, 5, 7 
//
// 
//
// 数组 A 包含 N 个数，且索引从 0 开始。该数组子序列将划分为整数序列 (P0, P1, ..., Pk)，满足 0 ≤ P0 < P1 < ... 
//< Pk < N。 
//
// 
//
// 如果序列 A[P0]，A[P1]，...，A[Pk-1]，A[Pk] 是等差的，那么数组 A 的子序列 (P0，P1，…，PK) 称为等差序列。值得注意的
//是，这意味着 k ≥ 2。 
//
// 函数要返回数组 A 中所有等差子序列的个数。 
//
// 输入包含 N 个整数。每个整数都在 -231 和 231-1 之间，另外 0 ≤ N ≤ 1000。保证输出小于 231-1。 
//
// 
//
// 示例： 
//
// 
//输入：[2, 4, 6, 8, 10]
//
//输出：7
//
//解释：
//所有的等差子序列为：
//[2,4,6]
//[4,6,8]
//[6,8,10]
//[2,4,6,8]
//[4,6,8,10]
//[2,4,6,8,10]
//[2,6,10]
// 
//
// 
// Related Topics 动态规划 
// 👍 111 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Java：等差数列划分 II - 子序列
public class P446ArithmeticSlicesIiSubsequence {
    public static void main(String[] args) {
        Solution solution = new P446ArithmeticSlicesIiSubsequence().new Solution();
        // TO TEST
        int[] nums = new int[]{2, 4, 4, 6, 8, 10};
//        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        int[] nums = new int[]{
//                79, 20, 64, 28, 67, 81, 60, 58, 97, 85, 92, 96, 82, 89, 46,
//                50, 15, 2, 36, 44, 54, 2, 90, 37, 7, 79, 26, 40, 34, 67, 64,
//                28, 60, 89, 46, 31, 9, 95, 43, 19, 47, 64, 48, 95, 80, 31, 47,
//                19, 72, 99, 28, 46, 13, 9, 64, 4, 68, 74, 50, 28, 69, 94, 93,
//                3, 80, 78, 23, 80, 43, 49, 77, 18, 68, 28, 13, 61, 34, 44, 80,
//                70, 55, 85, 0, 37, 93, 40, 47, 47, 45, 23, 26, 74, 45, 67, 34,
//                20, 33, 71, 48, 96};
        System.out.println(solution.numberOfArithmeticSlices(nums));
//        Arrays.sort(nums);
//        for (int num : nums) System.out.print(num + " ");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int ans = 0;
            int n = nums.length;
            // dp[i] 表示以 nums[i] 为尾项，公差为 d 的等差子序列的个数。
            Map<Long, Integer>[] dp = new Map[n];
            for (int i = 0; i < n; ++i) {
                dp[i] = new HashMap<>();
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    long d = (long) nums[i] - nums[j];
                    int cnt = dp[j].getOrDefault(d, 0);
                    ans += cnt;
                    dp[i].put(d, dp[i].getOrDefault(d, 0) + cnt + 1);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
