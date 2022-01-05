package leetcode.editor.cn;
//Java：替换隐藏数字得到的最晚时间

/**
 * <p>给你一个字符串 <code>time</code> ，格式为 <code> hh:mm</code>（小时：分钟），其中某几位数字被隐藏（用 <code>?</code> 表示）。</p>
 *
 * <p>有效的时间为 <code>00:00</code> 到 <code>23:59</code> 之间的所有时间，包括 <code>00:00</code> 和 <code>23:59</code> 。</p>
 *
 * <p>替换 <code>time</code> 中隐藏的数字，返回你可以得到的最晚有效时间。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>time = "2?:?0"
 * <strong>输出：</strong>"23:50"
 * <strong>解释：</strong>以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>time = "0?:3?"
 * <strong>输出：</strong>"09:39"
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>time = "1?:22"
 * <strong>输出：</strong>"19:22"
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>time</code> 的格式为 <code>hh:mm</code></li>
 * <li>题目数据保证你可以由输入的字符串生成有效的时间</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><p><div><li>👍 14</li><li>👎 0</li></div>
 */
public class P1736LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        Solution solution = new P1736LatestTimeByReplacingHiddenDigits().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumTime(String time) {
            StringBuilder sb = new StringBuilder();
            // 处理第一个数字
            if (time.charAt(0) == '?' && (time.charAt(1) == '?' || time.charAt(1) <= '3')) {
                sb.append(2);
            } else if (time.charAt(0) == '?') {
                sb.append(1);
            } else {
                sb.append(time.charAt(0));
            }
            // 处理第二个数字
            if (time.charAt(1) == '?' && (time.charAt(0) == '?' || time.charAt(0) == '2')) {
                sb.append(3);
            } else if (time.charAt(1) == '?') {
                sb.append(9);
            } else {
                sb.append(time.charAt(1));
            }
            // 处理冒号
            sb.append(':');
            // 处理第三个数字
            if (time.charAt(3) == '?') {
                sb.append(5);
            } else {
                sb.append(time.charAt(3));
            }
            // 处理第四个数字
            if (time.charAt(4) == '?') {
                sb.append(9);
            } else {
                sb.append(time.charAt(4));
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}