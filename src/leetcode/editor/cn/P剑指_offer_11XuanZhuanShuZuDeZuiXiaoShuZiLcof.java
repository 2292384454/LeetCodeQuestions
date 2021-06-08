//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 329 👎 0

package leetcode.editor.cn;

//Java：旋转数组的最小数字
public class P剑指_offer_11XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_11XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        // TO TEST
        int[] numbers = new int[]{1, 3, 5};
        System.out.println(solution.minArray(numbers));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minArray(int[] numbers) {
            int n = numbers.length;
            int ans = numbers[0];
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (numbers[low] == numbers[mid]) {
                    ans = Math.min(ans, numbers[mid]);
                    low++;
                } else if (numbers[low] < numbers[mid]) {
                    ans = Math.min(ans, numbers[low]);
                    low = mid + 1;
                } else {
                    ans = Math.min(ans, numbers[mid]);
                    high = mid - 1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}