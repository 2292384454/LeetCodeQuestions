//给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。 
//
// （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。） 
//
// 示例 1: 
//
// 
//输入: L = 6, R = 10
//输出: 4
//解释:
//6 -> 110 (2 个计算置位，2 是质数)
//7 -> 111 (3 个计算置位，3 是质数)
//9 -> 1001 (2 个计算置位，2 是质数)
//10-> 1010 (2 个计算置位，2 是质数)
// 
//
// 示例 2: 
//
// 
//输入: L = 10, R = 15
//输出: 5
//解释:
//10 -> 1010 (2 个计算置位, 2 是质数)
//11 -> 1011 (3 个计算置位, 3 是质数)
//12 -> 1100 (2 个计算置位, 2 是质数)
//13 -> 1101 (3 个计算置位, 3 是质数)
//14 -> 1110 (3 个计算置位, 3 是质数)
//15 -> 1111 (4 个计算置位, 4 不是质数)
// 
//
// 注意: 
//
// 
// L, R 是 L <= R 且在 [1, 10^6] 中的整数。 
// R - L 的最大值为 10000。 
// 
// Related Topics 位运算 
// 👍 49 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：二进制表示中质数个计算置位
public class P762PrimeNumberOfSetBitsInBinaryRepresentation {
    public static void main(String[] args) {
        Solution solution = new P762PrimeNumberOfSetBitsInBinaryRepresentation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //static final Set<Integer> primNums = new HashSet<Integer>() {{
        final Set<Integer> primNums = new HashSet<Integer>() {{
            add(2);
            add(3);
            add(5);
            add(7);
            add(11);
            add(13);
            add(17);
            add(19);
            add(21);
        }};

        public int countPrimeSetBits(int L, int R) {
            int result = 0;
            for (int i = L; i <= R; i++) {
                if (isPrimeSetBits(i)) {
                    result++;
                }
            }
            return result;
        }

        public boolean isPrimeSetBits(int num) {
            int count = 0;
            while (num > 0) {
                count += (num & 1);
                num = num >>> 1;
            }
            return primNums.contains(count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}