//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找

package leetcode.editor.cn;

//Java：x 的平方根
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
        // TO TEST
        for (int i = 0; i < 50; i++)
            System.out.println(i + "的运算结果是：" + solution.mySqrt(i) + "，实际结果是：" + (int) Math.sqrt(i));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            long result = 0;//最终结果
            long left = 0, right = x / 2 + 1, mid = (left + right) / 2;//二分查找初始值，运用了关系式sqrt(x)<x/2+1，定义成long类型防止溢出
            while (left <= right) {
                mid = (left + right) / 2;
                if (mid * mid < x)
                    left = mid + 1;
                else if (mid * mid > x)
                    right = mid - 1;
                else
                    return (int) mid;
            }
            return (int) (left - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}