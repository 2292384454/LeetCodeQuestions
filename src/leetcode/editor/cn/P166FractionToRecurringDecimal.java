//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 104 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
// 
//
// 示例 4： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 示例 5： 
//
// 
//输入：numerator = 1, denominator = 5
//输出："0.2"
// 
//
// 
//
// 提示： 
//
// 
// -231 <= numerator, denominator <= 231 - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 
// 👍 225 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：分数到小数
public class P166FractionToRecurringDecimal {
    public static void main(String[] args) {
        Solution solution = new P166FractionToRecurringDecimal().new Solution();
        // TO TEST
        System.out.println(solution.fractionToDecimal(7, -12));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * P166：给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数.
     * <p>
     * 示例 1：
     * 输入：numerator = 1, denominator = 2
     * 输出："0.5"
     * <p>
     * 示例 2：
     * 输入：numerator = 2, denominator = 1
     * 输出："2"
     * <p>
     * 示例 3：
     * 输入：numerator = 2, denominator = 3
     * 输出："0.(6)"
     * <p>
     * 示例 4：
     * 输入：numerator = 4, denominator = 333
     * 输出："0.(012)"
     * <p>
     * 示例 5：
     * 输入：numerator = 1, denominator = 5
     * 输出："0.2"
     * <p>
     * <p>
     * 提示：
     * -2^31 <= numerator, denominator <= 2^31 - 1
     * denominator != 0
     *
     * @author KevinHwang
     */
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            StringBuilder ans = new StringBuilder();
            boolean hasPoint = false;// 记录是否已经添加过小数点，避免重复添加
            long numeratorL = numerator, denominatorL = denominator;// 先把被除数和除数都转成long型，避免溢出
            boolean isNeg = (numeratorL * denominatorL) < 0;//记录是否最终结果为负数
            // 对被除数和除数取绝对值（后续运算都不再考虑符号直到最终结果再添加符号）
            numeratorL = numeratorL < 0 ? -numeratorL : numeratorL;
            denominatorL = denominatorL < 0 ? -denominatorL : denominatorL;
            // map记录所有计算过的除法，寻找循环节。
            // key:计算过的除法的被除数（除数都一样所以只需要记录被除数）；
            // value:该除法的值在结果字符串中开始的位置
            HashMap<Long, Integer> map = new HashMap<>();
            long quo, rem = -1;// 每一次除法的商（quo）和余数（rem），rem初始值只要是非0就行了
            while (rem != 0) {
                if (map.putIfAbsent(numeratorL, ans.length()) == null) {
                    quo = numeratorL / denominatorL;// 计算商
                    rem = numeratorL % denominatorL;// 计算余数
                    map.put(numeratorL, ans.length());// 记录本次除法
                    numeratorL = rem * 10;// 新的被除数为余数*10
                    ans.append(quo);//记录商
                    // 如果这是第一次计算的结果，并且余数还非0，那么需要追加小数点
                    if (!hasPoint && rem != 0) {
                        ans.append(".");
                        hasPoint = true;
                    }
                } else {
                    int value = map.get(numeratorL);
                    ans.insert(value, "(");
                    ans.append(")");
                    break;
                }
            }
            if (isNeg) {
                ans.insert(0, "-");// 修改符号
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
