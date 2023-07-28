package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

public class P862ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        Solution solution = new P862ShortestSubarrayWithSumAtLeastK().new Solution();
        // TO TEST
    }

    //Java：和至少为 K 的最短子数组
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length, ans = n + 1;
            long[] s = new long[n + 1];
            for (var i = 0; i < n; ++i) {
                s[i + 1] = s[i] + nums[i]; // 计算前缀和
            }
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i <= n; ++i) {
                long curS = s[i];
                while (!q.isEmpty() && curS - s[q.peekFirst()] >= k) {
                    ans = Math.min(ans, i - q.pollFirst()); // 优化一
                }
                while (!q.isEmpty() && s[q.peekLast()] >= curS) {
                    q.pollLast(); // 优化二
                }
                q.addLast(i);
            }
            return ans > n ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}