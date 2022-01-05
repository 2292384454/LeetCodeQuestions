//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 258 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：最小的k个数
public class P剑指_offer_40ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_40ZuiXiaoDeKgeShuLcof().new Solution();
        // TO TEST
        int[] arr = new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr, 8)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            // 使用 PriorityQueue 建立大根堆
            /*
            Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int num : arr) {
                if (queue.size() < k) {
                    queue.add(num);
                } else if (num < queue.peek()) {
                    queue.poll();
                    queue.add(num);
                }
            }
            return Arrays.stream(queue.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
            */

            // 使用自定义的大根堆
            MaxHeap maxHeap = new MaxHeap(k);
            for (int num : arr) {
                if (maxHeap.size < k) {
                    maxHeap.add(num);
                } else if (num < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.add(num);
                }
            }
            return maxHeap.items;
        }

        // 手动实现大根堆
        public class MaxHeap {
            public final int capacity;
            public final int[] items;
            public int size;

            // 指定大小的构造函数
            public MaxHeap(int capacity) {
                this.capacity = capacity;
                items = new int[capacity];
                Arrays.fill(items, Integer.MIN_VALUE);
                size = 0;
            }

            // 插入元素，如果满了就抛出数组越界异常
            public void add(int val) {
                items[size] = val;
                fixUp(size++);
            }

            // 弹出堆顶元素，如果空了就抛出数组越界异常
            public int poll() {
                swap(0, --size);
                fixDown(0);
                return items[size];
            }

            public int peek() {
                return items[0];
            }

            // 较大的下沉
            // 将当前节点与其较小子节点交换
            // 并将更新当前节点为交换的子节点
            private void fixDown(int index) {
                int son = index * 2 + 1;
                while (son < size) {
                    if (son + 1 < size && items[son + 1] > items[son]) {
                        son++;  // 这里这要比较左右孩子谁大
                    }
                    if (items[index] > items[son]) {
                        break;  // 当前节点比孩子节点大，不用下沉退出循环
                    } else {
                        swap(index, son);
                        index = son;
                        son = index * 2 + 1;
                    }
                }
            }

            // 较小的上浮
            // 当前节点与父节点相比，若小于则交换，且将当前节点更新为其父节点
            private void fixUp(int index) {
                int father = (index - 1) / 2;
                while (father >= 0) {
                    if (items[index] <= items[father]) {
                        break;  // 其父节点小于当前节点，不用上浮退出循环
                    } else {
                        swap(index, father);
                        index = father;
                        father = (index - 1) / 2;
                    }
                }
            }

            // 交换 items 中的第 i 和第 j 个元素
            private void swap(int i, int j) {
                int temp = items[i];
                items[i] = items[j];
                items[j] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}