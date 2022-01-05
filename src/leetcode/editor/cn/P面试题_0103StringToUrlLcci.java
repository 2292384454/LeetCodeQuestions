package leetcode.editor.cn;
//Java：URL化

/**
 * <p>URL化。编写一种方法，将字符串中的空格全部替换为<code>%20</code>。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用<code>Java</code>实现的话，请使用字符数组实现，以便直接在数组上操作。）</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入</strong>："Mr John Smith    ", 13
 * <strong>输出</strong>："Mr%20John%20Smith"
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入</strong>："               ", 5
 * <strong>输出</strong>："%20%20%20%20%20"
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>字符串长度在 [0, 500000] 范围内。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><p><div><li>👍 42</li><li>👎 0</li></div>
 */
public class P面试题_0103StringToUrlLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0103StringToUrlLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpaces(String S, int length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (S.charAt(i) == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(S.charAt(i));
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}