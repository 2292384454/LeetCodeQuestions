//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法 
// 👍 311 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：复原IP地址
public class P93RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
        // TO TEST
        String testStr = "010010";
        List<String> result = solution.restoreIpAddresses(testStr);
        System.out.printf(result.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            int p1, p2, p3, len = s.length();//三个断点
            String regex = "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";//检测字符串是否合法的正则表达式
            List<String> result = new ArrayList<>();
            if (len < 4 || len > 12) return result;//如果字符串长度小于4或者大于12，就把这个空表返回
            for (p1 = 1; p1 <= 3; p1++)//第一个断点可能的范围是[1,3]
                for (p3 = len - 1; p3 >= Math.max(p1 + 2, len - 3); p3--) {//第三个断点可能的范围是[max(p1 + 2, len - 3),len-1]
                    for (p2 = p1 + 1; p2 < p3; p2++) {//第二个断点可能的范围是[p1+1,p3)。其实这里也可以再仔细考虑一下把这个范围划得更小，但是我觉得对时间性能提升有限，就没有继续划
                        if (p2 - p1 <= 3 && p3 - p2 <= 3) {//如果ip地址中的第二个和第三个数字不超过三位数
                            //将ip地址中的四个数字分别提取出来
                            String num1 = s.substring(0, p1), num2 = s.substring(p1, p2), num3 = s.substring(p2, p3), num4 = s.substring(p3, len);
                            //构建ip字符串
                            String ipString = num1 + "." + num2 + "." + num3 + "." + num4;
                            //如果ip字符串合法就将字符串加入到结果链表中
                            if (ipString.matches(regex))
                                result.add(ipString);
                        }
                    }
                }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}