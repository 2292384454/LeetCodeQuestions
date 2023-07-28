package leetcode.editor.cn;

import java.util.ArrayList;

public class P1376TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        Solution solution = new P1376TimeNeededToInformAllEmployees().new Solution();
        // TO TEST
        int n = 6, headID = 2;
        int[] manager = {2, 2, -1, 2, 2, 2}, informTime = {0, 0, 1, 0, 0, 0};
        System.out.println(solution.numOfMinutes(n, headID, manager, informTime));
    }

    //Java：通知所有员工所需的时间
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            ArrayList<ArrayList<int[]>> tree = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                if (manager[i] >= 0) {
                    tree.get(manager[i]).add(new int[]{i, informTime[manager[i]]});
                }
            }
            return getMaxDepth(headID, tree);
        }

        public int getMaxDepth(int headID, ArrayList<ArrayList<int[]>> tree) {
            int depth = 0;
            ArrayList<int[]> root = tree.get(headID);
            for (int[] pair : root) {
                depth = Math.max(depth, getMaxDepth(pair[0], tree) + pair[1]);
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}