package leetcode.editor.cn;
//Java：水壶问题

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * <p>有两个容量分别为&nbsp;<em>x</em>升 和<em> y</em>升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好&nbsp;<em>z</em>升 的水？</p>
 *
 * <p>如果可以，最后请用以上水壶中的一或两个来盛放取得的&nbsp;<em>z升&nbsp;</em>水。</p>
 *
 * <p>你允许：</p>
 *
 * <ul>
 * <li>装满任意一个水壶</li>
 * <li>清空任意一个水壶</li>
 * <li>从一个水壶向另外一个水壶倒水，直到装满或者倒空</li>
 * </ul>
 *
 * <p><strong>示例 1:</strong> (From the famous <a href="https://www.youtube.com/watch?v=BVtQNK_ZUJg"><em>&quot;Die Hard&quot;</em> example</a>)</p>
 *
 * <pre>输入: x = 3, y = 5, z = 4
 * 输出: True
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>输入: x = 2, y = 6, z = 5
 * 输出: False
 * </pre>
 * <div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>数学</li></div></div><p><div><li>👍 300</li><li>👎 0</li></div>
 */
public class P365WaterAndJugProblem {
    public static void main(String[] args) {
        Solution solution = new P365WaterAndJugProblem().new Solution();
        // TO TEST
        System.out.println(solution.canMeasureWater(2, 6, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // /**
        //  * 常规方法，DFS.
        //  */
        // public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        //     Deque<int[]> stack = new LinkedList<>();
        //     stack.push(new int[]{0, 0});
        //     // 记录访问过的节点
        //     HashSet<Long> visited = new HashSet<>();
        //     visited.add(0L);
        //     while (!stack.isEmpty()) {
        //         int[] cur = stack.pop();
        //         if (cur[0] == targetCapacity || cur[1] == targetCapacity || cur[0] + cur[1] == targetCapacity) {
        //             return true;
        //         }
        //         visited.add((long) cur[0] << 32 | cur[1]);
        //         // 当前状态的 6 个子状态
        //         int[][] states = new int[6][];
        //         // 清空第一个杯子
        //         states[0] = new int[]{0, cur[1]};
        //         // 清空第二个杯子
        //         states[1] = new int[]{cur[0], 0};
        //         // 装满第一个杯子
        //         states[2] = new int[]{jug1Capacity, cur[1]};
        //         // 装满第二个杯子
        //         states[3] = new int[]{cur[0], jug2Capacity};
        //         // 把第一个杯子里的水全部倒进第二个杯子
        //         // 装得下就全部转移，装不下就装满为止
        //         int move = (jug2Capacity - cur[1] - cur[0] >= 0 ? cur[0] : jug2Capacity - cur[1]);
        //         states[4] = new int[]{cur[0] - move, cur[1] + move};
        //         // 把第二个杯子里的水全部倒进第一个杯子
        //         // 装得下就全部转移，装不下就装满为止
        //         move = jug1Capacity - cur[1] - cur[0] >= 0 ? cur[1] : jug1Capacity - cur[0];
        //         states[5] = new int[]{cur[0] + move, cur[1] - move};
        //         for (int[] state : states) {
        //             if (!visited.contains((long) state[0] << 32 | state[1])) {
        //                 stack.push(state);
        //             }
        //         }
        //     }
        //     return false;
        // }

        /**
         * 数学方法.
         */
        public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
            return jug1Capacity + jug2Capacity >= targetCapacity && targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
        }

        /**
         * 求最大公约数.
         */
        private int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}