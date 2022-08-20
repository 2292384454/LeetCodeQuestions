package leetcode.editor.cn;

import java.util.HashMap;

public class P2244MinimumRoundsToCompleteAllTasks {
    public static void main(String[] args) {
        Solution solution = new P2244MinimumRoundsToCompleteAllTasks().new Solution();
        // TO TEST
        int[] tasks = new int[]{5, 5, 5, 5};
        System.out.println(solution.minimumRounds(tasks));
    }

    //Java：完成所有任务需要的最少轮数
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumRounds(int[] tasks) {
            HashMap<Integer, Integer> taskTimes = new HashMap<>();
            int ans = 0;
            for (int task : tasks) {
                int time = taskTimes.getOrDefault(task, 0);
                if (time != 0 && (time == 1 || time % 3 == 0)) {
                    ans++;
                }
                taskTimes.put(task, time + 1);
            }
            for (int time : taskTimes.values()) {
                if (time == 1) {
                    return -1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}