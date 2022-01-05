package leetcode.editor.cn;
//Java：整数转换

/**
 * <p>整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。</p>
 *
 * <p> <strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * <strong> 输出</strong>：2
 * </pre>
 *
 * <p> <strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：A = 1，B = 2
 * <strong> 输出</strong>：2
 * </pre>
 *
 * <p> <strong>提示:</strong></p>
 *
 * <ol>
 * <li>A，B范围在[-2147483648, 2147483647]之间</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>位运算</li></div></div><p><div><li>👍 29</li><li>👎 0</li></div>
 */
public class P面试题_0506ConvertIntegerLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0506ConvertIntegerLcci().new Solution();
        // TO TEST
        System.out.println(solution.convertInteger(826966453, -729934991));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int convertInteger(int A, int B) {
            int temp = A ^ B;
            int ans = 0;
            while (temp != 0) {
                temp &= (temp - 1);
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}