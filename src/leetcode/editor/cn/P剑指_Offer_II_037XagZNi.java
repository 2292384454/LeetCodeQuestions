package leetcode.editor.cn;
//Java：小行星碰撞

import java.util.*;

/**
 * <p>给定一个整数数组 <code>asteroids</code>，表示在同一行的小行星。</p>
 *
 * <p>对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。</p>
 *
 * <p>找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>asteroids = [5,10,-5]
 * <strong>输出：</strong>[5,10]
 * <b>解释：</b>10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>asteroids = [8,-8]
 * <strong>输出：</strong>[]
 * <b>解释：</b>8 和 -8 碰撞后，两者都发生爆炸。</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>asteroids = [10,2,-5]
 * <strong>输出：</strong>[10]
 * <b>解释：</b>2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。</pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>asteroids = [-2,-1,1,2]
 * <strong>输出：</strong>[-2,-1,1,2]
 * <b>解释</b><strong>：</strong>-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。 </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= asteroids.length&nbsp;&lt;= 10<sup>4</sup></code></li>
 * <li><code>-1000 &lt;= asteroids[i] &lt;= 1000</code></li>
 * <li><code>asteroids[i] != 0</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 735&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/asteroid-collision/">https://leetcode-cn.com/problems/asteroid-collision/</a></p>
 * <div><div>Related Topics</div><div><li>栈</li><li>数组</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_037XagZNi {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_037XagZNi().new Solution();
        // TO TEST
        int[] asteroids = new int[]{10, 2, -5};
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new LinkedList<>();
            for (int asteroid : asteroids) {
                // 循环判断 boom
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }
                // 一起 boom
                if (!stack.isEmpty() && asteroid < 0 && stack.peek() == -asteroid) {
                    stack.pop();
                }
                // push
                else if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
            ArrayList<Integer> list = new ArrayList<>(stack);
            Collections.reverse(list);
            return Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}