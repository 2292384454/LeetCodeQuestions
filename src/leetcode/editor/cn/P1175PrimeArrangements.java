//请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。 
//
// 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。 
//
// 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：12
//解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
// 
//
// 示例 2： 
//
// 输入：n = 100
//输出：682289015
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
// Related Topics 数学 
// 👍 25 👎 0

package leetcode.editor.cn;

//Java：质数排列
public class P1175PrimeArrangements {
    public static void main(String[] args) {
        Solution solution = new P1175PrimeArrangements().new Solution();
        // TO TEST
        System.out.println(solution.numPrimeArrangements(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numPrimeArrangements(int n) {
            long N = (long) 1e9 + 7, result = 0;
            //因为countPrimes统计的是小于n的质数的数量，这里需要的是不大于n的质数的数量，所以countPrimes()中传入的参数是n+1
            int countOfPrimes = countPrimes(n + 1), countOfComposite = n - countOfPrimes;
            long A1 = 1, A2 = 1;
            //(a*b)%c=((a%c)*(b%c))%c
            for (int i = 1; i <= countOfPrimes; i++)
                A1 = (A1 % N) * i;
            for (int i = 1; i <= countOfComposite; i++)
                A2 = (A2 % N) * i;
            result = ((A1 % N) * (A2 % N)) % N;
            return (int) result;
        }

        //统计所有小于非负整数 n 的质数的数量。
        public int countPrimes(int n) {
            int result = 0, sqrt_n = (int) Math.sqrt(n);
            boolean[] b = new boolean[n];   // 初始化默认值都为 false，为质数标记
            if (2 < n) result++; // 如果大于 2 则一定拥有 2 这个质数
            for (int i = 3; i < n; i += 2) {  // 从 3 开始遍历，且只遍历奇数
                if (!b[i]) {  // 是质数
                    if (i <= sqrt_n)//不大于根号n
                        for (int j = i; i * j < n; j += 2)
                            b[i * j] = true;    // 将当前质数的奇数倍都设置成非质数标记 true
                    result++;   // 质数个数 +1
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
