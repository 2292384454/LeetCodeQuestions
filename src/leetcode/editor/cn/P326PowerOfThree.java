//给定一个整数，写一个函数来判断它是否是 3 的幂次方。 
//
// 示例 1: 
//
// 输入: 27
//输出: true
// 
//
// 示例 2: 
//
// 输入: 0
//输出: false 
//
// 示例 3: 
//
// 输入: 9
//输出: true 
//
// 示例 4: 
//
// 输入: 45
//输出: false 
//
// 进阶： 
//你能不使用循环或者递归来完成本题吗？ 
// Related Topics 数学 
// 👍 124 👎 0

package leetcode.editor.cn;

import java.util.HashSet;

//Java：3的幂
public class P326PowerOfThree {
    public static void main(String[] args) {
        Solution solution = new P326PowerOfThree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //static HashSet<Integer> nums = new HashSet<Integer>() {{
        HashSet<Integer> nums = new HashSet<Integer>() {{
            add(1);
            add(3);
            add(9);
            add(27);
            add(81);
            add(243);
            add(729);
            add(2187);
            add(6561);
            add(19683);
            add(59049);
            add(177147);
            add(531441);
            add(1594323);
            add(4782969);
            add(14348907);
            add(43046721);
            add(129140163);
            add(387420489);
            add(1162261467);
        }};

        public boolean isPowerOfThree(int n) {
            if (nums.contains(n)) {
                return true;
            } else {
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}