//给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。 
//
// 序号代表了一个元素有多大。序号编号的规则如下： 
//
// 
// 序号从 1 开始编号。 
// 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。 
// 每个数字的序号都应该尽可能地小。 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [40,10,20,30]
//输出：[4,1,2,3]
//解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。 
//
// 示例 2： 
//
// 输入：arr = [100,100,100]
//输出：[1,1,1]
//解释：所有元素有相同的序号。
// 
//
// 示例 3： 
//
// 输入：arr = [37,12,28,9,100,56,80,5,12]
//输出：[5,3,4,2,8,6,7,1,3]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 105 
// -109 <= arr[i] <= 109 
// 
// Related Topics 数组 
// 👍 46 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

//Java：数组序号转换
public class P1331RankTransformOfAnArray {
    public static void main(String[] args) {
        Solution solution = new P1331RankTransformOfAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            int[] result = new int[arr.length];
            int[] cp = Arrays.copyOf(arr, arr.length);
            Arrays.sort(cp);
            HashMap<Integer, Integer> num_sortedindex = new HashMap<>();
            for (int i = 0, index = 1; i < arr.length; index++) {
                num_sortedindex.put(cp[i], index);
                while (i + 1 < arr.length && cp[i] == cp[i + 1])
                    i++;
                i++;
            }
            for (int i = 0; i < arr.length; i++) {
                result[i] = num_sortedindex.get(arr[i]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
