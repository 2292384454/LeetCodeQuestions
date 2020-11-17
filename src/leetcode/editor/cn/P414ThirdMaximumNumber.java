//给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。 
//
// 示例 1: 
//
// 
//输入: [3, 2, 1]
//
//输出: 1
//
//解释: 第三大的数是 1.
// 
//
// 示例 2: 
//
// 
//输入: [1, 2]
//
//输出: 2
//
//解释: 第三大的数不存在, 所以返回最大的数 2 .
// 
//
// 示例 3: 
//
// 
//输入: [2, 2, 3, 1]
//
//输出: 1
//
//解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
//存在两个值为2的数，它们都排第二。
// 
// Related Topics 数组 
// 👍 160 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//Java：第三大的数
public class P414ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new P414ThirdMaximumNumber().new Solution();
        // TO TEST
        int nums[] = {3, 2, 1};
        System.out.println(solution.thirdMax(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;//用long类型是为了避开int范围内所有数字
            for (int x : nums) {
                if (x > first) {
                    third = second;
                    second = first;
                    first = x;
                } else if (x < first && x > second) {
                    third = second;
                    second = x;
                } else if (x < second && x > third) {
                    third = x;
                }
            }
            return third != Long.MIN_VALUE ? (int) third : (int) first;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}