//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 224 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

//Java：两个数组的交集
public class P349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>(), result = new HashSet<>();
            for (int x : nums1) {
                set1.add(x);
            }
            for (int x : nums2) {
                if (set1.contains(x)) {
                    result.add(x);
                }
            }
            int len = result.size();
            if (len == 0) {
                return new int[0];
            }
            Integer res[] = result.toArray(new Integer[len]);
            return Arrays.stream(res).mapToInt(Integer::valueOf).toArray();//Integer[]转int[]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}