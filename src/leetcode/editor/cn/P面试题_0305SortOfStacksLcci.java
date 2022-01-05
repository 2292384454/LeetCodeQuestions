package leetcode.editor.cn;
//Java：栈排序

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：<code>push</code>、<code>pop</code>、<code>peek</code> 和 <code>isEmpty</code>。当栈为空时，<code>peek</code>&nbsp;返回 -1。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>：
 * [&quot;SortedStack&quot;, &quot;push&quot;, &quot;push&quot;, &quot;peek&quot;, &quot;pop&quot;, &quot;peek&quot;]
 * [[], [1], [2], [], [], []]
 * <strong> 输出</strong>：
 * [null,null,null,1,null,2]
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：
 * [&quot;SortedStack&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;push&quot;, &quot;pop&quot;, &quot;isEmpty&quot;]
 * [[], [], [], [1], [], []]
 * <strong> 输出</strong>：
 * [null,null,null,null,null,true]
 * </pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ol>
 * <li>栈中的元素数目在[0, 5000]范围内。</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>单调栈</li></div></div><p><div><li>👍 39</li><li>👎 0</li></div>
 */
public class P面试题_0305SortOfStacksLcci {
    public static void main(String[] args) {
        SortedStack sortedStack = new P面试题_0305SortOfStacksLcci().new SortedStack();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class SortedStack {
        Deque<Integer> stack;

        public SortedStack() {
            stack = new LinkedList<>();
        }

        public void push(int val) {
            if (!stack.isEmpty() && val > stack.peek()) {
                Deque<Integer> helpStack = new LinkedList<>();
                while (!stack.isEmpty() && stack.peek() < val) {
                    helpStack.push(stack.pop());
                }
                stack.push(val);
                while (!helpStack.isEmpty()) {
                    stack.push(helpStack.pop());
                }
            } else {
                stack.push(val);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        public int peek() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}