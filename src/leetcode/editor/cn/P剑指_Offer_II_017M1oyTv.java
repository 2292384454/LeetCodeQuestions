package leetcode.editor.cn;
//Java：含有所有字符的最短字符串

/**
 * <p>给定两个字符串 <code>s</code> 和&nbsp;<code>t</code> 。返回 <code>s</code> 中包含&nbsp;<code>t</code>&nbsp;的所有字符的最短子字符串。如果 <code>s</code> 中不存在符合条件的子字符串，则返回空字符串 <code>&quot;&quot;</code> 。</p>
 *
 * <p>如果 <code>s</code> 中存在多个符合条件的子字符串，返回任意一个。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>注意： </strong>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = &quot;ADOBECODEBANC&quot;, t = &quot;ABC&quot;
 * <strong>输出：</strong>&quot;BANC&quot;
 * <strong>解释：</strong>最短子字符串 &quot;BANC&quot; 包含了字符串 t 的所有字符 &#39;A&#39;、&#39;B&#39;、&#39;C&#39;</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = &quot;a&quot;, t = &quot;a&quot;
 * <strong>输出：</strong>&quot;a&quot;
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = &quot;a&quot;, t = &quot;aa&quot;
 * <strong>输出：</strong>&quot;&quot;
 * <strong>解释：</strong>t 中两个字符 &#39;a&#39; 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length, t.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>s</code> 和 <code>t</code> 由英文字母组成</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你能设计一个在 <code>o(n)</code> 时间内解决此问题的算法吗？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 76&nbsp;题相似（本题答案不唯一）：<a href="https://leetcode-cn.com/problems/minimum-window-substring/">https://leetcode-cn.com/problems/minimum-window-substring/</a></p>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_017M1oyTv {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_017M1oyTv().new Solution();
        // TO TEST
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int sLen = s.length(), tLen = t.length();
            int[] hash = new int[128];
            String ans = "";
            for (int i = 0; i < tLen; i++) {
                hash[t.charAt(i)]--;
            }
            for (int l = 0, r = 0, count = 0; r < sLen; r++) {
                char c = s.charAt(r);
                if ((++hash[c]) <= 0) {
                    count++;
                }
                if (count == tLen) {
                    while (l <= r && hash[s.charAt(l)] > 0) {
                        hash[s.charAt(l++)]--;
                    }
                    if ("".equals(ans) || ans.length() > r - l + 1) {
                        ans = s.substring(l, r + 1);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}