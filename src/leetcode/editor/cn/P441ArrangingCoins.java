//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。 
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。 
//
// n 是一个非负整数，并且在32位有符号整型的范围内。 
//
// 示例 1: 
//
// 
//n = 5
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤
//
//因为第三行不完整，所以返回2.
// 
//
// 示例 2: 
//
// 
//n = 8
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//因为第四行不完整，所以返回3.
// 
// Related Topics 数学 二分查找 
// 👍 73 👎 0

package leetcode.editor.cn;

//Java：排列硬币
public class P441ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new P441ArrangingCoins().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            int low = 0, high = n;
            long mid = (high + low) / 2;
            while (low <= high) {
                mid = (high + low) / 2;
                if (mid * (mid + 1) / 2 <= n && (mid + 2) * (mid + 1) / 2 > n) {
                    return (int) mid;
                } else if ((mid + 2) * (mid + 1) / 2 <= n) {
                    low = (int) mid + 1;
                } else {
                    high = (int) mid - 1;
                }
            }
            return (int) mid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}