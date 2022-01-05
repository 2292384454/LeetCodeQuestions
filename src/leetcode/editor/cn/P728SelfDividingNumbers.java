//自除数 是指可以被它包含的每一位数除尽的数。 
//
// 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。 
//
// 还有，自除数不允许包含 0 。 
//
// 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。 
//
// 示例 1： 
//
// 
//输入： 
//上边界left = 1, 下边界right = 22
//输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
// 
//
// 注意： 
//
// 
// 每个输入参数的边界满足 1 <= left <= right <= 10000。 
// 
// Related Topics 数学 
// 👍 114 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：自除数
public class P728SelfDividingNumbers {
    public static void main(String[] args) {
        Solution solution = new P728SelfDividingNumbers().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> result = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                if (isSelfDividing(i)) {
                    result.add(i);
                }
            }
            return result;
        }

        public boolean isSelfDividing(int num) {
            boolean result = true;
            int n = num;
            while (n > 0) {
                int temp = n % 10;
                if (temp == 0) {
                    return false;
                } else {
                    result &= (num % (temp) == 0);
                }
                n /= 10;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}