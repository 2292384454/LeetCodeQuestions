//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
//
// 
//
// 注意： 
//
// 你可以假设两个字符串均只含有小写字母。 
//
// canConstruct("a", "b") -> false
//canConstruct("aa", "ab") -> false
//canConstruct("aa", "aab") -> true
// 
// Related Topics 字符串 
// 👍 110 👎 0

package leetcode.editor.cn;

//Java：赎金信
public class P383RansomNote {
    public static void main(String[] args) {
        Solution solution = new P383RansomNote().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            char ran[] = ransomNote.toCharArray(), mag[] = magazine.toCharArray();
            int char_count[] = new int[26], ran_len = ransomNote.length(), mag_len = magazine.length(), max_len = Math.max(ran_len, mag_len);
            for (int i = 0; i < max_len; i++) {
                if (i < ran_len) char_count[ran[i] - 'a']--;
                if (i < mag_len) char_count[mag[i] - 'a']++;
            }
            for (char x : ran)
                if (char_count[x - 'a'] < 0) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}