//猜数字游戏的规则如下： 
//
// 
// 每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。 
// 如果你猜错了，系统会告诉你，你猜测的数字比系统选出的数字是大了还是小了。 
// 
//
// 你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）： 
//
// -1 : 你猜测的数字比系统选出的数字大
// 1 : 你猜测的数字比系统选出的数字小
// 0 : 恭喜！你猜对了！
// 
//
// 
//
// 示例 : 
//
// 输入: n = 10, pick = 6
//输出: 6 
// Related Topics 二分查找 
// 👍 79 👎 0

package leetcode.editor.cn;

//Java：猜数字大小
public class P374GuessNumberHigherOrLower {
    public static void main(String[] args) {
        Solution solution = new P374GuessNumberHigherOrLower().new Solution();
        // TO TEST
    }

    class GuessGame {
        /**
         * Forward declaration of guess API.
         *
         * @param num your guess
         * @return -1 if num is lower than the guess number
         * 1 if num is higher than the guess number
         * otherwise return 0
         */
        int guess(int num) {
            return -1;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1, right = n, mid = left + (right - left) / 2;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (guess(mid) == 0) {
                    return mid;
                } else if (guess(mid) == -1) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}