package leetcode.editor.cn;
//Java：递归乘法

/**
 * <p>递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。</p>
 *
 * <p> <strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：A = 1, B = 10
 * <strong> 输出</strong>：10
 * </pre>
 *
 * <p> <strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：A = 3, B = 4
 * <strong> 输出</strong>：12
 * </pre>
 *
 * <p> <strong>提示:</strong></p>
 *
 * <ol>
 * <li>保证乘法范围不会溢出</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>位运算</li><li>递归</li><li>数学</li></div></div><p><div><li>👍 44</li><li>👎 0</li></div>
 */
public class P面试题_0805RecursiveMulitplyLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0805RecursiveMulitplyLcci().new Solution();
        // TO TEST
        System.out.println(solution.multiply(15, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int multiply(int A, int B) {
            int max = Math.max(A, B);
            int min = max ^ A ^ B;
            return (int) (helper(max, min) >> 1);
        }

        private long helper(int A, int B) {
            if (B != 0) {
                return ((B & 1) == 1 ? A : 0) + helper(A, B >> 1) << 1;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}