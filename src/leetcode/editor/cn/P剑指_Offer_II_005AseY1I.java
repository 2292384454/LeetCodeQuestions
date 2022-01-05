package leetcode.editor.cn;
//Java：单词长度的最大乘积

/**
 * <p>给定一个字符串数组&nbsp;<code>words</code>，请计算当两个字符串 <code>words[i]</code> 和 <code>words[j]</code> 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> words = <code>[&quot;abcw&quot;,&quot;baz&quot;,&quot;foo&quot;,&quot;bar&quot;,&quot;fxyz&quot;,&quot;abcdef&quot;]</code>
 * <strong>输出: </strong><code>16
 * <strong>解释:</strong> 这两个单词为<strong> </strong></code><code>&quot;abcw&quot;, &quot;fxyz&quot;</code>。它们不包含相同字符，且长度的乘积最大。</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> words = <code>[&quot;a&quot;,&quot;ab&quot;,&quot;abc&quot;,&quot;d&quot;,&quot;cd&quot;,&quot;bcd&quot;,&quot;abcd&quot;]</code>
 * <strong>输出: </strong><code>4
 * <strong>解释: </strong></code>这两个单词为 <code>&quot;ab&quot;, &quot;cd&quot;</code>。</pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> words = <code>[&quot;a&quot;,&quot;aa&quot;,&quot;aaa&quot;,&quot;aaaa&quot;]</code>
 * <strong>输出: </strong><code>0
 * <strong>解释: </strong>不存在这样的两个单词。</code>
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= words.length &lt;= 1000</code></li>
 * <li><code>1 &lt;= words[i].length &lt;= 1000</code></li>
 * <li><code>words[i]</code>&nbsp;仅包含小写字母</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 318&nbsp;题相同：<a href="https://leetcode-cn.com/problems/maximum-product-of-word-lengths/">https://leetcode-cn.com/problems/maximum-product-of-word-lengths/</a></p>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>字符串</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_005AseY1I {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_005AseY1I().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            int n = words.length;
            int[] hashes = new int[n];
            for (int i = 0; i < n; i++) {
                hashes[i] = hash(words[i]);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((hashes[i] & hashes[j]) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }

        /**
         * 用 int 的低 26 位记录 a-z 是否在 s 中出现过
         */
        private int hash(String s) {
            int h = 0;
            for (int i = 0; i < s.length(); i++) {
                h |= (1 << (s.charAt(i) - 'a'));
            }
            return h;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}