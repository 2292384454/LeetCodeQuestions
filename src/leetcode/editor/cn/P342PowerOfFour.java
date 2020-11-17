//给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。 
//
// 示例 1: 
//
// 输入: 16
//输出: true
// 
//
// 示例 2: 
//
// 输入: 5
//输出: false 
//
// 进阶： 
//你能不使用循环或者递归来完成本题吗？ 
// Related Topics 位运算 
// 👍 132 👎 0

package leetcode.editor.cn;

//Java：4的幂
public class P342PowerOfFour {
    public static void main(String[] args) {
        Solution solution = new P342PowerOfFour().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfFour(int num) {
            int temp = 1;
            if (num <= 0) return false;
            return num == temp || num == temp << 2 || num == temp << 4 || num == temp << 6 || num == temp << 8
                    || num == temp << 10 || num == temp << 12 || num == temp << 14 || num == temp << 16 || num == temp << 18
                    || num == temp << 20 || num == temp << 22 || num == temp << 24 || num == temp << 26 || num == temp << 28
                    || num == temp << 30;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}