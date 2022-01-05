//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// Related Topics 位运算 递归 脑筋急转弯 
// 👍 341 👎 0

package leetcode.editor.cn;

//Java：求1+2+…+n
public class P剑指_offer_64Qiu12nLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_64Qiu12nLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumNums(int n) {
            return mul(n, n + 1) >> 1;
        }

        /**
         * 快速乘，只能计算自然数乘法
         */
        private int mul(int x, int y) {
            int ans = 0;
            for (; x > 0; x >>= 1) {
                if ((x & 1) != 0) {
                    ans += y;
                }
                y <<= 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}