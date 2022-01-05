package leetcode.editor.cn;

import java.util.*;

public class P502Ipo {
    public static void main(String[] args) {
        Solution solution = new P502Ipo().new Solution();
        // TO TEST
    }

    //Java：IPO
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            // 注意到一个特性，资本是在不断增加的
            int n = profits.length;
            int curr = 0;
            int[][] arr = new int[n][2];

            for (int i = 0; i < n; i++) {
                arr[i][0] = capital[i];
                arr[i][1] = profits[i];
            }
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

            PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
            for (int i = 0; i < k; i++) {
                while (curr < n && arr[curr][0] <= w) {
                    pq.add(arr[curr][1]);
                    curr++;
                }
                if (!pq.isEmpty()) {
                    w += pq.poll();
                } else {
                    break;
                }
            }

            return w;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}