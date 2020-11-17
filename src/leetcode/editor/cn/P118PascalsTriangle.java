//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

package leetcode.editor.cn;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：杨辉三角
public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        // TO TEST
        List<List<Integer>> result = solution.generate(5);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            if (numRows == 0) return result;
            for (int i = 1; i <= numRows; i++) {
                List<Integer> tempList = new ArrayList<Integer>() {{
                    add(1);
                }};
                if (i > 2) {
                    for (int j = 1; j < i - 1; j++)
                        tempList.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
                }
                if (i > 1)
                    tempList.add(1);
                result.add(tempList);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}