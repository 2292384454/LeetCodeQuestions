package leetcode.editor.cn;
//Java：超级次方

/**
 * <p>你的任务是计算 <code>a<sup>b</sup></code> 对 <code>1337</code> 取模，<code>a</code> 是一个正整数，<code>b</code> 是一个非常大的正整数且会以数组形式给出。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>a = 2, b = [3]
 * <strong>输出：</strong>8
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>a = 2, b = [1,0]
 * <strong>输出：</strong>1024
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>a = 1, b = [4,3,3,8,5,2]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>a = 2147483647, b = [2,0,0]
 * <strong>输出：</strong>1198
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= a <= 2<sup>31</sup> - 1</code></li>
 * <li><code>1 <= b.length <= 2000</code></li>
 * <li><code>0 <= b[i] <= 9</code></li>
 * <li><code>b</code> 不含前导 0</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>分治</li></div></div><p><div><li>👍 118</li><li>👎 0</li></div>
 */
public class P372SuperPow {
    public static void main(String[] args) {
        Solution solution = new P372SuperPow().new Solution();
        // TO TEST
        int[] b = new int[]{2, 0, 0};
        System.out.println(solution.superPow(2147483647, b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int superPow(int a, int[] b) {
            return quickPow1(a, b, 1337);
        }

        // 基于十进制运算的快速幂
        private int quickPow1(int a, int[] b, int mod) {
            // 例子：a^135 = a^100 · a^30 · a^5
            int ans = 1;
            for (int i = b.length - 1; i >= 0; i--) {
                ans = (ans * quickPow(a % mod, b[i], mod)) % mod;
                a = quickPow(a % mod, 10, mod);
            }
            return ans;
        }

        // 基于二进制运算的快速幂
        private int quickPow(int a, int b, int mod) {
            int ans = 1;
            while (b != 0) {
                if ((b & 1) != 0) {
                    ans = (ans * a) % mod;
                }
                a = (a * a) % mod;
                b >>= 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}