package leetcode.editor.cn;
//Java：交换数字

/**
 * <p>编写一个函数，不用临时变量，直接交换<code>numbers = [a, b]</code>中<code>a</code>与<code>b</code>的值。</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> numbers = [1,2]
 * <strong>输出:</strong> [2,1]
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>numbers.length == 2</code></li>
 * <li><code>-2147483647 <= numbers[i] <= 2147483647</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数学</li></div></div><p><div><li>👍 52</li><li>👎 0</li></div>
 */
public class P面试题_1601SwapNumbersLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_1601SwapNumbersLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] swapNumbers(int[] numbers) {
            numbers[0] = numbers[0] ^ numbers[1];
            numbers[1] = numbers[0] ^ numbers[1];
            numbers[0] = numbers[0] ^ numbers[1];
            return numbers;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}