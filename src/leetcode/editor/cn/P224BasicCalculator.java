package leetcode.editor.cn;
//Java：基本计算器

import java.util.Stack;

/**
 * <p>给你一个字符串表达式 <code>s</code> ，请你实现一个基本计算器来计算并返回它的值。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "1 + 1"
 * <strong>输出：</strong>2
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = " 2-1 + 2 "
 * <strong>输出：</strong>3
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "(1+(4+5+2)-3)+(6+8)"
 * <strong>输出：</strong>23
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= s.length <= 3 * 10<sup>5</sup></code></li>
 * <li><code>s</code> 由数字、<code>'+'</code>、<code>'-'</code>、<code>'('</code>、<code>')'</code>、和 <code>' '</code> 组成</li>
 * <li><code>s</code> 表示一个有效的表达式</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>栈</li><li>递归</li><li>数学</li><li>字符串</li></div></div><p><div><li>👍 596</li><li>👎 0</li></div>
 */
public class P224BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new P224BasicCalculator().new Solution();
        // TO TEST
        System.out.println(solution.calculate("(5-(1+(5)))"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            s = s.trim();
            if (s.length() == 0) {
                return 0;
            }
            int len = s.length();
            char[] str = s.toCharArray();
            // 没有括号，直接计算
            if (!s.contains("(")) {
                int ans = 0;
                int op = str[0] == '-' ? -1 : 1;
                for (int i = 0; i < len; i++) {
                    if (str[i] == ' ') {
                        // 如果遇到空格，跳过
                        continue;
                    }
                    int num = 0;
                    while (i < str.length && Character.isDigit(str[i])) {
                        num = num * 10 + str[i] - '0';
                        i++;
                    }
                    if (i == str.length) {
                        ans += op * num;
                        return ans;
                    } else {
                        ans += op * num;
                        op = str[i] == '+' ? 1 : -1;
                    }
                }
                return ans;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                if (str[i] == ' ') {
                    // 如果遇到空格，跳过
                    continue;
                }
                if (str[i] == ')') {
                    // 遇到右括号，出栈递归
                    char c;
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty() && (c = stack.pop()) != '(') {
                        sb.append(c);
                    }
                    int tempRes = calculate(sb.reverse().toString());
                    if (tempRes < 0 && !stack.isEmpty() && stack.peek() == '-') {
                        stack.pop();
                        stack.push('+');
                        tempRes = -tempRes;
                    }
                    for (char x : (tempRes + "").toCharArray()) {
                        stack.push(x);
                    }
                } else {
                    stack.push(str[i]);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return calculate(sb.reverse().toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}