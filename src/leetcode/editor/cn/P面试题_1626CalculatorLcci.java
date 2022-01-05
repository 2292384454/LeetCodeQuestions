package leetcode.editor.cn;
//Java：计算器

import java.util.Stack;

/**
 * <p>给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。</p>
 *
 * <p>表达式仅包含非负整数，<code>+</code>， <code>-</code> ，<code>*</code>，<code>/</code> 四种运算符和空格&nbsp;<code>&nbsp;</code>。 整数除法仅保留整数部分。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入: </strong>&quot;3+2*2&quot;
 * <strong>输出:</strong> 7
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> &quot; 3/2 &quot;
 * <strong>输出:</strong> 1</pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre><strong>输入:</strong> &quot; 3+5 / 2 &quot;
 * <strong>输出:</strong> 5
 * </pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ul>
 * <li>你可以假设所给定的表达式都是有效的。</li>
 * <li>请<strong>不要</strong>使用内置的库函数 <code>eval</code>。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>栈</li><li>数学</li><li>字符串</li></div></div><p><div><li>👍 46</li><li>👎 0</li></div>
 */
public class P面试题_1626CalculatorLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_1626CalculatorLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            int len = s.length();
            char[] str = s.toCharArray();
            Stack<Integer> st_num = new Stack<>();
            char op = '#';         //记录乘除符号
            int ans = 0, sign = 1;    //记录加减符号
            for (int i = 0; i < len; i++) {
                if (str[i] == ' ') {
                    continue;
                }
                if (Character.isDigit(str[i])) {
                    int num = str[i] - '0';
                    //找完这个数
                    while (i < len - 1 && Character.isDigit(str[i + 1])) {
                        num = num * 10 + (str[++i] - '0');
                    }
                    if (op != '#') {                                //如果之前有乘除符号
                        if (op == '*') {
                            num *= st_num.pop();           //则将这个数运算之后，再重新进栈
                        } else {
                            num = st_num.pop() / num;
                        }
                        op = '#';                                //重置乘除符号
                    }
                    st_num.push(num);
                } else if (str[i] == '*' || str[i] == '/') {
                    op = str[i];  //更新乘除符号
                } else {                                         //遇到加减符号则可以直接更新ans了
                    ans += st_num.pop() * sign;
                    sign = str[i] == '+' ? 1 : -1;   //更新加减符号
                }
            }
            return ans + st_num.pop() * sign;   //sign更新后，还有一次未计算
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}