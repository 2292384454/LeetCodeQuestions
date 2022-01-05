//给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。 
//
// 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。 
//
// 以数组形式返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,1,2,2,3]
//输出：[4,0,1,1,3]
//解释： 
//对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。 
//对于 nums[1]=1 不存在比它小的数字。
//对于 nums[2]=2 存在一个比它小的数字：（1）。 
//对于 nums[3]=2 存在一个比它小的数字：（1）。 
//对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
// 
//
// 示例 2： 
//
// 输入：nums = [6,5,4,8]
//输出：[2,1,0,3]
// 
//
// 示例 3： 
//
// 输入：nums = [7,7,7,7]
//输出：[0,0,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 哈希表 
// 👍 142 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：有多少小于当前数字的数字
public class P1365HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] args) {
        Solution solution = new P1365HowManyNumbersAreSmallerThanTheCurrentNumber().new Solution();
        // TO TEST
        int[] result = solution.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3});
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[][] num_index = new int[nums.length][2];//二维数组，第一列记录nums中的num值，第二列记录num在nums中的下标
            int[] result = new int[nums.length];
            //将nums中的数和下标存储到num_index中
            for (int i = 0; i < nums.length; i++) {
                num_index[i][0] = nums[i];
                num_index[i][1] = i;
            }
            //对num_index按照第一列进行排序
            Arrays.sort(num_index, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            for (int i = 0, count = 0; i < num_index.length; i++) {
                count = i;
                while (i + 1 < num_index.length && num_index[i][0] == num_index[i + 1][0]) {
                    result[num_index[i++][1]] = count;
                }
                result[num_index[i][1]] = count;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
