//两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。 
//
// 计算一个数组中，任意两个数之间汉明距离的总和。 
//
// 示例: 
//
// 
//输入: 4, 14, 2
//
//输出: 6
//
//解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
//所以答案为：
//HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 
//2 + 2 = 6.
// 
//
// 注意: 
//
// 
// 数组中元素的范围为从 0到 10^9。 
// 数组的长度不超过 10^4。 
// 
// Related Topics 位运算 
// 👍 185 👎 0

package leetcode.editor.cn;

//Java：汉明距离总和
public class P477TotalHammingDistance {
    public static void main(String[] args) {
        Solution solution = new P477TotalHammingDistance().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int ans = 0;
            boolean over = false;// 当剩下的所有数字已经全部为0，就没必要继续比较下去了
            for (int i = 0; !over && i < 32; i++) {
                over = true;
                int count0 = 0, count1 = 0; // 第i 位为0(1)的数字的个数
                for (int j = 0; j < nums.length; j++) {
                    if ((nums[j] & (1 << i)) != 0) {
                        count1++;
                    } else {
                        count0++;
                    }
                    nums[j] &= (~(1 << i));// nums[j]的第i位置0
                    if (nums[j] != 0) over = false;
                }
                ans += count0 * count1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
