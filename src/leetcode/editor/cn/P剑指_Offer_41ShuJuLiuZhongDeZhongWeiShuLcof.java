package leetcode.editor.cn;
//Java：数据流中的中位数

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。</p>
 *
 * <p>例如，</p>
 *
 * <p>[2,3,4]&nbsp;的中位数是 3</p>
 *
 * <p>[2,3] 的中位数是 (2 + 3) / 2 = 2.5</p>
 *
 * <p>设计一个支持以下两种操作的数据结构：</p>
 *
 * <ul>
 * <li>void addNum(int num) - 从数据流中添加一个整数到数据结构中。</li>
 * <li>double findMedian() - 返回目前所有元素的中位数。</li>
 * </ul>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：
 * </strong>[&quot;MedianFinder&quot;,&quot;addNum&quot;,&quot;addNum&quot;,&quot;findMedian&quot;,&quot;addNum&quot;,&quot;findMedian&quot;]
 * [[],[1],[2],[],[3],[]]
 * <strong>输出：</strong>[null,null,null,1.50000,null,2.00000]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：
 * </strong>[&quot;MedianFinder&quot;,&quot;addNum&quot;,&quot;findMedian&quot;,&quot;addNum&quot;,&quot;findMedian&quot;]
 * [[],[2],[],[3],[]]
 * <strong>输出：</strong>[null,null,2.00000,null,2.50000]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * <li>最多会对&nbsp;<code>addNum、findMedian</code> 进行&nbsp;<code>50000</code>&nbsp;次调用。</li>
 * </ul>
 *
 * <p>注意：本题与主站 295 题相同：<a href="https://leetcode-cn.com/problems/find-median-from-data-stream/">https://leetcode-cn.com/problems/find-median-from-data-stream/</a></p>
 * <div><div>Related Topics</div><div><li>设计</li><li>双指针</li><li>数据流</li><li>排序</li><li>堆（优先队列）</li></div></div><p><div><li>👍 160</li><li>👎 0</li></div>
 */
public class P剑指_Offer_41ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
        MedianFinder medianFinder = new P剑指_Offer_41ShuJuLiuZhongDeZhongWeiShuLcof().new MedianFinder();
        // TO TEST
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        // 大根堆保存前半部分(如果元素总数为奇数，那么正中间的元素存储在大根堆中)
        private final PriorityQueue<Integer> maxHeap;
        // 小根堆保存后半部分
        private final PriorityQueue<Integer> minHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // 如果 num 应当放在前半部分就插入到大根堆
            // 否则就插入到小根堆
            if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            // 对两个堆的大小进行调整
            // 保证 minHeap.size() <= maxHeap.size() <= minHeap.size() + 1
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            // 如果两个堆不一样大，那么返回大根堆的堆顶
            // 否则返回两个堆顶元素取平均
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek() == null ? 0 : maxHeap.peek();
            } else {
                return (double) ((maxHeap.peek() == null ? 0 : maxHeap.peek()) + (minHeap.peek() == null ? 0 : minHeap.peek())) / 2.0;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}