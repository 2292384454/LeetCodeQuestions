package leetcode.editor.cn;
//Java：有效的变位词

/**
 * <p>给定两个字符串 <code>s</code> 和 <code>t</code> ，编写一个函数来判断它们是不是一组变位词（字母异位词）。</p>
 *
 * <p><strong>注意：</strong>若&nbsp;<code><em>s</em></code> 和 <code><em>t</em></code><em>&nbsp;</em>中每个字符出现的次数都相同且<strong>字符顺序不完全相同</strong>，则称&nbsp;<code><em>s</em></code> 和 <code><em>t</em></code><em>&nbsp;</em>互为变位词（字母异位词）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = &quot;anagram&quot;, t = &quot;nagaram&quot;
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = &quot;rat&quot;, t = &quot;car&quot;
 * <strong>输出: </strong>false</pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = &quot;a&quot;, t = &quot;a&quot;
 * <strong>输出: </strong>false</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length, t.length &lt;= 5 * 10<sup>4</sup></code></li>
 * <li><code>s</code>&nbsp;and&nbsp;<code>t</code>&nbsp;仅包含小写字母</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶:&nbsp;</strong>如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 242&nbsp;题相似（字母异位词定义不同）：<a href="https://leetcode-cn.com/problems/valid-anagram/">https://leetcode-cn.com/problems/valid-anagram/</a></p>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>排序</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_032DKk3P7 {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_032DKk3P7().new Solution();
        // TO TEST
        String s = "nl";
        String t = "cx";
        System.out.println(solution.isAnagram(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            int sLen = s.length(), tLen = t.length();
            if (sLen != tLen) {
                return false;
            }
            int[] count = new int[26];
            boolean allSame = true;
            for (int i = 0; i < sLen; i++) {
                char c1 = s.charAt(i), c2 = t.charAt(i);
                if (c1 != c2) {
                    allSame = false;
                }
                count[c1 - 'a']++;
                count[c2 - 'a']--;
            }
            if (allSame) {
                return false;
            }
            for (int i : count) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}