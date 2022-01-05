package leetcode.editor.cn;
//Java：长度为 3 的不同回文子序列

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>给你一个字符串 <code>s</code> ，返回 <code>s</code> 中 <strong>长度为 3 </strong>的<strong>不同回文子序列</strong> 的个数。</p>
 *
 * <p>即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。</p>
 *
 * <p><strong>回文</strong> 是正着读和反着读一样的字符串。</p>
 *
 * <p><strong>子序列</strong> 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。</p>
 *
 * <ul>
 * <li>例如，<code>"ace"</code> 是 <code>"<strong><em>a</em></strong>b<strong><em>c</em></strong>d<strong><em>e</em></strong>"</code> 的一个子序列。</li>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "aabca"
 * <strong>输出：</strong>3
 * <strong>解释：</strong>长度为 3 的 3 个回文子序列分别是：
 * - "aba" ("<strong><em>a</em></strong>a<strong><em>b</em></strong>c<strong><em>a</em></strong>" 的子序列)
 * - "aaa" ("<strong><em>aa</em></strong>bc<strong><em>a</em></strong>" 的子序列)
 * - "aca" ("<strong><em>a</em></strong>ab<strong><em>ca</em></strong>" 的子序列)
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "adc"
 * <strong>输出：</strong>0
 * <strong>解释：</strong>"adc" 不存在长度为 3 的回文子序列。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "bbcbaba"
 * <strong>输出：</strong>4
 * <strong>解释：</strong>长度为 3 的 4 个回文子序列分别是：
 * - "bbb" ("<strong><em>bb</em></strong>c<strong><em>b</em></strong>aba" 的子序列)
 * - "bcb" ("<strong><em>b</em></strong>b<strong><em>cb</em></strong>aba" 的子序列)
 * - "bab" ("<strong><em>b</em></strong>bcb<strong><em>ab</em></strong>a" 的子序列)
 * - "aba" ("bbcb<strong><em>aba</em></strong>" 的子序列)
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>3 <= s.length <= 10<sup>5</sup></code></li>
 * <li><code>s</code> 仅由小写英文字母组成</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>前缀和</li></div></div><p><div><li>👍 8</li><li>👎 0</li></div>
 */
public class P1930UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        Solution solution = new P1930UniqueLength3PalindromicSubsequences().new Solution();
        // TO TEST
        System.out.println(solution.countPalindromicSubsequence("adc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPalindromicSubsequence(String s) {
            int n = s.length();
            int res = 0;
            // 前缀/后缀字符状态数组
            int[] pre = new int[n], suf = new int[n];
            for (int i = 1; i < n; i++) {
                // 前缀 s[0..i-1] 包含的字符种类
                pre[i] = pre[i - 1] | (1 << (s.charAt(i - 1) - 'a'));
                // 后缀 s[i+1..n-1] 包含的字符种类
                suf[n - 1 - i] = suf[n - i] | (1 << (s.charAt(n - i) - 'a'));
            }
            // 每种中间字符的回文子序列状态数组
            int[] ans = new int[26];
            for (int i = 1; i < n - 1; i++) {
                ans[s.charAt(i) - 'a'] |= (pre[i] & suf[i]);
            }
            // 更新答案
            for (int i = 0; i < 26; i++) {
                res += countOfOne(ans[i]);
            }
            return res;
        }

        private int countOfOne(int n) {
            int count = 0;
            while (n > 0) {
                n &= (n - 1);
                count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}