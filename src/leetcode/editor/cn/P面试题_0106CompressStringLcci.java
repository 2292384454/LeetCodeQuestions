package leetcode.editor.cn;
//Java：字符串压缩

/**
 * <p>字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串<code>aabcccccaaa</code>会变为<code>a2b1c5a3</code>。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。</p>
 *
 * <p> <strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>："aabcccccaaa"
 * <strong> 输出</strong>："a2b1c5a3"
 * </pre>
 *
 * <p> <strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>："abbccd"
 * <strong> 输出</strong>："abbccd"
 * <strong> 解释</strong>："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * <li>字符串长度在[0, 50000]范围内。</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><p><div><li>👍 91</li><li>👎 0</li></div>
 */
public class P面试题_0106CompressStringLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0106CompressStringLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String compressString(String S) {
            if (S == null || S.length() == 0) {
                return "";
            }
            StringBuilder ans = new StringBuilder();
            int len = S.length();
            int count = 1, i = 0;
            for (; i < len - 1; i++) {
                if (S.charAt(i) == S.charAt(i + 1)) {
                    count++;
                } else {
                    ans.append(S.charAt(i)).append(count);
                    count = 1;
                }
            }
            // 最后一个字符单独处理
            ans.append(S.charAt(i)).append(count);
            if (ans.length() >= S.length()) {
                return S;
            } else {
                return ans.toString();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}