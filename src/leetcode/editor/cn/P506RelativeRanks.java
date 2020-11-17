//给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal",
// "Silver Medal", "Bronze Medal"）。 
//
// (注：分数越高的选手，排名越靠前。) 
//
// 示例 1: 
//
// 
//输入: [5, 4, 3, 2, 1]
//输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and 
//"Bronze Medal").
//余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。 
//
// 提示: 
//
// 
// N 是一个正整数并且不会超过 10000。 
// 所有运动员的成绩都不相同。 
// 
// 👍 57 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：相对名次
public class P506RelativeRanks {
    public static void main(String[] args) {
        Solution solution = new P506RelativeRanks().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRelativeRanks(int[] nums) {
            if (nums.length == 0) return new String[0];
            int len = nums.length, max_grade = 0, min_grade = 10000;
            for (int x : nums) {
                if (x > max_grade) max_grade = x;
                if (x < min_grade) min_grade = x;
            }
            int num_index[] = new int[(max_grade - min_grade + 1)];
            for (int i = 0; i < len; i++)
                num_index[nums[i] - min_grade] = i;
            Arrays.sort(nums);
            String res[] = new String[len];
            for (int i = 0; i < len; i++) {
                switch (i) {
                    case 0:
                        res[num_index[nums[len - 1 - i] - min_grade]] = "Gold Medal";
                        break;
                    case 1:
                        res[num_index[nums[len - 1 - i] - min_grade]] = "Silver Medal";
                        break;
                    case 2:
                        res[num_index[nums[len - 1 - i] - min_grade]] = "Bronze Medal";
                        break;
                    default:
                        res[num_index[nums[len - 1 - i] - min_grade]] = i + 1 + "";
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}