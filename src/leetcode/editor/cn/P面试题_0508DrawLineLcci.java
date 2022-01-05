package leetcode.editor.cn;
//Java：绘制直线

import java.util.Arrays;

/**
 * <p>绘制直线。有个单色屏幕存储在一个一维数组中，使得32个连续像素可以存放在一个 int 里。屏幕宽度为<code>w</code>，且<code>w</code>可被32整除（即一个 int 不会分布在两行上），屏幕高度可由数组长度及屏幕宽度推算得出。请实现一个函数，绘制从点<code>(x1, y)</code>到点<code>(x2, y)</code>的水平线。</p>
 *
 * <p>给出数组的长度 <code>length</code>，宽度 <code>w</code>（以比特为单位）、直线开始位置 <code>x1</code>（比特为单位）、直线结束位置 <code>x2</code>（比特为单位）、直线所在行数&nbsp;<code>y</code>。返回绘制过后的数组。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>：length = 1, w = 32, x1 = 30, x2 = 31, y = 0
 * <strong> 输出</strong>：[3]
 * <strong> 说明</strong>：在第0行的第30位到第31为画一条直线，屏幕表示为[0b000000000000000000000000000000011]
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：length = 3, w = 96, x1 = 0, x2 = 95, y = 0
 * <strong> 输出</strong>：[-1, -1, -1]
 * </pre>
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>数学</li></div></div><p><div><li>👍 12</li><li>👎 0</li></div>
 */
public class P面试题_0508DrawLineLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0508DrawLineLcci().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.drawLine(3, 96, 0, 95, 0)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] drawLine(int length, int w, int x1, int x2, int y) {
            int[] res = new int[length];
            for (int i = x1, width = w / 32; i <= x2; i++) {
                res[width * y + (i / 32)] |= (1 << (31 - (i % 32)));
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}