//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 194 👎 0

package leetcode.editor.cn;

//Java：数组中数字出现的次数 II
public class P剑指_Offer_56___IIShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_56___IIShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            // 考虑数字的二进制形式，对于出现三次的数字，各二进制位出现的次数都是3的倍数。
            int[] bitSum = new int[32];
            for (int num : nums) {
                for (int i = 0; i < 32; i++) {
                    bitSum[i] += (num & 1);
                    num >>>= 1;
                }
            }
            int ans = 0;
            //bitSum[i]%3逆序存储了ans的每一位，还原出ans
            for (int i = 31; i >= 0; i--) {
                ans <<= 1;
                ans |= (bitSum[i] % 3);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}