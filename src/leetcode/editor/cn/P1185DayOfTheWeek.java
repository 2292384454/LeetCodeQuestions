//给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。 
//
// 输入为三个整数：day、month 和 year，分别表示日、月、年。 
//
// 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "F
//riday", "Saturday"}。 
//
// 
//
// 示例 1： 
//
// 输入：day = 31, month = 8, year = 2019
//输出："Saturday"
// 
//
// 示例 2： 
//
// 输入：day = 18, month = 7, year = 1999
//输出："Sunday"
// 
//
// 示例 3： 
//
// 输入：day = 15, month = 8, year = 1993
//输出："Sunday"
// 
//
// 
//
// 提示： 
//
// 
// 给出的日期一定是在 1971 到 2100 年之间的有效日期。 
// 
// Related Topics 数组 
// 👍 32 👎 0

package leetcode.editor.cn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Java：一周中的第几天
public class P1185DayOfTheWeek {
    public static void main(String[] args) {
        Solution solution = new P1185DayOfTheWeek().new Solution();
        // TO TEST
        System.out.println(solution.dayOfTheWeek(15, 8, 1993));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String dayOfTheWeek(int day, int month, int year) {
            String[] weekstr = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
            int dayIndex = dayFromBegin(year + "-" + month + "-" + day);
            return weekstr[((dayIndex - 1) % 7 + 5) % 7];//1971年1月1日是星期五
        }

        //计算从1971年1月1日起，date是第几天
        public int dayFromBegin(String date) {
            String[] dateArray = date.split("-");
            int year = new Integer(dateArray[0]), month = new Integer(dateArray[1]), day = new Integer(dateArray[2]);
            int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int result = 0;
            for (int i = 1971; i < year; i++) {
                result += 365;
                if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0))
                    result++;
            }
            for (int i = 0; i < month - 1; i++) {
                result += days[i];
            }
            if (month > 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
                result++;
            result += day;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
