//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 392 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：基本计算器 II
public class P227BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new P227BasicCalculatorIi().new Solution();
        // TO TEST
        System.out.println(solution.calculate("3+2*2"));
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
                    while (i < len - 1 && Character.isDigit(str[i + 1]))  //找完这个数
                    {
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
