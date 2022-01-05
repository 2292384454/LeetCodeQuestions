package leetcode.editor.cn;
//Java：最小时间差

import java.util.Arrays;
import java.util.List;

/**
 * <p>给定一个 24 小时制（小时:分钟 <strong>&quot;HH:MM&quot;</strong>）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>timePoints = [&quot;23:59&quot;,&quot;00:00&quot;]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>timePoints = [&quot;00:00&quot;,&quot;23:59&quot;,&quot;00:00&quot;]
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= timePoints &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>timePoints[i]</code> 格式为 <strong>&quot;HH:MM&quot;</strong></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 539&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/minimum-time-difference/">https://leetcode-cn.com/problems/minimum-time-difference/</a></p>
 * <div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>字符串</li><li>排序</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_035Five69nqc {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_035Five69nqc().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int size = timePoints.size();
            int[] minutes = new int[size];
            for (int i = 0; i < size; i++) {
                String timePoint = timePoints.get(i);
                int h = Integer.parseInt(timePoint.substring(0, 2));
                int m = Integer.parseInt(timePoint.substring(3));
                minutes[i] = h * 60 + m;
            }
            Arrays.sort(minutes);
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < size; i++) {
                ans = Math.min(ans, (minutes[i] - minutes[i - 1]));
            }
            int sub = minutes[size - 1] - minutes[0];
            ans = Math.min(ans, Math.min(sub, 24 * 60 - sub));
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}