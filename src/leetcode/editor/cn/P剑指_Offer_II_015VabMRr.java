package leetcode.editor.cn;
//Java：字符串中的所有变位词

import java.util.ArrayList;
import java.util.List;

/**
 * <p>给定两个字符串&nbsp;<code>s</code>&nbsp;和<b>&nbsp;</b><code>p</code>，找到&nbsp;<code>s</code><strong>&nbsp;</strong>中所有 <code>p</code> 的&nbsp;<strong>变位词&nbsp;</strong>的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>
 *
 * <p><strong>变位词 </strong>指字母相同，但排列不同的字符串。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>s = &quot;cbaebabacd&quot;, p = &quot;abc&quot;
 * <strong>输出: </strong>[0,6]
 * <strong>解释:</strong>
 * 起始索引等于 0 的子串是 &quot;cba&quot;, 它是 &quot;abc&quot; 的变位词。
 * 起始索引等于 6 的子串是 &quot;bac&quot;, 它是 &quot;abc&quot; 的变位词。
 * </pre>
 *
 * <p><strong>&nbsp;示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>s = &quot;abab&quot;, p = &quot;ab&quot;
 * <strong>输出: </strong>[0,1,2]
 * <strong>解释:</strong>
 * 起始索引等于 0 的子串是 &quot;ab&quot;, 它是 &quot;ab&quot; 的变位词。
 * 起始索引等于 1 的子串是 &quot;ba&quot;, 它是 &quot;ab&quot; 的变位词。
 * 起始索引等于 2 的子串是 &quot;ab&quot;, 它是 &quot;ab&quot; 的变位词。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>s</code>&nbsp;和 <code>p</code> 仅包含小写字母</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p>注意：本题与主站 438&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/" style="background-color: rgb(255, 255, 255);">https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/</a></p>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_015VabMRr {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_015VabMRr().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int len1 = p.length(), len2 = s.length();
            // hash 记录 s1 中每个字符出现的次数，用负数统计
            // 如果匹配上了就 +1
            // 当 hash 中的所有数字都大于等于 0 时说明 s2 中出现了 s1 的 “变位词”
            int[] hash = new int[26];
            for (int i = 0; i < len1; i++) {
                hash[p.charAt(i) - 'a']--;
            }
            for (int l = 0, r = 0, coun = 0; r < len2; r++) {
                if (++hash[s.charAt(r) - 'a'] <= 0) {
                    coun++;
                }
                if (coun == len1) {
                    while (hash[s.charAt(l) - 'a'] > 0) {
                        hash[s.charAt(l++) - 'a']--;
                    }
                    if (r - l + 1 == len1) {
                        ans.add(l);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}