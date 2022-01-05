package leetcode.editor.cn;
//Java：判定是否互为字符重排

import java.util.Arrays;

/**
 * <p>给定两个字符串 <code>s1</code> 和 <code>s2</code>，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong> <code>s1</code> = &quot;abc&quot;, <code>s2</code> = &quot;bca&quot;
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入:</strong> <code>s1</code> = &quot;abc&quot;, <code>s2</code> = &quot;bad&quot;
 * <strong>输出:</strong> false
 * </pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= len(s1) &lt;= 100 </code></li>
 * <li><code>0 &lt;= len(s2) &lt;= 100 </code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>排序</li></div></div><p><div><li>👍 36</li><li>👎 0</li></div>
 */
public class P面试题_0102CheckPermutationLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0102CheckPermutationLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            char[] array = s1.toCharArray();
            Arrays.sort(array);
            String Sorted1 = new String(array);
            array = s2.toCharArray();
            Arrays.sort(array);
            String Sorted2 = new String(array);
            return Sorted1.equals(Sorted2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}