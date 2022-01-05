//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 611 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列 II
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
        int[] array = new int[]{3, 3, 0, 3};
        List<List<Integer>> ans = solution.permuteUnique(array);
        System.out.println("sss");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<Integer> list = new ArrayList<>();
            long[] lNums = new long[nums.length];
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                lNums[i] = nums[i];
            }
            help(lNums, list, nums.length);
            return ans;
        }

        public void help(long[] lNums, List<Integer> list, int count) {
            long[] lNumsCopy = Arrays.copyOf(lNums, lNums.length);
            List<Integer> listCopy = new ArrayList<>(list);
            if (count == 0) {
                ans.add(listCopy);
                return;
            }
            for (int i = 0; i < lNumsCopy.length; i++) {
                while (i + 1 < lNumsCopy.length && lNumsCopy[i] == lNumsCopy[i + 1]) {
                    i++;//跳过重复元素
                }
                long n = lNumsCopy[i];//记录下lNumsCopy[i]的值
                if (n <= Integer.MAX_VALUE) {
                    listCopy.add((int) n);//将lNumsCopy[i]加入列表
                    lNumsCopy[i] = (long) Integer.MAX_VALUE + 1;//删除lNumsCopy[i]
                    help(lNumsCopy, listCopy, count - 1);

                    lNumsCopy[i] = n;//恢复lNumsCopy[i]
                    listCopy = new ArrayList<>(list);//恢复listCopy
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
