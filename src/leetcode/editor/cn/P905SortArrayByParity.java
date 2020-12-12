//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。 
//
// 你可以返回满足此条件的任何数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 5000 
// 0 <= A[i] <= 5000 
// 
// Related Topics 数组 
// 👍 180 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

//Java：按奇偶排序数组
public class P905SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new P905SortArrayByParity().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            LinkedList<Integer> even = new LinkedList<>(), odd = new LinkedList<>();
            for (int a : A) {
                if (a % 2 == 0)
                    even.add(a);
                else
                    odd.add(a);
            }
            even.addAll(odd);
            Integer[] result = even.toArray(new Integer[0]);
            return Arrays.stream(result).mapToInt(Integer::valueOf).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}