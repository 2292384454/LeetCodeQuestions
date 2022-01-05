//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 259 👎 0

package leetcode.editor.cn;

//Java：验证回文串
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
        String test = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            char array[] = s.toCharArray();
            int len = array.length;
            for (int left = 0, right = len - 1; left <= right; ) {
                // 只考虑字母和数字字符
                if (Character.isLetter(array[left]) || Character.isDigit(array[left])) {
                    while ((!Character.isLetter(array[right])) && (!Character.isDigit(array[right])) && right > left) {
                        right--;
                    }
                    if (Character.toUpperCase(array[left]) != Character.toUpperCase(array[right])) {
                        return false;
                    }
                    right--;
                }
                left++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}