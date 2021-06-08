//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 153 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：数组的相对排序
public class P1122RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new P1122RelativeSortArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int defult = 99999;//num_indexInArr2初值全部赋为一个超出数组长度的极大值
            int[] num_indexInArr2 = new int[1001];//num_indexInArr2记录arr2中每个数字的索引
            Arrays.fill(num_indexInArr2, defult);
            for (int i = 0; i < arr2.length; i++) {
                num_indexInArr2[arr2[i]] = i;
            }
            Integer[] arr1Integer = new Integer[arr1.length];//将arr1先转换成Integer类型数组，便于后续重载compare函数
            for (int i = 0; i < arr1.length; i++) {
                arr1Integer[i] = arr1[i];
            }
            int[] result = new int[arr1.length];//result需要为int类型数组
            Arrays.sort(arr1Integer, new Comparator<Integer>() {//用重载的compare函数进行比较
                @Override
                public int compare(Integer o1, Integer o2) {
                    //如果arr2中有o1或者o2，那么返回num_indexInArr2中存储的索引相对顺序即可，不存在的一方因为默认索引为极大值，所以会被自动丢到数组尾部
                    //如果arr2中没有o1也没有o2，那么返回o1和o2的比较结果
                    if (num_indexInArr2[o1] != defult || num_indexInArr2[o2] != defult) {
                        return num_indexInArr2[o1] - num_indexInArr2[o2];
                    } else {
                        return o1 - o2;
                    }
                }
            });
            //将Integer类型数组转成int型数组返回
            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1Integer[i];
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
