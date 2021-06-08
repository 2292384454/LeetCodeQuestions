//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

//Java：有效的括号
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() == 0) {
                return true;
            }
            Stack<Character> mystack = new Stack<>();
            HashMap<Character, Character> mymap = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            mystack.push(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    mystack.push(s.charAt(i));
                } else if (mystack.empty()) {
                    return false;
                } else if (!mystack.pop().equals(mymap.get(s.charAt(i)))) {
                    return false;
                }
            }
            if (mystack.empty()) {
                return true;
            } else {
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}