package leetcode.editor.cn;
//Java：有效的回文

/**
 * <p>给定一个字符串 <code>s</code> ，验证 <code>s</code>&nbsp;是否是&nbsp;<strong>回文串&nbsp;</strong>，只考虑字母和数字字符，可以忽略字母的大小写。</p>
 *
 * <p>本题中，将空字符串定义为有效的&nbsp;<strong>回文串&nbsp;</strong>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>s =<strong> </strong>&quot;A man, a plan, a canal: Panama&quot;
 * <strong>输出:</strong> true
 * <strong>解释：</strong>&quot;amanaplanacanalpanama&quot; 是回文串</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = &quot;race a car&quot;
 * <strong>输出:</strong> false
 * 解释：&quot;raceacar&quot; 不是回文串</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 2 * 10<sup>5</sup></code></li>
 * <li>字符串 <code>s</code> 由 ASCII 字符组成</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 125&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/valid-palindrome/">https://leetcode-cn.com/problems/valid-palindrome/</a></p>
 * <div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_018XltzEq {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_018XltzEq().new Solution();
        // TO TEST
        System.out.println(solution.isPalindrome("0P"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int len = s.length();
            for (int i = 0, j = len - 1; i <= j && j < len; i++, j--) {
                while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                    i++;
                }
                while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                }
                if (!(s.charAt(i) + "").equalsIgnoreCase(s.charAt(j) + "")) {
                    return false;
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}