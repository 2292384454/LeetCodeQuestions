//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法 
// 👍 115 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：模拟行走机器人
public class P874WalkingRobotSimulation {
    public static void main(String[] args) {
        Solution solution = new P874WalkingRobotSimulation().new Solution();
        // TO TEST
        int[] commands = new int[]{4, -1, 4, -2, 4};
        int[][] obstacles = new int[][]{{2, 4}};
        System.out.println(solution.robotSim(commands, obstacles));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            HashSet<String> obstacleSet = new HashSet<>();
            //将所有障碍物坐标组合成字符串存入set中方便查询
            for (int[] arr : obstacles) obstacleSet.add(arr[0] + "，" + arr[1]);
            int CurrentDirection = 0, result = 0, x = 0, y = 0;//CurrentDirection为0,1,2,3分别表示"up", "left", "down", "right"方向
            for (int command : commands) {
                if (command == -2)
                    CurrentDirection = (CurrentDirection + 1) % 4;
                else if (command == -1)
                    CurrentDirection = (CurrentDirection + 3) % 4;
                else {
                    int step = 0;
                    while (step < command) {
                        if (CurrentDirection == 0 && !obstacleSet.contains(x + "，" + (y + 1)))
                            y++;
                        else if (CurrentDirection == 1 && !obstacleSet.contains((x - 1) + "，" + y))
                            x--;
                        else if (CurrentDirection == 2 && !obstacleSet.contains(x + "，" + (y - 1)))
                            y--;
                        else if (CurrentDirection == 3 && !obstacleSet.contains((x + 1) + "，" + y))
                            x++;
                        step++;
                    }
                    result = Math.max(result, x * x + y * y);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}