package leetcode.editor.cn;
//Java：判定字符是否唯一

import java.util.Arrays;

/**
 * <p>实现一个算法，确定一个字符串 <code>s</code> 的所有字符是否全都不同。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong> <code>s</code> = &quot;leetcode&quot;
 * <strong>输出:</strong> false
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入:</strong> <code>s</code> = &quot;abc&quot;
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>限制：</strong></p>
 * <ul>
 * <li><code>0 <= len(s) <= 100 </code></li>
 * <li>如果你不使用额外的数据结构，会很加分。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>哈希表</li><li>字符串</li><li>排序</li></div></div><p><div><li>👍 127</li><li>👎 0</li></div>
 */
public class P面试题_0101IsUniqueLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0101IsUniqueLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUnique(String astr) {
            char[] array = astr.toCharArray();
            Arrays.sort(array);
            for (int i = 1; i < array.length; i++) {
                if (array[i] == array[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}