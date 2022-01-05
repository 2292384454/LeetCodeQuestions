package leetcode.editor.cn;
//Java：子字符串突变后可能得到的最大整数

/**
 * <p>给你一个字符串 <code>num</code> ，该字符串表示一个大整数。另给你一个长度为 <code>10</code> 且 <strong>下标从 0&nbsp; 开始</strong> 的整数数组 <code>change</code> ，该数组将 <code>0-9</code> 中的每个数字映射到另一个数字。更规范的说法是，数字 <code>d</code> 映射为数字 <code>change[d]</code> 。</p>
 *
 * <p>你可以选择 <strong>突变</strong>&nbsp; <code>num</code> 的任一子字符串。<strong>突变</strong> 子字符串意味着将每位数字 <code>num[i]</code> 替换为该数字在 <code>change</code> 中的映射（也就是说，将 <code>num[i]</code> 替换为 <code>change[num[i]]</code>）。</p>
 *
 * <p>请你找出在对 <code>num</code> 的任一子字符串执行突变操作（也可以不执行）后，可能得到的 <strong>最大整数</strong> ，并用字符串表示返回。</p>
 *
 * <p><strong>子字符串</strong> 是字符串中的一个连续序列。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>num = "<strong><em>1</em></strong>32", change = [9,8,5,0,3,6,4,2,6,8]
 * <strong>输出：</strong>"<strong><em>8</em></strong>32"
 * <strong>解释：</strong>替换子字符串 "1"：
 * - 1 映射为 change[1] = 8 。
 * 因此 "<strong><em>1</em></strong>32" 变为 "<strong><em>8</em></strong>32" 。
 * "832" 是可以构造的最大整数，所以返回它的字符串表示。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>num = "<strong><em>021</em></strong>", change = [9,4,3,5,7,2,1,9,0,6]
 * <strong>输出：</strong>"<strong><em>934</em></strong>"
 * <strong>解释：</strong>替换子字符串 "021"：
 * - 0 映射为 change[0] = 9 。
 * - 2 映射为 change[2] = 3 。
 * - 1 映射为 change[1] = 4 。
 * 因此，"<strong><em>021</em></strong>" 变为 "<strong><em>934</em></strong>" 。
 * "934" 是可以构造的最大整数，所以返回它的字符串表示。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>num = "5", change = [1,4,7,5,3,2,5,6,9,4]
 * <strong>输出：</strong>"5"
 * <strong>解释：</strong>"5" 已经是可以构造的最大整数，所以返回它的字符串表示。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= num.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>num</code> 仅由数字 <code>0-9</code> 组成</li>
 * <li><code>change.length == 10</code></li>
 * <li><code>0 &lt;= change[d] &lt;= 9</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>字符串</li></div></div><p><div><li>👍 1</li><li>👎 0</li></div>
 */
public class P1946LargestNumberAfterMutatingSubstring {
    public static void main(String[] args) {
        Solution solution = new P1946LargestNumberAfterMutatingSubstring().new Solution();
        // TO TEST
        String num = "334111";
        int[] change = new int[]{0, 9, 2, 3, 3, 2, 5, 5, 5, 5};
        System.out.println(solution.maximumNumber(num, change));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumNumber(String num, int[] change) {
            int n = num.length();
            StringBuilder allChanged = new StringBuilder();
            for (int i = 0; i < n; i++) {
                allChanged.append(change[num.charAt(i) - '0']);
            }
            int l = 0;
            // 找到第一个满足 num.charAt(l) < allChanged.charAt(l) 的 l
            while (l < n && num.charAt(l) >= allChanged.charAt(l)) {
                l++;
            }
            if (l == n) {
                return num;
            }
            int r = l;
            // 找到第一个满足 num.charAt(r) >  allChanged.charAt(r) 的 r
            while (r < n && num.charAt(r) <= allChanged.charAt(r)) {
                r++;
            }
            // 将 [l,r) 范围内的字符串进行替换，返回结果
            return num.substring(0, l) + allChanged.substring(l, r) + num.substring(r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}