//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 位运算 数组 哈希表 数学 二分查找 
// 👍 151 👎 0

package leetcode.editor.cn;

//Java：0～n-1中缺失的数字
public class P剑指_Offer_53___IIQueShiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_53___IIQueShiDeShuZiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            // 如果缺失数字为 x ，那么：
            // [0,x)范围内 nums[i]==i
            // [x,n-1)范围内 nums[i]>i
            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] == mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}