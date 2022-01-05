package leetcode.editor.cn;
//Java：最小覆盖子串

/**
 * <p>给你一个字符串 <code>s</code> 、一个字符串 <code>t</code> 。返回 <code>s</code> 中涵盖 <code>t</code> 所有字符的最小子串。如果 <code>s</code> 中不存在涵盖 <code>t</code> 所有字符的子串，则返回空字符串 <code>""</code> 。</p>
 *
 * <p><strong>注意：</strong>如果 <code>s</code> 中存在这样的子串，我们保证它是唯一的答案。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "ADOBECODEBANC", t = "ABC"
 * <strong>输出：</strong>"BANC"
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "a", t = "a"
 * <strong>输出：</strong>"a"
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= s.length, t.length <= 10<sup>5</sup></code></li>
 * <li><code>s</code> 和 <code>t</code> 由英文字母组成</li>
 * </ul>
 *
 * <p> </p>
 * <strong>进阶：</strong>你能设计一个在 <code>o(n)</code> 时间内解决此问题的算法吗？<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><p><div><li>👍 1242</li><li>👎 0</li></div>
 */
public class P76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
        // System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("ab", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int sLen = s.length(), tLen = t.length();
            // hash 用来统计每个字符出现的次数
            // 在 t 中出现减一 ，在 s 中出现加一
            // 当 hash 中所有字符出现的次数都非负，说明匹配上了
            int[] hash = new int[128];
            for (char ch : t.toCharArray()) {
                hash[ch]--;
            }
            String ans = "";
            // left: ans 的左端位置，
            // right： ans 的右端位置
            // cnt：已经匹配上的字符数
            for (int left = 0, right = 0, cnt = 0; right < sLen; right++) {
                // 如果当前字符可以匹配到 t 中某个尚未匹配的字符，就将 cnt 加一
                if (++hash[s.charAt(right)] <= 0) {
                    cnt++;
                }
                // 如果 t 中所有字符均已匹配上，那么试图缩紧左边界并更新 ans
                if (cnt == tLen) {
                    while (hash[s.charAt(left)] > 0) {
                        hash[s.charAt(left++)]--;
                    }
                    // 只在 ans 为空字符串或者 ans 长度大于当前长度时更新
                    if ("".equals(ans) || ans.length() > (right - left + 1)) {
                        ans = s.substring(left, right + 1);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}