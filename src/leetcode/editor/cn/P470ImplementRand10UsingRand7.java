package leetcode.editor.cn;
//Java：用 Rand7() 实现 Rand10()

import java.util.Random;

/**
 * <p>已有方法&nbsp;<code>rand7</code>&nbsp;可生成 1 到 7 范围内的均匀随机整数，试写一个方法&nbsp;<code>rand10</code>&nbsp;生成 1 到 10 范围内的均匀随机整数。</p>
 *
 * <p>不要使用系统的&nbsp;<code>Math.random()</code>&nbsp;方法。</p>
 *
 * <ol>
 * </ol>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>1
 * <strong>输出: </strong>[7]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>2
 * <strong>输出: </strong>[8,4]
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>3
 * <strong>输出: </strong>[8,1,10]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ol>
 * <li><code>rand7</code>&nbsp;已定义。</li>
 * <li>传入参数:&nbsp;<code>n</code>&nbsp;表示&nbsp;<code>rand10</code>&nbsp;的调用次数。</li>
 * </ol>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶:</strong></p>
 *
 * <ol>
 * <li><code>rand7()</code>调用次数的&nbsp;<a href="https://en.wikipedia.org/wiki/Expected_value" target="_blank">期望值</a>&nbsp;是多少&nbsp;?</li>
 * <li>你能否尽量少调用 <code>rand7()</code> ?</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>数学</li><li>拒绝采样</li><li>概率与统计</li><li>随机化</li></div></div><p><div><li>👍 214</li><li>👎 0</li></div>
 */
public class P470ImplementRand10UsingRand7 {
    public static void main(String[] args) {
        Solution solution = new P470ImplementRand10UsingRand7().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    class Solution {
        public int rand10() {
            Random random = new Random();
            int row, col, idx;
            do {
                row = random.nextInt(7) + 1;
                col = random.nextInt(7) + 1;
                idx = col + (row - 1) * 7;
            } while (idx > 40);
            return 1 + (idx - 1) % 10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}