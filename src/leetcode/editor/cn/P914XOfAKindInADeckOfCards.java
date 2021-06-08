//给定一副牌，每张牌上都写着一个整数。 
//
// 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组： 
//
// 
// 每组都有 X 张牌。 
// 组内所有的牌上都写着相同的整数。 
// 
//
// 仅当你可选的 X >= 2 时返回 true。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,4,4,3,2,1]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
// 
//
// 示例 2： 
//
// 输入：[1,1,1,2,2,2,3,3]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 示例 3： 
//
// 输入：[1]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 示例 4： 
//
// 输入：[1,1]
//输出：true
//解释：可行的分组是 [1,1]
// 
//
// 示例 5： 
//
// 输入：[1,1,2,2,2,2]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[2,2]
// 
//
// 
//提示： 
//
// 
// 1 <= deck.length <= 10000 
// 0 <= deck[i] < 10000 
// 
//
// 
// Related Topics 数组 数学 
// 👍 202 👎 0

package leetcode.editor.cn;

//Java：卡牌分组
public class P914XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        Solution solution = new P914XOfAKindInADeckOfCards().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            int[] num_count = new int[10001];//记录每一个数字出现的次数
            for (int x : deck) {
                num_count[x]++;
            }
            int i = 0;
            while (num_count[i] == 0)//找到从小到大第一个出现的数字
            {
                i++;
            }
            int X = num_count[i];
            if (X == 1) {
                return false;
            }
            for (; i < num_count.length; i++) {
                if (num_count[i] == 1) {
                    return false;
                } else {//找到所有出现次数的最大公约数，如果这个最大公约数存在并且大于1就返回true，否则返回false
                    int j = 0;
                    for (j = Math.min(X, num_count[i]); j >= 2; j--) {
                        if (X % j == 0 && num_count[i] % j == 0) {
                            X = j;
                            break;
                        }
                    }
                    if (j == 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}