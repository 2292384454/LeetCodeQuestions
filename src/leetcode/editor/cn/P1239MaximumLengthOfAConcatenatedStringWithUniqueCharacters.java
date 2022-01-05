//给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。 
//
// 请返回所有可行解 s 中最长长度。 
//
// 
//
// 示例 1： 
//
// 输入：arr = ["un","iq","ue"]
//输出：4
//解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
// 
//
// 示例 2： 
//
// 输入：arr = ["cha","r","act","ers"]
//输出：6
//解释：可能的解答有 "chaers" 和 "acters"。
// 
//
// 示例 3： 
//
// 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
//输出：26
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 16 
// 1 <= arr[i].length <= 26 
// arr[i] 中只含有小写英文字母 
// 
// Related Topics 位运算 回溯算法 
// 👍 149 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

//Java：串联字符串的最大长度
public class P1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public static void main(String[] args) {
        Solution solution = new P1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
        // TO TEST
        List<String> arr = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p");
        System.out.println(solution.maxLength(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;


        public int maxLength(List<String> arr) {
            int len = arr.size();
            // 用 int 的低 26 位记录 arr.get(i) 中哪些字符出现过
            // 如果字符串 arr.get(i) 自身就包含重复的字符，那么置成 0xFFFFFFFF
            int[] states = new int[len];
            int count = 0;
            for (String s : arr) {
                for (char c : s.toCharArray()) {
                    int bit = (1 << (c - 'a'));
                    if ((states[count] & bit) == 0) {
                        states[count] |= bit;
                    } else {
                        states[count] = Integer.MAX_VALUE;
                    }
                }
                count++;
            }
            // curState 的初值不是 0 而是 1 << 27 是为了保证不会选到自身就包含重复的字符的字符串
            // 即 state 标记为 0xFFFFFFFF 的字符串
            helper(0, 1 << 27, len, states, arr);
            return ans;
        }

        /**
         * 回溯方法
         *
         * @param curLen   传入的结果字符串长度
         * @param curState 传入的结果字符串的状态标记
         * @param len      states 和 arr 的可用长度
         * @param states   所有字符串的状态标记
         * @param arr      所有字符串
         */
        private void helper(int curLen, int curState, int len, int[] states, List<String> arr) {
            if (len == 0) {
                ans = Math.max(ans, curLen);
                return;
            }
            for (int i = len - 1, flag = 1; i >= 0; i--, flag <<= 1) {
                if (((curState & states[i]) == 0)) {
                    // 如果不包含已出现过的字符，当前遍历到的字符串是合法的，添加到结果字符串中
                    helper(curLen + arr.get(i).length(), curState | states[i], i, states, arr);
                } else {
                    // 否则不添加，但是当前字符串对于当前回溯过程不再可用
                    helper(curLen, curState, i, states, arr);
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}