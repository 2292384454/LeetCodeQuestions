package leetcode.editor.cn;
//Java：整数替换

/**
 * <p>给定一个正整数 <code>n</code> ，你可以做如下操作：</p>
 *
 * <ol>
 * <li>如果 <code>n</code><em> </em>是偶数，则用 <code>n / 2</code>替换 <code>n</code><em> </em>。</li>
 * <li>如果 <code>n</code><em> </em>是奇数，则可以用 <code>n + 1</code>或<code>n - 1</code>替换 <code>n</code> 。</li>
 * </ol>
 *
 * <p><code>n</code><em> </em>变为 <code>1</code> 所需的最小替换次数是多少？</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 8
 * <strong>输出：</strong>3
 * <strong>解释：</strong>8 -> 4 -> 2 -> 1
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 7
 * <strong>输出：</strong>4
 * <strong>解释：</strong>7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 4
 * <strong>输出：</strong>2
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= n <= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>记忆化搜索</li><li>动态规划</li></div></div><p><div><li>👍 96</li><li>👎 0</li></div>
 */
public class P397IntegerReplacement {
    public static void main(String[] args) {
        Solution solution = new P397IntegerReplacement().new Solution();
        // TO TEST
        System.out.println(solution.integerReplacement(65535));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerReplacement(int n) {
            if (n == Integer.MAX_VALUE) {
                return 32;
            }
            int count = 0;
            while (n != 1) {
                // 偶数(0bXX0)直接右移
                if ((n & 1) == 0) {
                    n >>= 1;
                } else {
                    // 大于1的奇数格式为XX01或者XX11，对于前一种格式直接 -1，对于后一种格式直接 +1
                    // 单且仅当只有两位时候0b01(十进制的1) 和0b11（十进制的3）时候，对于3，最少的步数应该是 -1，因为3 - 1 = 2 / 2 = 1（三步）                #如果 + 1
                    // 的话是3 + 1 = 4 / 2 = 2 / 2 = 1（四步），造成3这个数字比较特殊的原因是因为3的二进制只有2bit(0b11)
                    n += ((n & 2) == 0 || n == 3) ? -1 : 1;
                }
                count += 1;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}