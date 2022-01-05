package leetcode.editor.cn;
//Java：二进制加法

/**
 * <p>给定两个 01 字符串&nbsp;<code>a</code>&nbsp;和&nbsp;<code>b</code>&nbsp;，请计算它们的和，并以二进制字符串的形式输出。</p>
 *
 * <p>输入为 <strong>非空 </strong>字符串且只包含数字&nbsp;<code>1</code>&nbsp;和&nbsp;<code>0</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> a = &quot;11&quot;, b = &quot;10&quot;
 * <strong>输出:</strong> &quot;101&quot;</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> a = &quot;1010&quot;, b = &quot;1011&quot;
 * <strong>输出:</strong> &quot;10101&quot;</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>每个字符串仅由字符 <code>&#39;0&#39;</code> 或 <code>&#39;1&#39;</code> 组成。</li>
 * <li><code>1 &lt;= a.length, b.length &lt;= 10^4</code></li>
 * <li>字符串如果不是 <code>&quot;0&quot;</code> ，就都不含前导零。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 67&nbsp;题相同：<a href="https://leetcode-cn.com/problems/add-binary/">https://leetcode-cn.com/problems/add-binary/</a></p>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数学</li><li>字符串</li><li>模拟</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_002JFETK5 {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_002JFETK5().new Solution();
        // TO TEST
        String a = "1", b = "111";
        System.out.println(solution.addBinary(a, b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if ((b = effectivePart(b)) == null) {
                return a;
            }
            String[] temp = compute(a, b);
            temp[1] += "0";
            return addBinary(temp[0], temp[1]);
        }

        /**
         * 计算 a 和 b 表示的数字的 按位异或、按位与 结果字符串
         *
         * @param a 输入
         * @param b 输入
         * @return ans[0]:a 和 b 表示的数字的 按位异或 字符串 ；ans[1]:a 和 b 表示的数字的 按位与 字符串
         */
        private String[] compute(String a, String b) {
            int len1 = a.length(), len2 = b.length();
            int manLen = Math.max(len1, len2);
            StringBuilder andSb = new StringBuilder();
            StringBuilder xorSb = new StringBuilder();
            for (int i = 1; i <= manLen; i++) {
                int bit1 = (i <= len1 ? a.charAt(len1 - i) - '0' : 0);
                int bit2 = (i <= len2 ? b.charAt(len2 - i) - '0' : 0);
                xorSb.append(bit1 ^ bit2);
                andSb.append(bit1 & bit2);
            }
            String[] ans = new String[2];
            ans[0] = xorSb.reverse().toString();
            ans[1] = andSb.reverse().toString();
            return ans;
        }

        /**
         * 返回 s 字符串中从第一个非 '0' 开始的后半部分子串，如果 s 为 null 或者 s 中只有 '0' ，返回 null
         */
        private String effectivePart(String s) {
            if (s == null) {
                return null;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    return s.substring(i);
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}