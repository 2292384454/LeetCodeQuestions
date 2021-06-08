//给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺
//序）。 
//
// 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。 
//
// 示例: 
//
// 
//输入:
//[[0,0],[1,0],[2,0]]
//
//输出:
//2
//
//解释:
//两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
// Related Topics 哈希表 
// 👍 103 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：回旋镖的数量
public class P447NumberOfBoomerangs {
    public static void main(String[] args) {
        Solution solution = new P447NumberOfBoomerangs().new Solution();
        // TO TEST
        int tsetarray[][] = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(solution.numberOfBoomerangs(tsetarray));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int result = 0;
            for (int i = 0; i < points.length; i++) {
                int anchor[] = points[i];
                HashMap<Integer, Integer> DisSquared_count = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (j != i) {
                        int DisSquared = Distance_squared(anchor, points[j]);
                        int count = DisSquared_count.containsKey(DisSquared) ? DisSquared_count.get(DisSquared) : 0;
                        DisSquared_count.put(DisSquared, count + 1);
                    }
                }
                for (int num : DisSquared_count.values()) {
                    result += (num * (num - 1));
                }
            }
            return result;
        }

        public int Distance_squared(int a[], int b[]) {
            return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}