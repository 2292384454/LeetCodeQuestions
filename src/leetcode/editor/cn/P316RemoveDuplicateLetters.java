//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 536 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：去除重复字母
public class P316RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new P316RemoveDuplicateLetters().new Solution();
        // TO TEST
        String s = "abacb";
        System.out.println(solution.removeDuplicateLetters(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            Stack<Character> stack = new Stack<>();
            // 维护一个计数器记录字符串中字符的数量
            // 因为输入为 ASCII 字符，大小 256 够用了
            int[] count = new int[256];
            for (char c : s.toCharArray()) {
                count[c]++;
            }
            boolean[] inStack = new boolean[256]; // inStack 记录字符串 inStack[i] 是否在栈 stack 中
            for (char c : s.toCharArray()) {
                count[c]--; // 每遍历过一个字符，都将对应的计数减一
                if (inStack[c]) {
                    // 如果字符已经在栈中出现过了，就continue
                    continue;
                }
                while (!stack.isEmpty() && stack.peek() > c) {
                    // 若字符c之后不再存在栈顶元素了，即当前栈顶的字符是在字符串中最后一次出现，则停止 pop
                    if (count[stack.peek()] == 0) {
                        break;
                    }
                    // 若之后还有，则可以 pop
                    inStack[stack.pop()] = false;
                }
                stack.push(c);
                inStack[c] = true;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.empty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
