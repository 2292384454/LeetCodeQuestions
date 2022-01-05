package leetcode.editor.cn;
//Java：翻转数位

/**
 * <p>给定一个32位整数 <code>num</code>，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong> <code>num</code> = 1775(11011101111<sub>2</sub>)
 * <strong>输出:</strong> 8
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入:</strong> <code>num</code> = 7(0111<sub>2</sub>)
 * <strong>输出:</strong> 4
 * </pre>
 * <div><div>Related Topics</div><div><li>位运算</li><li>动态规划</li></div></div><p><div><li>👍 44</li><li>👎 0</li></div>
 */
public class P面试题_0503ReverseBitsLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0503ReverseBitsLcci().new Solution();
        // TO TEST
        System.out.println(solution.reverseBits(1775));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverseBits(int num) {
            // pre[i] 存储第 i-1 位向前连续 1 的个数
            // suf[i] 存储第 i+1 位向后连续 1 的个数
            int[] pre = new int[32], suf = new int[32];
            int mask1 = 1, mask2 = (1 << 31);
            for (int i = 1; i < 32; i++) {
                int bit1 = num & mask1;
                if (bit1 != 0) {
                    pre[i] = pre[i - 1] + 1;
                }
                int bit2 = num & mask2;
                if (bit2 != 0) {
                    suf[31 - i] = suf[32 - i] + 1;
                }
                mask1 <<= 1;
                mask2 >>>= 1;
            }
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                ans = Math.max(ans, pre[i] + suf[i] + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}