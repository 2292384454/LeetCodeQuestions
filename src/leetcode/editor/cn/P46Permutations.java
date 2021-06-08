//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1159 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> list = new ArrayList<>();
            long[] lNums = new long[nums.length];
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
