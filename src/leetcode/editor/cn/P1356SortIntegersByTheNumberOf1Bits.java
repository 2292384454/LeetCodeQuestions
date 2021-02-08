//给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。 
//
// 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。 
//
// 请你返回排序后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [0,1,2,3,4,5,6,7,8]
//输出：[0,1,2,4,8,3,5,6,7]
//解释：[0] 是唯一一个有 0 个 1 的数。
//[1,2,4,8] 都有 1 个 1 。
//[3,5,6] 有 2 个 1 。
//[7] 有 3 个 1 。
//按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
// 
//
// 示例 2： 
//
// 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
//输出：[1,2,4,8,16,32,64,128,256,512,1024]
//解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
// 
//
// 示例 3： 
//
// 输入：arr = [10000,10000]
//输出：[10000,10000]
// 
//
// 示例 4： 
//
// 输入：arr = [2,3,5,7,11,13,17,19]
//输出：[2,3,5,17,7,11,13,19]
// 
//
// 示例 5： 
//
// 输入：arr = [10,100,1000,10000]
//输出：[10,100,10000,1000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 500 
// 0 <= arr[i] <= 10^4 
// 
// Related Topics 排序 位运算 
// 👍 98 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：根据数字二进制下 1 的数目排序
public class P1356SortIntegersByTheNumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new P1356SortIntegersByTheNumberOf1Bits().new Solution();
        // TO TEST
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solution.sortByBits(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortByBits(int[] arr) {
            Integer[] arrInteger = new Integer[arr.length];
            for (int i = 0; i < arr.length; i++)
                arrInteger[i] = arr[i];
            Arrays.sort(arrInteger, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int subOfOne = countOfOne(o1) - countOfOne(o2);
                    if (subOfOne != 0)
                        return subOfOne;
                    else
                        return o1 - o2;
                }
            });
            int[] result = new int[arr.length];
            for (int i = 0; i < arr.length; i++)
                result[i] = arrInteger[i];
            return result;
        }

        public int countOfOne(int n) {
            int count = 0;
            while (n > 0) {
                n &= (n - 1);
                count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
