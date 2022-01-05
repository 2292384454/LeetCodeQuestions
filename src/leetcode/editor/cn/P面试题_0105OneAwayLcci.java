package leetcode.editor.cn;
//Java：一次编辑

/**
 * <p>字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * first = &quot;pale&quot;
 * second = &quot;ple&quot;
 * <strong>输出:</strong> True</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * first = &quot;pales&quot;
 * second = &quot;pal&quot;
 * <strong>输出:</strong> False
 * </pre>
 * <div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><p><div><li>👍 77</li><li>👎 0</li></div>
 */
public class P面试题_0105OneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0105OneAwayLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int len1 = first.length(), len2 = second.length();
            if (Math.abs(len1 - len2) > 1) {
                return false;
            } else if (Math.abs(len1 - len2) == 1) {
                // 插入 or 删除 的情况
                int i = 0, j = 0;
                while (i < len1 && j < len2 && first.charAt(i) == second.charAt(j)) {
                    i++;
                    j++;
                }
                if (i == len1 || j == len2) {
                    return true;
                }
                if (len1 > len2) {
                    i++;
                } else {
                    j++;
                }
                for (; i < len1 && j < len2; i++, j++) {
                    if (first.charAt(i) != second.charAt(j)) {
                        return false;
                    }
                }
            } else {
                // 替换 的情况
                int i = 0, j = 0;
                while (i < len1 && j < len2 && first.charAt(i) == second.charAt(j)) {
                    i++;
                    j++;
                }
                i++;
                j++;
                for (; i < len1 && j < len2; i++, j++) {
                    if (first.charAt(i) != second.charAt(j)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}