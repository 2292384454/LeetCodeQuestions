//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 
// 👍 140 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：扑克牌中的顺子
public class P剑指_offer_61BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_61BuKePaiZhongDeShunZiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            // 先跳过所有大小王（其实最多也就两张）
            int count = 0;
            while (nums[count] == 0) {
                count++;
            }
            for (int i = count + 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    return false;
                }
                // 中间差的牌用大小王顶上
                count -= (nums[i] - nums[i - 1] - 1);
                if (count < 0) {
                    // 如果大小王不够，说明不能成顺子
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}