package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P1210MinimumMovesToReachTargetWithRotations {
    public static void main(String[] args) {
        Solution solution = new P1210MinimumMovesToReachTargetWithRotations().new Solution();
        // TO TEST
    }

    //Java：穿过迷宫的最少移动次数
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumMoves(int[][] grid) {
            int n = grid.length;
            int[][][] dist = new int[n][n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dist[i][j], -1);
                }
            }
            //dist[x][y][0]记录蛇尾到达(x,y)位置，且蛇是横着的所需要的最少步数(因为只能向右、向下、旋转，所以一旦到达一定是最少步数)
            //dist[x][y][1]记录蛇尾到达(x,y)位置，且蛇是竖着的所需要的最少步数(因为只能向右、向下、旋转，所以一旦到达一定是最少步数)
            //dist[x][y][s]默认值为-1，表示蛇尚未以该姿态到达过该位置
            dist[0][0][0] = 0;
            //queue中的元素 item：item[0]为x,item[1]为y,item[2]记录蛇的状态
            //item[2]=0 表示蛇当前是横着的
            //item[2]=1 表示当前蛇是竖着的
            Queue<int[]> queue = new ArrayDeque<int[]>();
            queue.offer(new int[]{0, 0, 0});
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int x = arr[0], y = arr[1], status = arr[2];
                int curDist = dist[x][y][status];
                if (status == 0) {
                    //向右走
                    if (y + 2 < n && dist[x][y + 1][0] == -1 && grid[x][y + 1] == 0 && grid[x][y + 2] == 0) {
                        dist[x][y + 1][0] = curDist + 1;
                        queue.offer(new int[]{x, y + 1, 0});
                    }
                    //向下走 或者 顺时针旋转
                    if (x + 1 < n && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                        //向下走
                        if (dist[x + 1][y][0] == -1) {
                            dist[x + 1][y][0] = curDist + 1;
                            queue.offer(new int[]{x + 1, y, 0});
                        }
                        //顺时针旋转
                        if (dist[x][y][1] == -1) {
                            dist[x][y][1] = curDist + 1;
                            queue.offer(new int[]{x, y, 1});
                        }
                    }
                } else {
                    //向右走 或者 逆时针旋转
                    if (y + 1 < n && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                        //向右走
                        if (dist[x][y + 1][0] == -1) {
                            dist[x][y + 1][1] = curDist + 1;
                            queue.offer(new int[]{x, y + 1, 1});
                        }
                        //逆时针旋转
                        if (dist[x][y][0] == -1) {
                            dist[x][y][0] = curDist + 1;
                            queue.offer(new int[]{x, y, 0});
                        }
                    }
                    //向下走
                    if (x + 2 < n && dist[x + 1][y][1] == -1 && grid[x + 1][y] == 0 && grid[x + 2][y] == 0) {
                        dist[x + 1][y][1] = curDist + 1;
                        queue.offer(new int[]{x + 1, y, 1});
                    }
                }
            }
            return dist[n - 1][n - 2][0];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}