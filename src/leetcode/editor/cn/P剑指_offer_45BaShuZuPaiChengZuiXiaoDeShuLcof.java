//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 234 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：把数组排成最小的数
public class P剑指_offer_45BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_45BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        // TO TEST
        int[] nums = new int[]{1, 0};
        System.out.println(solution.minNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            int len = nums.length;
            Integer[] integers = new Integer[len];
            for (int i = 0; i < nums.length; i++) {
                integers[i] = nums[i];
            }
            Arrays.sort(integers, (o1, o2) -> {
                if (o1 == 0 || o2 == 0) {
                    return Integer.compare(o1, o2);
                }
                long base1 = 1, base2 = 1;
                for (int i = o2; i > 0; i /= 10) {
                    base1 *= 10;
                }
                for (int i = o1; i > 0; i /= 10) {
                    base2 *= 10;
                }
                return Long.compare(o1 * base1 + o2, o2 * base2 + o1);
            });
            StringBuilder ans = new StringBuilder();
            for (Integer integer : integers) {
                ans.append(integer);
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}