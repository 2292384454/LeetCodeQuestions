package leetcode.editor.cn;
//Java：配对交换

/**
 * <p>配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。</p>
 *
 * <p> <strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：num = 2（或者0b10）
 * <strong> 输出</strong> 1 (或者 0b01)
 * </pre>
 *
 * <p> <strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：num = 3
 * <strong> 输出</strong>：3
 * </pre>
 *
 * <p> <strong>提示:</strong></p>
 *
 * <ol>
 * <li><code>num</code>的范围在[0, 2^30 - 1]之间，不会发生整数溢出。</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>位运算</li></div></div><p><div><li>👍 46</li><li>👎 0</li></div>
 */
public class P面试题_0507ExchangeLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0507ExchangeLcci().new Solution();
        // TO TEST
        System.out.println(solution.exchangeBits(45263975));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int exchangeBits(int num) {
            return ((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >> 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}