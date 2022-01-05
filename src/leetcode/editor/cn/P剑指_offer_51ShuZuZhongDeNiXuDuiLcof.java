//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 446 👎 0

package leetcode.editor.cn;

//Java：数组中的逆序对
public class P剑指_offer_51ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_51ShuZuZhongDeNiXuDuiLcof().new Solution();
        // TO TEST
        int[] nums = new int[]{6, 5, 10, 3, 7, 4, 12, 2};
        System.out.println(solution.reversePairs(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public int reversePairs(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return 0;
            }
            // 拷贝，防止修改原数组
            int[] copy = new int[len];
            System.arraycopy(nums, 0, copy, 0, len);

            int[] temp = new int[len];
            return reversePairs(copy, 0, len - 1, temp);
        }

        /**
         * 计算逆序对数量
         */
        private int reversePairs(int[] nums, int left, int right, int[] temp) {
            if (left == right) {
                return 0;
            }
            int mid = left + (right - left) / 2;
            // 分治法，单独考虑左半边或者右半边，计算逆序对数量
            int leftPairs = reversePairs(nums, left, mid, temp);
            int rightPairs = reversePairs(nums, mid + 1, right, temp);

            // 一方面综合考虑左半边与右半边的 「相对逆序对」 数量，即左半边的数字与右半边的数字组成的逆序对的数量；
            // 另一方面做归并排序，从小到大排序
            if (nums[mid] <= nums[mid + 1]) {
                return leftPairs + rightPairs;
            }
            int crossPairs = mergeAndCount(nums, left, mid, right, temp);
            return leftPairs + rightPairs + crossPairs;
        }

        private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
            if (right + 1 - left >= 0)
                System.arraycopy(nums, left, temp, left, right + 1 - left);
            int i = left, j = mid + 1, index = left;
            int count = 0;

            while (i <= mid && j <= right) {
                if (temp[i] <= temp[j]) {
                    nums[index++] = temp[i++];
                } else {
                    count += (mid - i + 1);
                    nums[index++] = temp[j++];
                }
            }
            if (i <= mid) {
                System.arraycopy(temp, i, nums, index, mid + 1 - i);
            }
            if (j <= right) {
                System.arraycopy(temp, j, nums, index, right + 1 - j);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}