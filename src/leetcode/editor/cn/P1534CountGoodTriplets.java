//给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。 
//
// 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。 
//
// 
// 0 <= i < j < k < arr.length 
// |arr[i] - arr[j]| <= a 
// |arr[j] - arr[k]| <= b 
// |arr[i] - arr[k]| <= c 
// 
//
// 其中 |x| 表示 x 的绝对值。 
//
// 返回 好三元组的数量 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
//输出：4
//解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
// 
//
// 示例 2： 
//
// 输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
//输出：0
//解释：不存在满足所有条件的三元组。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 100 
// 0 <= arr[i] <= 1000 
// 0 <= a, b, c <= 1000 
// 
// Related Topics 数组 
// 👍 16 👎 0

package leetcode.editor.cn;

//Java：统计好三元组
public class P1534CountGoodTriplets {
    public static void main(String[] args) {
        Solution solution = new P1534CountGoodTriplets().new Solution();
        // TO TEST
        int[] arr = new int[]{7, 3, 7, 3, 12, 1, 12, 2, 3};
        System.out.println(solution.countGoodTriplets(arr, 5, 8, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int count = 0;
            for (int i = 0; i < arr.length - 2; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (Math.abs(arr[j] - arr[i]) <= a) {
                        for (int k = j + 1; k < arr.length; k++) {
                            if (Math.abs(arr[k] - arr[j]) <= b && Math.abs(arr[k] - arr[i]) <= c) {
                                count++;
                            }
                        }
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
