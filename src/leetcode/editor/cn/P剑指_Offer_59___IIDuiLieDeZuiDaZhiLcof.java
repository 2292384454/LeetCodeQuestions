//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 设计 队列 单调队列 
// 👍 253 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//Java：队列的最大值
public class P剑指_Offer_59___IIDuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        MaxQueue maxQueue = new P剑指_Offer_59___IIDuiLieDeZuiDaZhiLcof().new MaxQueue();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {
        Queue<Integer> mainQueue;
        // 辅助队列，单调队列，从队头到队尾不严格单调减
        Deque<Integer> helpQueue;

        public MaxQueue() {
            mainQueue = new LinkedList<>();
            helpQueue = new LinkedList<>();
        }

        public int max_value() {
            if (helpQueue.isEmpty()) {
                return -1;
            }
            return helpQueue.peekFirst();
        }

        public void push_back(int value) {
            while (!helpQueue.isEmpty() && helpQueue.peekLast() < value) {
                helpQueue.pollLast();
            }
            helpQueue.offerLast(value);
            mainQueue.offer(value);
        }

        public int pop_front() {
            if (mainQueue.isEmpty()) {
                return -1;
            }
            int ans = mainQueue.poll();
            if (ans == helpQueue.peekFirst()) {
                helpQueue.pollFirst();
            }
            return ans;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}