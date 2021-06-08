//请你编写一个程序来计算两个日期之间隔了多少天。 
//
// 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。 
//
// 
//
// 示例 1： 
//
// 输入：date1 = "2019-06-29", date2 = "2019-06-30"
//输出：1
// 
//
// 示例 2： 
//
// 输入：date1 = "2020-01-15", date2 = "2019-12-31"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 给定的日期是 1971 年到 2100 年之间的有效日期。 
// 
// 👍 31 👎 0

package leetcode.editor.cn;

//Java：日期之间隔几天
public class P1360NumberOfDaysBetweenTwoDates {
    public static void main(String[] args) {
        Solution solution = new P1360NumberOfDaysBetweenTwoDates().new Solution();
        // TO TEST
        System.out.println(solution.daysBetweenDates("2020-01-15", "2019-12-31"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int daysBetweenDates(String date1, String date2) {
            int daycount1 = dayFromBegin(date1), daycount2 = dayFromBegin(date2);
            return Math.abs(dayFromBegin(date1) - dayFromBegin(date2));

        }

        public int dayFromBegin(String date) {
            String[] dateArray = date.split("-");
            int year = new Integer(dateArray[0]), month = new Integer(dateArray[1]), day = new Integer(dateArray[2]);
            int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int result = 0;
            for (int i = 1971; i < year; i++) {
                result += 365;
                if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                    result++;
                }
            }
            for (int i = 0; i < month - 1; i++) {
                result += days[i];
            }
            if (month > 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
                result++;
            }
            result += day;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
