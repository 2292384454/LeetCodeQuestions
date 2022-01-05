package leetcode.editor.cn;
//Java：最多删除一个字符得到回文

/**
 * <p>给定一个非空字符串&nbsp;<code>s</code>，请判断如果&nbsp;<strong>最多 </strong>从字符串中删除一个字符能否得到一个回文字符串。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = &quot;aba&quot;
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = &quot;abca&quot;
 * <strong>输出:</strong> true
 * <strong>解释:</strong> 可以删除 &quot;c&quot; 字符 或者 &quot;b&quot; 字符
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = &quot;abc&quot;
 * <strong>输出:</strong> false</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>s</code> 由小写英文字母组成</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 680&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/valid-palindrome-ii/">https://leetcode-cn.com/problems/valid-palindrome-ii/</a></p>
 * <div><div>Related Topics</div><div><li>贪心</li><li>双指针</li><li>字符串</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_019RQku0D {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_019RQku0D().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int len = s.length();
            int l = 0, r = len - 1;
            while (l <= r && s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            if (l > r) {
                return true;
            } else {
                boolean remL = true, remR = true;
                for (int i = l + 1, j = r; i <= j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        remL = false;
                        break;
                    }
                }
                for (int i = l, j = r - 1; i <= j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        remR = false;
                        break;
                    }
                }
                return remL || remR;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}