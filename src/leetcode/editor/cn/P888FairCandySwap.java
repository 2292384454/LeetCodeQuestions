//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。 
//
// 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。） 
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。 
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1], B = [2,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 输入：A = [1,2], B = [2,3]
//输出：[1,2]
// 
//
// 示例 3： 
//
// 输入：A = [2], B = [1,3]
//输出：[2,3]
// 
//
// 示例 4： 
//
// 输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= B.length <= 10000 
// 1 <= A[i] <= 100000 
// 1 <= B[i] <= 100000 
// 保证爱丽丝与鲍勃的糖果总量不同。 
// 答案肯定存在。 
// 
// Related Topics 数组 
// 👍 81 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：公平的糖果交换
public class P888FairCandySwap {
    public static void main(String[] args) {
        Solution solution = new P888FairCandySwap().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            Arrays.sort(A);
            Arrays.sort(B);
            int A_sum = 0, B_sum = 0;
            for (int a : A)
                A_sum += a;
            for (int b : B)
                B_sum += b;
            int[] morePerson = A_sum > B_sum ? A : B;
            int[] lessPerson = A_sum <= B_sum ? A : B;
            int sub = Math.abs(A_sum - B_sum) / 2, big = 0, small = 0;
            //在lessPerson中找比morePerson中元素m小sub的元素lessPerson[l_index]
            for (int m : morePerson) {
                int l_index = Arrays.binarySearch(lessPerson, m - sub);
                if (l_index >= 0) {
                    big = m;
                    small = lessPerson[l_index];
                    break;
                }
            }
            if (morePerson == A)
                return new int[]{big, small};
            else
                return new int[]{small, big};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}