package leetcode.editor.cn;
//Java：数字流的秩

import java.util.ArrayList;
import java.util.List;

/**
 * <p>假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：</p>
 *
 * <p>实现 <code>track(int x)</code>&nbsp;方法，每读入一个数字都会调用该方法；</p>
 *
 * <p>实现 <code>getRankOfNumber(int x)</code> 方法，返回小于或等于 x 的值的个数。</p>
 *
 * <p><strong>注意：</strong>本题相对原题稍作改动</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [&quot;StreamRank&quot;, &quot;getRankOfNumber&quot;, &quot;track&quot;, &quot;getRankOfNumber&quot;]
 * [[], [1], [0], [0]]
 * <strong>输出:
 * </strong>[null,0,null,1]
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>x &lt;= 50000</code></li>
 * <li><code>track</code>&nbsp;和&nbsp;<code>getRankOfNumber</code> 方法的调用次数均不超过 2000 次</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>设计</li><li>树状数组</li><li>二分查找</li><li>数据流</li></div></div><p><div><li>👍 20</li><li>👎 0</li></div>
 */
public class P面试题_1010RankFromStreamLcci {
    public static void main(String[] args) {
        StreamRank streamRank = new P面试题_1010RankFromStreamLcci().new StreamRank();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StreamRank {

        public StreamRank() {
            list = new ArrayList<>();
        }

        List<Integer> list;

        public void track(int x) {
            int i = 0;
            int j = list.size() - 1;
            while (i <= j) {
                int m = i + (j - i) / 2;
                if (list.get(m) < x) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }// 寻找第一个比它大的数
            list.add(i, x);// 在其下标处插入x
        }

        public int getRankOfNumber(int x) {
            int i = 0;
            int j = list.size() - 1;
            while (i <= j) {
                int m = i + (j - i) / 2;
                if (list.get(m) > x) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }// 寻找最后一个不大于它的数
            return j + 1;// 下标加1才是元素数目（秩）
        }
    }


/**
 * Your StreamRank object will be instantiated and called as such:
 * StreamRank obj = new StreamRank();
 * obj.track(x);
 * int param_2 = obj.getRankOfNumber(x);
 */
//leetcode submit region end(Prohibit modification and deletion)

}