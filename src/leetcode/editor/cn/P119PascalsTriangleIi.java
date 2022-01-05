//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角 II
public class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            Integer[] temparr = new Integer[rowIndex + 1];
            for (int i = 0; i <= rowIndex; i++) {
                result.add(0);
            }
            for (int i = 0; i <= rowIndex; i++) {
                if (i == 0) {
                    result.set(0, 1);
                } else {
                    result.toArray(temparr);
                    for (int j = 1; j <= i; j++) {
                        result.set(j, temparr[j - 1] + temparr[j]);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}