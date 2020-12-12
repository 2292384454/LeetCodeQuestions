//给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。 
//
// 返回数组 B 的最大值和最小值之间可能存在的最小差值。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1], K = 0
//输出：0
//解释：B = [1]
// 
//
// 示例 2： 
//
// 输入：A = [0,10], K = 2
//输出：6
//解释：B = [2,8]
// 
//
// 示例 3： 
//
// 输入：A = [1,3,6], K = 3
//输出：0
//解释：B = [3,3,3] 或 B = [4,4,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 0 <= K <= 10000 
// 
// Related Topics 数学 
// 👍 59 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：最小差值 I
public class P908SmallestRangeI {
    public static void main(String[] args) {
        Solution solution = new P908SmallestRangeI().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestRangeI(int[] A, int K) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;//找到A中最大元素和最小元素
            int[] B = new int[A.length];
            for (int a : A) {
                if (a < min)
                    min = a;
                if (a > max)
                    max = a;
            }
            int average = (min + max) / 2;//计算A中最大元素与最小元素之差，B中所有数字尽可能往这个平均值上靠
            for (int i = 0; i < A.length; i++) {
                if (A[i] < average)
                    B[i] = Math.min(A[i] + K, average);
                else
                    B[i] = Math.max(A[i] - K, average);
            }
            max = Integer.MIN_VALUE;//找到B中最大元素与最小元素
            min = Integer.MAX_VALUE;
            for (int b : B) {
                if (b < min)
                    min = b;
                if (b > max)
                    max = b;
            }
            return max - min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}