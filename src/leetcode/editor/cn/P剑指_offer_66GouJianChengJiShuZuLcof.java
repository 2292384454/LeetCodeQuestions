//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 
// 👍 125 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：构建乘积数组
public class P剑指_offer_66GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_66GouJianChengJiShuZuLcof().new Solution();
        // TO TEST
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution.constructArr(a)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            if (a == null || a.length == 0) {
                return new int[0];
            }
            int n = a.length;
            int[] arr1 = new int[n], arr2 = new int[n];
            arr1[0] = 1;
            arr2[n - 1] = 1;
            for (int i = 1; i < n; i++) {
                arr1[i] = arr1[i - 1] * a[i - 1];
            }
            for (int i = n - 2; i >= 0; i--) {
                arr2[i] = arr2[i + 1] * a[i + 1];
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = arr1[i] * arr2[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}