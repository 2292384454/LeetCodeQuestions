package leetcode.editor.cn;
//Java：插入

/**
 * <p>给定两个整型数字 <code>N</code> 与 <code>M</code>，以及表示比特位置的 <code>i</code> 与 <code>j</code>（<code>i <= j</code>，且从 0 位开始计算）。</p>
 *
 * <p>编写一种方法，使 <code>M</code> 对应的二进制数字插入 <code>N</code> 对应的二进制数字的第 <code>i ~ j</code> 位区域，不足之处用 <code>0</code> 补齐。具体插入过程如图所示。</p>
 *
 * <p><img alt="" src="https://pic.leetcode-cn.com/1610104070-NuLVQi-05.01.gif" style="width: 267px; height: 200px;" /></p>
 *
 * <p>题目保证从 <code>i</code> 位到 <code>j</code> 位足以容纳 <code>M</code>， 例如： <code>M = 10011</code>，则 <code>i～j</code> 区域至少可容纳 5 位。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 * <strong> 输出</strong>：N = 1100(10001001100)
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>： N = 0, M = 31(11111), i = 0, j = 4
 * <strong> 输出</strong>：N = 31(11111)
 * </pre>
 * <div><div>Related Topics</div><div><li>位运算</li></div></div><p><div><li>👍 34</li><li>👎 0</li></div>
 */
public class P面试题_0501InsertIntoBitsLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0501InsertIntoBitsLcci().new Solution();
        // TO TEST
        System.out.println(solution.insertBits(1143207437, 1017033, 11, 31));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int insertBits(int N, int M, int i, int j) {
            int mShifted = M << i;
            int lowBitsOIfN = N & ((1 << i) - 1);
            int tempN = (N >>> (j + 1));
            // 如果 j==31，那么 tempN不会是0，因为 java 虚拟机会对 32 取余变成 0 再右移 0 位。
            if (j == 31) {
                tempN = 0;
            }
            return (tempN << (j + 1)) | mShifted | lowBitsOIfN;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}