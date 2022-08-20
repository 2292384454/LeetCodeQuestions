package leetcode.editor.cn;

public class P2243CalculateDigitSumOfAString {
    public static void main(String[] args) {
        Solution solution = new P2243CalculateDigitSumOfAString().new Solution();
        // TO TEST
        String s = "233";
        String ans = solution.digitSum(s, 3);
        System.out.println(ans);
    }

    //Java：计算字符串的数字和
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String digitSum(String s, int k) {
            int len = s.length(), sum = s.charAt(0) - '0';
            if (len <= k) {
                return s;
            }
            StringBuilder ansSb = new StringBuilder();
            for (int i = 1; i < len; i++) {
                if (i % k == 0) {
                    ansSb.append(sum);
                    sum = 0;
                }
                sum += (s.charAt(i) - '0');
            }
            ansSb.append(sum);
            String ans = ansSb.toString();
            return ans.length() <= k ? ans : digitSum(ans, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}