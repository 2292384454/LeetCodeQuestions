package leetcode.editor.cn;
//Java：字符串中的变位词

/**
 * <p>给定两个字符串&nbsp;<code>s1</code>&nbsp;和&nbsp;<code>s2</code>，写一个函数来判断 <code>s2</code> 是否包含 <code>s1</code><strong>&nbsp;</strong>的某个变位词。</p>
 *
 * <p>换句话说，第一个字符串的排列之一是第二个字符串的 <strong>子串</strong> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>s1 = &quot;ab&quot; s2 = &quot;eidbaooo&quot;
 * <strong>输出: </strong>True
 * <strong>解释:</strong> s2 包含 s1 的排列之一 (&quot;ba&quot;).
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>s1= &quot;ab&quot; s2 = &quot;eidboaoo&quot;
 * <strong>输出:</strong> False
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>s1</code> 和 <code>s2</code> 仅包含小写字母</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 567&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/permutation-in-string/">https://leetcode-cn.com/problems/permutation-in-string/</a></p>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>双指针</li><li>字符串</li><li>滑动窗口</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_014MPnaiL {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_014MPnaiL().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            // hash 记录 s1 中每个字符出现的次数，用负数统计
            // 如果匹配上了就 +1
            // 当 hash 中的所有数字都大于等于 0 时说明 s2 中出现了 s1 的 “变位词”
            int[] hash = new int[26];
            for (int i = 0; i < len1; i++) {
                hash[s1.charAt(i) - 'a']--;
            }
            for (int l = 0, r = 0, coun = 0; r < len2; r++) {
                if (++hash[s2.charAt(r) - 'a'] <= 0) {
                    coun++;
                }
                if (coun == len1) {
                    while (hash[s2.charAt(l) - 'a'] > 0) {
                        hash[s2.charAt(l++) - 'a']--;
                    }
                    if (r - l + 1 == len1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}