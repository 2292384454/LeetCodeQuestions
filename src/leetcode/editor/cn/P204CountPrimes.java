//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学 
// 👍 416 👎 0

package leetcode.editor.cn;

//Java：计数质数
public class P204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new P204CountPrimes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            int result = 0, sqrt_n = (int) Math.sqrt(n);
            boolean[] b = new boolean[n];   // 初始化默认值都为 false，为质数标记
            if (2 < n) {
                result++; // 如果大于 2 则一定拥有 2 这个质数
            }
            for (int i = 3; i < n; i += 2) {  // 从 3 开始遍历，且只遍历奇数
                if (!b[i]) {  // 是质数
                    if (i <= sqrt_n)//不大于根号n
                    {
                        for (int j = i; i * j < n; j += 2) {
                            b[i * j] = true;    // 将当前质数的奇数倍都设置成非质数标记 true
                        }
                    }
                    result++;   // 质数个数 +1
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}