//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 168 👎 0

package leetcode.editor.cn;

//Java：青蛙跳台阶问题
public class P剑指_offer_10___i_iQingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_10___i_iQingWaTiaoTaiJieWenTiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n) {
            long[] nums = new long[3];
            nums[0] = 1;
            nums[1] = 1;
            if (n < 2) {
                return (int) nums[n];
            }
            for (int i = 2; i <= n; i++) {
                nums[2] = (nums[0] + nums[1]) % 1000000007L;
                nums[0] = nums[1];
                nums[1] = nums[2];
            }
            return (int) (nums[2] % 1000000007L);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}