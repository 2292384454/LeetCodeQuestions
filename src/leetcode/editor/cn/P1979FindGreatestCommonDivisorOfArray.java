package leetcode.editor.cn;

import java.util.Arrays;

public class P1979FindGreatestCommonDivisorOfArray {
    public static void main(String[] args) {
        Solution solution = new P1979FindGreatestCommonDivisorOfArray().new Solution();
        // TO TEST
    }

    //Java：找出数组的最大公约数
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findGCD(int[] nums) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int num : nums) {
                max = Math.max(num, max);
                min = Math.min(num, min);
            }
            return gcd(max, min);
        }

        public int gcd(int x, int y) {
            if (y == 0) {
                return x;
            }
            return gcd(y, x % y);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}