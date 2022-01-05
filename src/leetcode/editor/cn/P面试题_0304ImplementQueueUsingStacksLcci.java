package leetcode.editor.cn;
//Java：化栈为队

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>实现一个MyQueue类，该类用两个栈来实现一个队列。</p><br><p><strong>示例：</strong><pre>MyQueue queue = new MyQueue();<br><br>queue.push(1);<br>queue.push(2);<br>queue.peek();  // 返回 1<br>queue.pop();   // 返回 1<br>queue.empty(); // 返回 false</pre></p><br><p><strong>说明：</strong><br><ul><li>你只能使用标准的栈操作 -- 也就是只有 <code>push to top</code>, <code>peek/pop from top</code>, <code>size</code> 和 <code>is empty</code> 操作是合法的。</li><li>你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。</li><li>假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。</li></ul></p><div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>队列</li></div></div><p><div><li>👍 41</li><li>👎 0</li></div>
 */
public class P面试题_0304ImplementQueueUsingStacksLcci {
    public static void main(String[] args) {
        MyQueue solution = new P面试题_0304ImplementQueueUsingStacksLcci().new MyQueue();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            inStack = new LinkedList<>();
            outStack = new LinkedList<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}