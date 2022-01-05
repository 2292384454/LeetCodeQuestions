//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 238 👎 0

package leetcode.editor.cn;

//Java：把数字翻译成字符串
public class P剑指_offer_46BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_46BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
         * 回溯法
         */
        // int ans=0;
        //
        // public int translateNum(int num) {
        //     helper(num, "");
        //     return ans;
        // }
        //
        // private void helper(int num, String str) {
        //     if (num == 0) {
        //         ans++;
        //     } else {
        //         char c = (char) ('a' + num % 10);
        //         helper(num / 10, str + c);
        //         if (num % 100 > 9 && num % 100 < 26) {
        //             c = (char) ('a' + num % 100);
        //             helper(num / 100, str + c);
        //         }
        //     }

        /*
         * 动态规划
         */
        public int translateNum(int num) {
            int ans = 1, pre = 1, x, y = num % 10;
            while (num != 0) {
                num /= 10;
                x = num % 10;
                int tmp = 10 * x + y;
                // temp 在 0~25 范围时 x 和 y 可以不合并也可以合并，不合并提供 ans 种情况，合并提供 pre 种情况
                int c = (tmp >= 10 && tmp <= 25) ? ans + pre : ans;
                pre = ans;
                ans = c;
                y = x;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}