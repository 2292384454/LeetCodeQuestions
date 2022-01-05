//累加数是一个字符串，组成它的数字可以形成累加序列。 
//
// 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。 
//
// 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。 
//
// 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 示例 1: 
//
// 输入: "112358"
//输出: true 
//解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2: 
//
// 输入: "199100199"
//输出: true 
//解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 进阶: 
//你如何处理一个溢出的过大的整数输入? 
// Related Topics 回溯算法 
// 👍 163 👎 0

package leetcode.editor.cn;

//Java：累加数
public class P306AdditiveNumber {
    public static void main(String[] args) {
        Solution solution = new P306AdditiveNumber().new Solution();
        // TO TEST
        System.out.println(solution.isAdditiveNumber("198019823962"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAdditiveNumber(String num) {
            int len = num.length();
            for (int lenOfFirstNum = 1; lenOfFirstNum < len - 1; lenOfFirstNum++) {
                for (int lenOfSecondNum = 1; lenOfSecondNum < len - lenOfFirstNum; lenOfSecondNum++) {
                    if (isAdditiveNumber(num, lenOfFirstNum, lenOfSecondNum)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 根据给定的第一个数和第二个数的长度判断一个数是不是累加数
         *
         * @param num            要判断的数字
         * @param lenOfFirstNum  第一个数的长度
         * @param lenOfSecondNum 第二个数的长度
         * @return num是不是以lenOfFirstNum为第一个数长度，lenOfSecondNum为第二个数长度的累加数
         */
        private boolean isAdditiveNumber(String num, int lenOfFirstNum, int lenOfSecondNum) {
            String firstNum = num.substring(0, lenOfFirstNum);//获取第一个数
            String secondNum = num.substring(lenOfFirstNum, lenOfFirstNum + lenOfSecondNum);//获取第二个数
            //如果第一个数或者第二个数非0但是以0开头，返回false
            if ((firstNum.startsWith("0") && firstNum.length() > 1) || (secondNum.startsWith("0") && secondNum.length() > 1)) {
                return false;
            }
            String tempStr = num.substring(lenOfFirstNum + lenOfSecondNum);//截取除了第一个数和第二个数的其余字符串
            if ("".equals(tempStr)) {
                return true;//如果除了第一个数和第二个数没有其他数字，返回true
            }
            String predictThirdNumStr = addTwoNum(firstNum, secondNum);//计算第三个数的字符串
            //如果第三个数字确实存在于第一个数和第二个数之后，继续判断newNum
            //否则返回false
            if (tempStr.startsWith(predictThirdNumStr)) {
                return isAdditiveNumber(num.substring(lenOfFirstNum), lenOfSecondNum, predictThirdNumStr.length());
            } else {
                return false;
            }
        }

        /**
         * 定义方法实现两个用字符串表示的数字相加，结果也以字符串形式返回
         *
         * @param num1 加数1
         * @param num2 加数1
         * @return num1与num2的和
         */
        private String addTwoNum(String num1, String num2) {
            StringBuilder ans = new StringBuilder();
            int carry = 0;
            int len1 = num1.length(), len2 = num2.length(), maxLen = Math.max(len1, len2);
            for (int i = 0; i < maxLen; i++) {
                int n1 = i < len1 ? num1.charAt(len1 - 1 - i) - '0' : 0;
                int n2 = i < len2 ? num2.charAt(len2 - 1 - i) - '0' : 0;
                int sum = n1 + n2 + carry;
                carry = sum / 10;
                ans.append(sum % 10);
            }
            if (carry > 0) {
                ans.append(carry);
            }
            return ans.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
