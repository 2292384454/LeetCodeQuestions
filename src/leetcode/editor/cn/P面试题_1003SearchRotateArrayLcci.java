package leetcode.editor.cn;
//Java：搜索旋转数组

/**
 * <p>搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * <strong> 输出</strong>: 8（元素5在该数组中的索引）
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * <strong> 输出</strong>：-1 （没有找到）
 * </pre>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ol>
 * <li>arr 长度范围在[1, 1000000]之间</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><p><div><li>👍 59</li><li>👎 0</li></div>
 */
public class P面试题_1003SearchRotateArrayLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_1003SearchRotateArrayLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] arr, int target) {
            if (arr.length == 0) {
                return -1;//数组长度为0
            }
            if (arr[0] == target) {
                return 0;//数组第一个元素就是target（主要为了防止数组元素全部相等的情况）
            }
            int low = 0, high = arr.length - 1, mid;
            if (arr[low] == arr[high]) {//如果数组刚好第一个元素与最后一个元素相等
                while (high >= 0 && arr[high] == arr[low]) {
                    high--;//就跳过最后的所有与nums[0]相等的元素
                }
            }
            while (low <= high) {
                mid = (high + low) >> 1;
                if (arr[mid] == target) {
                    high = mid;
                }
                // 去右边查找的情况：
                // 1、nums[mid] < target < nums[0]，即当前位置和 target 所处位置都位于最小值右边且 nums[mid] < target
                // 2、target > nums[mid] >= nums[0]，即当前位置和 target 所处位置都位于最小值左边且 nums[mid] < target
                // 3、nums[mid] >= nums[0] && target < nums[0]，即当前位置在最小值左边且 target 所处位置位于最小值右边
                if ((arr[mid] < target && target < arr[0]) || (arr[0] <= arr[mid] && (arr[mid] < target || target < arr[0]))) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return arr[low] == target ? low : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}