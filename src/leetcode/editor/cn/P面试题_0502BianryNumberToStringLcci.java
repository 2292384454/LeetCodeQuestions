package leetcode.editor.cn;
//Java：二进制数转字符串

/**
 * <p>二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：0.625
 * <strong> 输出</strong>："0.101"
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：0.1
 * <strong> 输出</strong>："ERROR"
 * <strong> 提示</strong>：0.1无法被二进制准确表示
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * <li>32位包括输出中的"0."这两位。</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数学</li><li>字符串</li></div></div><p><div><li>👍 24</li><li>👎 0</li></div>
 */
public class P面试题_0502BianryNumberToStringLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0502BianryNumberToStringLcci().new Solution();
        // TO TEST
        System.out.println(solution.printBin(0.1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String printBin(double num) {
            StringBuilder ans = new StringBuilder("0.");
            int i = 0;
            for (i = 0; i < 30 && num != 0; i++) {
                int bit = (int) (num * 2);
                ans.append(bit);
                num = num * 2 - bit;
            }
            if (i == 30) {
                return "ERROR";
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}