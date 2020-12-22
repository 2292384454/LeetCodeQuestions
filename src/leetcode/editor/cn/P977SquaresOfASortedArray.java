//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 182 👎 0

package leetcode.editor.cn;

//Java：有序数组的平方
public class P977SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new P977SquaresOfASortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] result = new int[nums.length];
            int k = nums.length - 1;
            for (int i = 0, j = nums.length - 1; i <= j; ) {
                int a = nums[i] * nums[i], b = nums[j] * nums[j];
                if (a < b) {
                    result[k--] = b;
                    j--;
                } else {
                    result[k--] = a;
                    i++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
