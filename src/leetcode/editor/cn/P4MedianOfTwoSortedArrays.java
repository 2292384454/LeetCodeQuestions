package leetcode.editor.cn;
//Java：寻找两个正序数组的中位数

/**
 * <p>给定两个大小分别为 <code>m</code> 和 <code>n</code> 的正序（从小到大）数组 <code>nums1</code> 和 <code>nums2</code>。请你找出并返回这两个正序数组的 <strong>中位数</strong> 。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [1,3], nums2 = [2]
 * <strong>输出：</strong>2.00000
 * <strong>解释：</strong>合并数组 = [1,2,3] ，中位数 2
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [1,2], nums2 = [3,4]
 * <strong>输出：</strong>2.50000
 * <strong>解释：</strong>合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [0,0], nums2 = [0,0]
 * <strong>输出：</strong>0.00000
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [], nums2 = [1]
 * <strong>输出：</strong>1.00000
 * </pre>
 *
 * <p><strong>示例 5：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [2], nums2 = []
 * <strong>输出：</strong>2.00000
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>nums1.length == m</code></li>
 * <li><code>nums2.length == n</code></li>
 * <li><code>0 <= m <= 1000</code></li>
 * <li><code>0 <= n <= 1000</code></li>
 * <li><code>1 <= m + n <= 2000</code></li>
 * <li><code>-10<sup>6</sup> <= nums1[i], nums2[i] <= 10<sup>6</sup></code></li>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>进阶：</strong>你能设计一个时间复杂度为 <code>O(log (m+n))</code> 的算法解决此问题吗？</p>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>分治</li></div></div><p><div><li>👍 4305</li><li>👎 0</li></div>
 */
public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // // 初步考虑： O(min(nums1.length , nums2.length)) 复杂度
        // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //     // 1、进行交换以使得 nums1.length <= nums2.length
        //     if (nums1.length > nums2.length) {
        //         int[] temp = nums1;
        //         nums1 = nums2;
        //         nums2 = temp;
        //     }
        //     int m = nums1.length, n = nums2.length;
        //     // 中位数左边的所有元素的个数为 (n + m + 1) / 2;
        //     // 这里 +1 是为了考虑到 m+n 为奇数的情况，此时中位数将包含于左半边
        //     int leftCount = (m + n + 1) >> 1;
        //     // nums1 为空的情况单独处理
        //     if (m == 0) {
        //         return (n & 1) == 1 ? nums2[leftCount - 1] : (nums2[leftCount - 1] + nums2[leftCount]) / 2.0;
        //     }
        //     int lCnt1 = 0, lCnt2 = 0;
        //     for (lCnt1 = m; lCnt1 >= 0; lCnt1--) {
        //         lCnt2 = leftCount - lCnt1;
        //         if (lCnt1 <= 0 || lCnt2 >= n || nums1[lCnt1 - 1] <= nums2[lCnt2]) {
        //             break;
        //         }
        //     }
        //     int lCandidate1 = lCnt1 > 0 ? nums1[lCnt1 - 1] : Integer.MIN_VALUE;
        //     int lCandidate2 = lCnt2 > 0 ? nums2[lCnt2 - 1] : Integer.MIN_VALUE;
        //     int candidate = Math.max(lCandidate1, lCandidate2);
        //     if (((m + n) & 1) == 1) {
        //         return candidate;
        //     } else {
        //         int rCandidate1 = lCnt1 < m ? nums1[lCnt1] : Integer.MAX_VALUE;
        //         int rCandidate2 = lCnt2 < n ? nums2[lCnt2] : Integer.MAX_VALUE;
        //         return (candidate + Math.min(rCandidate1, rCandidate2)) / 2.0;
        //     }
        // }

        // 二分查找思路：找 nums1[i] <= nums2[j] 的最后一个 i（i+j=halfCount)，O(log(min(nums1.length , nums2.length)))复杂度
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 1、进行交换以使得 nums1.length <= nums2.length
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }
            int m = nums1.length, n = nums2.length; //m<=n
            int halfCount = (m + n + 1) >> 1;//加1是为了实现向上取整，即halfCount=⌈(m+n)/2⌉。当m+n为奇数时，中位数为第halfCount大的数
            int l = 0, h = m, i = 0, j = 0;
            while (l <= h) {
                i = (l + m) >> 1;
                j = halfCount - i;
                if (nums1[i] > nums2[j]) {
                    h = i - 1;
                } else {
                    l = i + 1;
                }
            }
            return (nums1[i] + nums2[j]) >> 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}