//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 822 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：合并区间
public class P56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
        int[][] intervals = new int[][]{{1, 4}, {2, 3}, {6, 8}, {4, 5}};
        int[][] ans = solution.merge(intervals);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int[][] ans = new int[intervals.length][2];
            int size = 0;
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            ans[size++] = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (ans[size - 1][1] >= intervals[i][0]) {
                    int right = Math.max(ans[size - 1][1], intervals[i][1]);
                    int[] newInterval = new int[]{ans[size - 1][0], right};
                    ans[size - 1] = newInterval;
                } else {
                    ans[size++] = intervals[i];
                }

            }
            return Arrays.copyOf(ans, size);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
