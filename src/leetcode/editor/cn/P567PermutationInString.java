//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 158 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：字符串的排列
public class P567PermutationInString {
    public static void main(String[] args) {
        Solution solution = new P567PermutationInString().new Solution();
        // TO TEST
        boolean result = solution.checkInclusion("ab", "eidbaooo");
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 == 0) return true;//如果s1长度为0，那么一定返回true
            if (len2 < len1) return false;//如果s1长度大于s2长度，那么一定返回false

            //将字符串转化成字符数组，方便后续访问字符降低时间复杂度
            char s1_array[] = s1.toCharArray(), s2_array[] = s2.toCharArray();

            //开始滑动窗口遍历
            for (int start = 0, end = 0; end < len2; end++) {
                //如果s1中不包含end在s2中指向的字符，那么将start移动到end下一个位置，并且end也移动到新的start位置
                if (!(s1.contains(s2.substring(end, end + 1)))) {
                    start = Math.max(start, end + 1);
                    end = start;
                }
                //如果[start,end]范围内的字符个数已经等于s1的长度，那么检测s2在这段范围内的子串是否是s1的排列
                if (end - start + 1 == len1) {
                    if (end < len2) {
                        //如果s2在这段范围内的子串是是s1的排列，返回true，否则将start自增
                        if (permutation(s1, s2.substring(start, end + 1)))
                            return true;
                        else
                            start++;
                    } else//如果end已经超出了s2的范围，则返回false
                        return false;
                }
            }
            return false;
        }

        public boolean permutation(String s1, String s2) {
            int[] letters = new int[26];
            char[] s1_array = s1.toCharArray(), s2_array = s2.toCharArray();
            for (char c : s1_array) {
                letters[c - 'a']++;
            }
            for (char c : s2_array)
                if (--letters[c - 'a'] < 0) {
                    return false;
                }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}