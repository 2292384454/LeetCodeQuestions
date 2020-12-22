//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 660 👎 0

package leetcode.editor.cn;

import java.util.List;

//Java：三角形最小路径和
public class P120Triangle {
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int high = triangle.size();//三角形的总行数，也是最后一行的元素个数
            int[] currentLength = new int[high];//辅助数组，第i个元素记录循环过程中从顶点到当前层第i个点的最短路径长度（i=0,1,2,...,当前层数，层数从0开始记录）
            currentLength[0] = triangle.get(0).get(0);//辅助数组的第0个元素先置成顶点的值
            for (int i = 1; i < high; i++) {//从第1层遍历到最底层
                currentLength[i] = currentLength[i - 1] + triangle.get(i).get(i);//从顶点到这一层的最右点
                for (int j = i - 1; j > 0; j--) {
                    int len1 = currentLength[j] + triangle.get(i).get(j);
                    int len2 = currentLength[j - 1] + triangle.get(i).get(j);
                    currentLength[j] = Math.min(len1, len2);
                }
                currentLength[0] = currentLength[0] + triangle.get(i).get(0);//从顶点到这一层的最左点
            }
            int result = currentLength[0];
            for (int i = 0; i < high; i++)
                result = Math.min(result, currentLength[i]);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
