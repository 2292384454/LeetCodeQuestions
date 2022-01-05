//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1059 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(solution.findKthLargest(nums, 4));
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 快排实现在未排序的数组中找到第 k 个最大的元素.
     */
    class Solution {
        Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            return find(nums, k, 0, nums.length - 1);
        }

        // 真正执行查找第k个最大元素的方法，查找范围为nums[left,right]。
        private int find(int[] nums, int k, int left, int right) {
            if (left <= right) {
                int index = partition(nums, left, right);
                if (index == nums.length - k) {
                    return nums[index];
                } else {
                    return index < nums.length - k ? find(nums, k, index + 1, right) : find(nums, k, left, index - 1);
                }
            }
            return -1;
        }

        // 以nums[left,right]范围内随机元素为枢轴，将比它小的都放在它的左边，比它大的都放在它的右边，返回枢轴的最终位置。
        private int partition(int[] nums, int left, int right) {
            int pivotIndex = random.nextInt(right - left + 1) + left;//生成[left,right]范围内的随机整数
            swap(nums, pivotIndex, left);//枢轴值放到left位置
            int pivot = nums[left];
            while (left < right) {
                while (left < right && nums[right] >= pivot) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] <= pivot) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = pivot;
            return left;
        }

        private void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
//    /**
//     * priorityQueue实现堆排
//     */
//    class Solution {
//        public int findKthLargest(int[] nums, int k) {
//            //建立大根堆
//            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, (o1, o2) -> o2 - o1);
//            //将所有元素入堆
//            for (int num : nums) priorityQueue.add(num);
//            //出堆k-1次
//            for (int i = 0; i < k - 1; i++) priorityQueue.poll();
//            //返回堆顶
//            return priorityQueue.peek();
//        }
//    }
//
//    /**
//     * 手动堆排实现在未排序的数组中找到第 k 个最大的元素.
//     */
//    class Solution {
//        public int findKthLargest(int[] nums, int k) {
//            buildsHeap(nums, nums.length); //建立大根堆
//            //出堆k-1次
//            for (int i = nums.length - 1; i > nums.length - k; i--) {
//                swap(nums, 0, i);
//                adjustDown(nums, 0, i);
//            }
//            return nums[0];//返回堆顶
//        }
//
//        //初始化建堆
//        private void buildsHeap(int[] nums, int heapSize) {
//            for (int i = nums.length / 2; i >= 0; i--) {
//                adjustDown(nums, i, heapSize);
//            }
//        }
//
//        //向下调整以i为堆顶的大根堆
//        private void adjustDown(int[] nums, int i, int heapSize) {
//            for (int j = i; j < heapSize; ) {
//                int l = (j << 1) + 1, r = (j << 1) + 2;
//                int maxIndex = (r < heapSize && nums[r] > nums[l]) ? r : l;
//                if (maxIndex < heapSize && nums[maxIndex] > nums[j])
//                    swap(nums, j, maxIndex);
//                j = maxIndex;
//            }
//        }
//
//        private void swap(int[] nums, int l, int r) {
//            int temp = nums[l];
//            nums[l] = nums[r];
//            nums[r] = temp;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}
