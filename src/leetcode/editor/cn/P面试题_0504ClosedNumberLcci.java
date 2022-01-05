package leetcode.editor.cn;
//Java：下一个数

import java.util.Arrays;

/**
 * <p>下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。</p>
 *
 * <p> <strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：num = 2（或者0b10）
 * <strong> 输出</strong>：[4, 1] 或者（[0b100, 0b1]）
 * </pre>
 *
 * <p> <strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：num = 1
 * <strong> 输出</strong>：[2, -1]
 * </pre>
 *
 * <p> <strong>提示:</strong></p>
 *
 * <ol>
 * <li><code>num</code>的范围在[1, 2147483647]之间；</li>
 * <li>如果找不到前一个或者后一个满足条件的正数，那么输出 -1。</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>位运算</li></div></div><p><div><li>👍 30</li><li>👎 0</li></div>
 */
public class P面试题_0504ClosedNumberLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0504ClosedNumberLcci().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.findClosedNumbers(2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findClosedNumbers(int num) {
            int[] res = new int[2];
            if (num <= 0 || num >= Integer.MAX_VALUE) {
                res[0] = -1;
                res[1] = -1;
            } else {
                res[0] = getNext(num);
                res[1] = getPrev(num);
            }
            return res;
        }

        // 取得后一个较大的数
        private int getNext(int n) {
            // 计算c0和c1，用于找到最右边非拖尾0的下标p
            int c = n;
            int c0 = 0;
            int c1 = 0;
            while (((c & 1) == 0) && (c != 0)) {
                c0++;
                c >>= 1;
            }
            while ((c & 1) == 1) {
                c1++;
                c >>= 1;
            }

            // 错误：若n=111111...000, 那么就没有更大的数字
            // 如果是n的二进制不存在可翻转的0，或者n就是0
            if (c0 + c1 == 31 || c0 + c1 == 0) {
                return -1;
            }

            int p = c0 + c1; // 前提：最右边，非拖尾0的位置
            n |= (1 << p); // 步骤1：翻转最右边，非拖尾0
            n &= -(1 << p); // 步骤2：将p右方的所有位清零
            n |= (1 << (c1 - 1)) - 1; // 步骤3：在右方插入(c1-1)个1

            return n;
        }

        // 取得前一个较小的数
        private int getPrev(int n) {
            int temp = n;
            int c0 = 0;
            int c1 = 0;
            while ((temp & 1) == 1) {
                c1++;
                temp >>= 1;
            }

            if (temp == 0) return -1;

            while (((temp & 1) == 0) && (temp != 0)) {
                c0++;
                temp >>= 1;
            }

            int p = c0 + c1; // 最右边，非拖尾1的位置
            n &= ((~0) << (p + 1)); // 将位0到位p清零

            int mask = (1 << (c1 + 1)) - 1; // (c1+1)个1
            n |= mask << (c0 - 1);

            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}