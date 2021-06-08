//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 
//
// 示例： 
//
// 输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"] 
//
// 
//
// 提示： 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。 
// 
// Related Topics 位运算 回溯算法 
// 👍 161 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二进制手表
public class P401BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new P401BinaryWatch().new Solution();
        // TO TEST
        System.out.println(solution.readBinaryWatch(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        short hournums[][] = new short[][]{{0}, {1, 2, 4, 8}, {3, 5, 6, 9, 10}, {7, 11}};
        short minutenums[][] = new short[][]{{0}, {1, 2, 4, 8, 16, 32}, {3, 5, 6, 9, 10, 12, 17, 18, 20, 24, 33, 34, 36, 40, 48},
                {7, 11, 13, 14, 19, 21, 22, 25, 26, 28, 35, 37, 38, 41, 42, 44, 49, 50, 52, 56},
                {15, 23, 27, 29, 30, 39, 43, 45, 46, 51, 53, 54, 57, 58}, {31, 47, 55, 59}};

        public List<String> readBinaryWatch(int num) {
            List<String> result = new ArrayList<>();
            for (short i = 0; i <= num; i++) {
                if (i < 4 && (num - i) < 6) {
                    for (short x : hournums[i]) {
                        for (short y : minutenums[num - i]) {
                            String minuteString = y < 10 ? "0" + y : y + "";
                            result.add(x + ":" + minuteString);
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}