// 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
// 。 
//
// 示例 1: 
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// 示例 2: 
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10 
// Related Topics 分治算法 
// 👍 372 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：为运算表达式设计优先级
public class P241DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new P241DifferentWaysToAddParentheses().new Solution();
        // TO TEST
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //遍历字符串
        //遇到操作符，就将左右两边的字符串，分别当作两个表达式
        public List<Integer> diffWaysToCompute(String input) {
            if (input == null || input.length() <= 0) {
                return new ArrayList<>();
            }
            ArrayList<Integer> curRes = new ArrayList<>();
            int length = input.length();
            for (int i = 0; i < length; i++) {
                char aChar = input.charAt(i);
                if (aChar == '+' || aChar == '-' || aChar == '*') { // 当前字符为 操作符
                    List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                    List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
                    for (int leftNum : leftList) {
                        for (int rightNum : rightList) {
                            if (aChar == '+') {
                                curRes.add(leftNum + rightNum);
                            } else if (aChar == '-') {
                                curRes.add(leftNum - rightNum);
                            } else {
                                curRes.add(leftNum * rightNum);
                            }
                        }
                    }
                }
            }
            if (curRes.isEmpty()) {
                curRes.add(Integer.valueOf(input));
            }
            return curRes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
