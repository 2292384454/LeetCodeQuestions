//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。 
//
// 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。 
//
// 说明: 
//
// 
// 给出的房屋和供暖器的数目是非负数且不会超过 25000。 
// 给出的房屋和供暖器的位置均是非负数且不会超过10^9。 
// 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。 
// 所有供暖器都遵循你的半径标准，加热的半径也一样。 
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3],[2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4],[1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
// Related Topics 二分查找 
// 👍 152 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：供暖器
public class P475Heaters {
    public static void main(String[] args) {
        Solution solution = new P475Heaters().new Solution();
        // TO TEST
        int houses[] = {4, 8, 20, 56}, heaters[] = {1, 2, 3, 4, 5, 78, 52, 45, 36, 22};
        System.out.println(solution.findRadius(houses, heaters));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            if (houses.length == 0 || heaters.length == 0) {
                return 0;
            }
            Arrays.sort(houses);//先对房屋和加热器的位置进行排序
            Arrays.sort(heaters);
            int result = 0;
            for (int i = 0, j = 0; i < houses.length && j < heaters.length; i++) {
                while (j < heaters.length - 1 && houses[i] > heaters[j]) {
                    j++;
                }
                if (j == 0) {
                    result = Math.max(result, Math.abs(heaters[j] - houses[i]));
                } else {
                    result = Math.max(result, Math.min(Math.abs(heaters[j] - houses[i]), Math.abs(houses[i] - heaters[j - 1])));
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}