package leetcode.editor.cn;
//Java：检查是否区域内所有整数都被覆盖

/**
 * <p>给你一个二维整数数组 <code>ranges</code> 和两个整数 <code>left</code> 和 <code>right</code> 。每个 <code>ranges[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> 表示一个从 <code>start<sub>i</sub></code> 到 <code>end<sub>i</sub></code> 的 <strong>闭区间</strong> 。</p>
 *
 * <p>如果闭区间 <code>[left, right]</code> 内每个整数都被 <code>ranges</code> 中 <strong>至少一个</strong> 区间覆盖，那么请你返回 <code>true</code> ，否则返回 <code>false</code> 。</p>
 *
 * <p>已知区间 <code>ranges[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> ，如果整数 <code>x</code> 满足 <code>start<sub>i</sub> <= x <= end<sub>i</sub></code> ，那么我们称整数<code>x</code> 被覆盖了。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <b>输入：</b>ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * <b>输出：</b>true
 * <b>解释：</b>2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <b>输入：</b>ranges = [[1,10],[10,20]], left = 21, right = 21
 * <b>输出：</b>false
 * <b>解释：</b>21 没有被任何一个区间覆盖。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= ranges.length <= 50</code></li>
 * <li><code>1 <= start<sub>i</sub> <= end<sub>i</sub> <= 50</code></li>
 * <li><code>1 <= left <= right <= 50</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li></div></div><p><div><li>👍 15</li><li>👎 0</li></div>
 */
public class P1893CheckIfAllTheIntegersInARangeAreCovered {
    public static void main(String[] args) {
        Solution solution = new P1893CheckIfAllTheIntegersInARangeAreCovered().new Solution();
        // TO TEST
        int[][] ranges = new int[][]{{36, 50}, {14, 28}, {4, 31}, {24, 37}, {13, 36}, {27, 33}, {23, 32}, {23, 27}, {1, 35}};
        System.out.println(solution.isCovered(ranges, 35, 40));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            // 差分数组
            int[] diff = new int[52];
            for (int[] range : ranges) {
                diff[range[0]]++;
                diff[range[1] + 1]--;
            }
            // 差分数组的前缀和，表示当前数字的出现次数
            int sum = 0;
            for (int i = 0; i < diff.length; i++) {
                sum += diff[i];
                if (i >= left && i <= right && sum <= 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}