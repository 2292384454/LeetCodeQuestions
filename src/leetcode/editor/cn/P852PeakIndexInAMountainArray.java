//我们把符合下列属性的数组 A 称作山脉： 
//
// 
// A.length >= 3 
// 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[
//A.length - 1] 
// 
//
// 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.leng
//th - 1] 的 i 的值。 
//
// 
//
// 示例 1： 
//
// 输入：[0,1,0]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[0,2,1,0]
//输出：1 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 10000 
// 0 <= A[i] <= 10^6 
// A 是如上定义的山脉 
// 
//
// 
// Related Topics 二分查找 
// 👍 124 👎 0

package leetcode.editor.cn;

//Java：山脉数组的峰顶索引
public class P852PeakIndexInAMountainArray {
    public static void main(String[] args) {
        Solution solution = new P852PeakIndexInAMountainArray().new Solution();
        // TO TEST
        solution.peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int low = 0, high = arr.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mid > 0 && mid < arr.length - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (mid == arr.length - 1 || arr[mid] > arr[mid + 1]) {
                    high = mid - 1;
                } else if (mid == 0 || arr[mid] > arr[mid - 1]) {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}