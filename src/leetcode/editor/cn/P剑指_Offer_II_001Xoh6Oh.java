package leetcode.editor.cn;
//Java：整数除法

/**
 * <p>给定两个整数 <code>a</code> 和 <code>b</code> ，求它们的除法的商 <code>a/b</code> ，要求不得使用乘号 <code>&#39;*&#39;</code>、除号 <code>&#39;/&#39;</code> 以及求余符号 <code>&#39;%&#39;</code>&nbsp;。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>注意：</strong></p>
 *
 * <ul>
 * <li>整数除法的结果应当截去（<code>truncate</code>）其小数部分，例如：<code>truncate(8.345) = 8</code>&nbsp;以及&nbsp;<code>truncate(-2.7335) = -2</code></li>
 * <li>假设我们的环境只能存储 32 位有符号整数，其数值范围是 <code>[&minus;2<sup>31</sup>,&nbsp;2<sup>31</sup>&minus;1]</code>。本题中，如果除法结果溢出，则返回 <code>2<sup>31&nbsp;</sup>&minus; 1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>a = 15, b = 2
 * <strong>输出：</strong>7
 * <strong><span style="white-space: pre-wrap;">解释：</span></strong>15/2 = truncate(7.5) = 7
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>a = 7, b = -3
 * <strong>输出：</strong><span style="white-space: pre-wrap;">0</span>
 * <strong><span style="white-space: pre-wrap;">解释：</span></strong>7/-3 = truncate(-2.33333..) = -2</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>a = 0, b = 1
 * <strong>输出：</strong><span style="white-space: pre-wrap;">0</span></pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>a = 1, b = 1
 * <strong>输出：</strong><span style="white-space: pre-wrap;">1</span></pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>-2<sup>31</sup>&nbsp;&lt;= a, b &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
 * <li><code>b != 0</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p>注意：本题与主站 29&nbsp;题相同：<a href="https://leetcode-cn.com/problems/add-binary/">https://leetcode-cn.com/problems/divide-two-integers/</a></p>
 *
 * <p>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>数学</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_001Xoh6Oh {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_001Xoh6Oh().new Solution();
        // TO TEST
        System.out.println(solution.divide(48, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int a, int b) {
            int signBit = 0x80000000;
            long ans = 0, x = a, y = b;
            //不直接使用Math.abs()是为了避免除数或被除数为-2^31的情况，此时Math.abs()返回将出错
            x = x < 0 ? -x : x;
            y = y < 0 ? -y : y;
            //示例：48/9=(48-36)/9+4=(48-36-9)/9+1+4=1+4=5
            while (x >= y) {
                long cnt = 1, base = y;
                while (x > (base << 1)) {
                    cnt <<= 1;
                    base <<= 1;
                }
                ans += cnt;
                x -= base;
            }
            ans = (((a ^ b) & signBit) == 0) ? ans : -ans;
            return (int) ((Integer.MAX_VALUE < ans || ans < Integer.MIN_VALUE) ? Integer.MAX_VALUE : ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}