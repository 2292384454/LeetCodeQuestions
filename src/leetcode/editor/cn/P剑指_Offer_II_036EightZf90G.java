package leetcode.editor.cn;
//Java：后缀表达式

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>根据<a href="https://baike.baidu.com/item/%E9%80%86%E6%B3%A2%E5%85%B0%E5%BC%8F/128437" target="_blank"> 逆波兰表示法</a>，求该后缀表达式的计算结果。</p>
 *
 * <p>有效的算符包括&nbsp;<code>+</code>、<code>-</code>、<code>*</code>、<code>/</code>&nbsp;。每个运算对象可以是整数，也可以是另一个逆波兰表达式。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ul>
 * <li>整数除法只保留整数部分。</li>
 * <li>给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>tokens = [&quot;2&quot;,&quot;1&quot;,&quot;+&quot;,&quot;3&quot;,&quot;*&quot;]
 * <strong>输出：</strong>9
 * <strong>解释：</strong>该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * </pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>tokens = [&quot;4&quot;,&quot;13&quot;,&quot;5&quot;,&quot;/&quot;,&quot;+&quot;]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * </pre>
 *
 * <p><strong>示例&nbsp;3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>tokens = [&quot;10&quot;,&quot;6&quot;,&quot;9&quot;,&quot;3&quot;,&quot;+&quot;,&quot;-11&quot;,&quot;*&quot;,&quot;/&quot;,&quot;*&quot;,&quot;17&quot;,&quot;+&quot;,&quot;5&quot;,&quot;+&quot;]
 * <strong>输出：</strong>22
 * <strong>解释：</strong>
 * 该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= tokens.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>tokens[i]</code> 要么是一个算符（<code>&quot;+&quot;</code>、<code>&quot;-&quot;</code>、<code>&quot;*&quot;</code> 或 <code>&quot;/&quot;</code>），要么是一个在范围 <code>[-200, 200]</code> 内的整数</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>逆波兰表达式：</strong></p>
 *
 * <p>逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。</p>
 *
 * <ul>
 * <li>平常使用的算式则是一种中缀表达式，如 <code>( 1 + 2 ) * ( 3 + 4 )</code> 。</li>
 * <li>该算式的逆波兰表达式写法为 <code>( ( 1 2 + ) ( 3 4 + ) * )</code> 。</li>
 * </ul>
 *
 * <p>逆波兰表达式主要有以下两个优点：</p>
 *
 * <ul>
 * <li>去掉括号后表达式无歧义，上式即便写成 <code>1 2 + 3 4 + * </code>也可以依据次序计算出正确结果。</li>
 * <li>适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 150&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/">https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/</a></p>
 * <div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>数学</li></div></div><p><div><li>👍 1</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_036EightZf90G {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_036EightZf90G().new Solution();
        // TO TEST
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            final int ILLEGAL_NUM = -999;
            Deque<Integer> integerStack = new LinkedList<>();
            for (String token : tokens) {
                int num = ILLEGAL_NUM;
                try {
                    num = Integer.parseInt(token);
                    integerStack.push(num);
                } catch (Exception ignored) {
                }
                if (num == ILLEGAL_NUM) {
                    int b = integerStack.pop();
                    int a = integerStack.pop();
                    int c = ILLEGAL_NUM;
                    switch (token) {
                        case "+":
                            c = a + b;
                            break;
                        case "-":
                            c = a - b;
                            break;
                        case "*":
                            c = a * b;
                            break;
                        case "/":
                            c = a / b;
                            break;
                    }
                    integerStack.push(c);
                }
            }
            return integerStack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}