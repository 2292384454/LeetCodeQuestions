//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。 
//
// 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同 
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
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 98 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：不同字符的最小子序列
public class P1081SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new P1081SmallestSubsequenceOfDistinctCharacters().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestSubsequence(String s) {
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
