package leetcode.editor.cn;
//Java：字符串轮转

/**
 * <p>字符串轮转。给定两个字符串<code>s1</code>和<code>s2</code>，请编写代码检查<code>s2</code>是否为<code>s1</code>旋转而成（比如，<code>waterbottle</code>是<code>erbottlewat</code>旋转后的字符串）。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>：s1 = &quot;waterbottle&quot;, s2 = &quot;erbottlewat&quot;
 * <strong> 输出</strong>：True
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：s1 = &quot;aa&quot;, s2 = &quot;aba&quot;
 * <strong> 输出</strong>：False
 * </pre>
 *
 * <ol>
 * </ol>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * <li>字符串长度在[0, 100000]范围内。</li>
 * </ol>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ol>
 * <li>你能只调用一次检查子串的方法吗？</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>字符串</li><li>字符串匹配</li></div></div><p><div><li>👍 75</li><li>👎 0</li></div>
 */
public class P面试题_0109StringRotationLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0109StringRotationLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            return (s1 + s1).contains(s2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}