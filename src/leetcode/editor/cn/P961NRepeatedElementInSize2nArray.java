//在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。 
//
// 返回重复了 N 次的那个元素。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[1,2,3,3]
//输出：3
// 
//
// 示例 2： 
//
// 输入：[2,1,2,5,3,2]
//输出：2
// 
//
// 示例 3： 
//
// 输入：[5,1,5,2,5,3,5,4]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 4 <= A.length <= 10000 
// 0 <= A[i] < 10000 
// A.length 为偶数 
// 
// Related Topics 哈希表 
// 👍 86 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：重复 N 次的元素
public class P961NRepeatedElementInSize2nArray {
    public static void main(String[] args) {
        Solution solution = new P961NRepeatedElementInSize2nArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int repeatedNTimes(int[] A) {
            Arrays.sort(A);
            int len = A.length;
            if (A[0] == A[len / 2 - 1]) {
                return A[0];
            } else {
                return A[len / 2];
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
