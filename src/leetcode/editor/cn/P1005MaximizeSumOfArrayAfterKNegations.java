//
// 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选
//择同一个索引 i。） 
//
// 以这种方式修改数组后，返回数组可能的最大和。 
//
// 
//
// 示例 1： 
//
// 输入：A = [4,2,3], K = 1
//输出：5
//解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
// 
//
// 示例 2： 
//
// 输入：A = [3,-1,0,2], K = 3
//输出：6
//解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
// 
//
// 示例 3： 
//
// 输入：A = [2,-3,-1,5,-4], K = 2
//输出：13
//解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= K <= 10000 
// -100 <= A[i] <= 100 
// 
// Related Topics 贪心算法 
// 👍 67 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：K 次取反后最大化的数组和
public class P1005MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new P1005MaximizeSumOfArrayAfterKNegations().new Solution();
        // TO TEST
        int[] A = new int[]{2, -3, -1, 5, -4};
        System.out.println(solution.largestSumAfterKNegations(A, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            int result = 0, min = Integer.MAX_VALUE;
            Arrays.sort(A);//先对数组进行排序
            //从小到大尽可能多地把负数都翻转成正数
            for (int i = 0; K > 0 && i < A.length && A[i] < 0; i++) {
                A[i] = -A[i];
                K--;
            }
            //计算A中所有元素的和，找到翻转负数后A中最小的元素
            for (int x : A) {
                if (x < min)
                    min = x;
                result += x;
            }
            //如果所有的负数都已经被翻转过了，剩下的次数为奇数，那么必然会有一个正数会被翻转，选择最小的正数翻转
            if (K % 2 == 1) {
                result -= 2 * min;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
