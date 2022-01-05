//给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个
//比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。 
//
// 示例 2: 
//
// 输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// nums1和nums2中所有元素是唯一的。 
// nums1和nums2 的数组大小都不超过1000。 
// 
// Related Topics 栈 
// 👍 266 👎 0

package leetcode.editor.cn;

//Java：下一个更大元素 I
public class P496NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new P496NextGreaterElementI().new Solution();
        // TO TEST
        int nums1[] = {4, 1, 2}, nums2[] = {1, 3, 4, 2};
        int result[] = solution.nextGreaterElement(nums1, nums2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int result[] = new int[nums1.length];
            if (nums2.length == 0) {
                return result;
            }
            //找到nums2中最大元素，用来确定num2_index的长度
            int max_num2 = nums2[0];
            for (int x : nums2) {
                if (x > max_num2) {
                    max_num2 = x;
                }
            }
            //num2_index记录nums2中每一个元素的索引
            int num2_index[] = new int[max_num2 + 1];
            for (int i = 0; i < nums2.length; i++) {
                num2_index[nums2[i]] = i;
            }
            //对nums1中元素进行遍历
            for (int i = 0; i < nums1.length; i++) {
                result[i] = -1;//预设值-1
                int j = 0;
                //对nums2中元素，从索引num2_index[nums1[i]] + 1开始遍历
                for (j = num2_index[nums1[i]] + 1; j < nums2.length; j++)
                    //找到第一个比nums1[i]大的元素，赋值后跳出循环
                {
                    if (nums2[j] > nums1[i]) {
                        result[i] = nums2[j];
                        break;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}