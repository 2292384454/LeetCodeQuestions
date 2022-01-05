package leetcode.editor.cn;
//Java：栈的最小值

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。</p><br><p><strong>示例：</strong><pre>MinStack minStack = new MinStack();<br>minStack.push(-2);<br>minStack.push(0);<br>minStack.push(-3);<br>minStack.getMin();   --> 返回 -3.<br>minStack.pop();<br>minStack.top();      --> 返回 0.<br>minStack.getMin();   --> 返回 -2.</pre></p><div><div>Related Topics</div><div><li>栈</li><li>设计</li></div></div><p><div><li>👍 51</li><li>👎 0</li></div>
 */
public class P面试题_0302MinStackLcci {
    public static void main(String[] args) {
        MinStack minStack = new P面试题_0302MinStackLcci().new MinStack();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        // 存储堆栈元素
        Deque<Integer> Xstack;
        // 存储每一个入栈元素对应的最小值
        Deque<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            Xstack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            Xstack.push(x);
            int min = x;
            if (!minStack.isEmpty()) {
                min = Math.min(min, minStack.peek());
            }
            minStack.push(min);
        }

        public void pop() {
            Xstack.pop();
            minStack.pop();
        }

        public int top() {
            return Xstack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}