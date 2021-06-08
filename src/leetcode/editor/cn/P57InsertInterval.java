//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 105 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 105 
// 
// Related Topics 排序 数组 
// 👍 376 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：插入区间
public class P57InsertInterval {
    public static void main(String[] args) {
        Solution solution = new P57InsertInterval().new Solution();
        // TO TEST
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{2, 3};
        int[][] ans = solution.insert(intervals, newInterval);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] ans = new int[intervals.length + 1][2];
            int insert = -1, count = 0;
            int left = 0, right = intervals.length - 1, mid = 0;
            //找到插入的位置
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (newInterval[0] == intervals[mid][0]) {
                    insert = mid;
                    break;
                } else if (newInterval[0] < intervals[mid][0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (insert != mid) {
                insert = left;
            }

            //插入位置以左直接复制
            for (int i = 0; i < insert; i++) {
                ans[count++] = intervals[i];
            }

            //插入元素
            if (count > 0 && newInterval[0] <= ans[count - 1][1]) {
                ans[count - 1] = new int[]{ans[count - 1][0], Math.max(ans[count - 1][1], newInterval[1])};
            } else {
                ans[count++] = newInterval;
            }

            //插入位置以右
            for (int i = insert; i < intervals.length; i++) {
                if (intervals[i][0] <= ans[count - 1][1]) {
                    ans[count - 1] = new int[]{ans[count - 1][0], Math.max(ans[count - 1][1], intervals[i][1])};
                } else {
                    ans[count++] = intervals[i];
                }
            }

            return Arrays.copyOf(ans, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
