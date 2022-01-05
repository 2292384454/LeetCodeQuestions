//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

package leetcode.editor.cn;

//Java：爬楼梯
public class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        这个问题其实就是斐波那契数列问题。
        设n=i时候结果为a[i]，则a[1]=1,a[2]=2,...a[i]=a[i-2]+a[i-1]...
        理论上用循环和递归都可以做，递归时间复杂度会超，所以这里用循环做的
        */
        public int climbStairs(int n) {
            int a_i_2 = 1, a_i_1 = 2, a_i = a_i_2 + a_i_1;
            if (n == 1) {
                return a_i_2;
            }
            if (n == 2) {
                return a_i_1;
            }
            for (int i = 3; i <= n; i++) {
                a_i = a_i_2 + a_i_1;
                a_i_2 = a_i_1;
                a_i_1 = a_i;
            }
            return a_i_1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}