//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 128 👎 0

package leetcode.editor.cn;

//Java：打印从1到最大的n位数
public class P剑指_offer_17DaYinCong1daoZuiDaDeNweiShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_17DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int len = (int) (Math.pow(10, n) - 1);
            int[] ans = new int[len];
            for (int i = 0; i < len; i++) {
                ans[i] = i + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}