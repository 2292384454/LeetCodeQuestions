//给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 示例 1: 
//
// 
//输入: [1, 2, 2, 3, 1]
//输出: 2
//解释: 
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2: 
//
// 
//输入: [1,2,2,3,1,4,2]
//输出: 6
// 
//
// 注意: 
//
// 
// nums.length 在1到50,000区间范围内。 
// nums[i] 是一个在0到49,999范围内的整数。 
// 
// Related Topics 数组 
// 👍 177 👎 0

package leetcode.editor.cn;

//Java：数组的度
public class P697DegreeOfAnArray {
    public static void main(String[] args) {
        Solution solution = new P697DegreeOfAnArray().new Solution();
        // TO TEST
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findShortestSubArray(int[] nums) {
            //定义了一个50000行3列的二维数组，数组的第0,1,2列分别存储index在nums中出现的次数，index第一次在nums中出现时的下标，index在nums中出现的最大间隔
            int maxNum = Integer.MIN_VALUE;
            for (int x : nums) {
                if (x > maxNum) {
                    maxNum = x;
                }
            }
            int num_info[][] = new int[maxNum + 1][3], i = 0;
            for (int m = 0; m < num_info.length; m++) {
                num_info[m][1] = -1;
            }
            for (int x : nums) {
                num_info[x][0]++;
                if (num_info[x][1] != -1) {
                    num_info[x][2] = (i - num_info[x][1]);
                } else {
                    num_info[x][1] = i;
                }
                i++;
            }
            int maxCount = 0;
            for (int m = 0; m < num_info.length; m++) {
                if (num_info[m][0] > maxCount) {
                    maxCount = num_info[m][0];
                }
            }
            int minInterval = Integer.MAX_VALUE;
            for (int m = 0; m < num_info.length; m++) {
                if (num_info[m][0] == maxCount && num_info[m][2] < minInterval) {
                    minInterval = num_info[m][2];
                }
            }
            return minInterval + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}