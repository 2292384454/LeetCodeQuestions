package leetcode.editor.cn;
//Java：堆盘子

import java.util.ArrayList;

/**
 * <p>堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构<code>SetOfStacks</code>，模拟这种行为。<code>SetOfStacks</code>应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，<code>SetOfStacks.push()</code>和<code>SetOfStacks.pop()</code>应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个<code>popAt(int index)</code>方法，根据指定的子栈，执行pop操作。</p>
 *
 * <p>当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，<code>pop</code>，<code>popAt</code>&nbsp;应返回 -1.</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>：
 * [&quot;StackOfPlates&quot;, &quot;push&quot;, &quot;push&quot;, &quot;popAt&quot;, &quot;pop&quot;, &quot;pop&quot;]
 * [[1], [1], [2], [1], [], []]
 * <strong> 输出</strong>：
 * [null, null, null, 2, 1, -1]
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：
 * [&quot;StackOfPlates&quot;, &quot;push&quot;, &quot;push&quot;, &quot;push&quot;, &quot;popAt&quot;, &quot;popAt&quot;, &quot;popAt&quot;]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * <strong> 输出</strong>：
 * [null, null, null, null, 2, 1, 3]
 * </pre>
 * <div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>链表</li></div></div><p><div><li>👍 21</li><li>👎 0</li></div>
 */
public class P面试题_0303StackOfPlatesLcci {
    public static void main(String[] args) {
        // TO TEST
        StackOfPlates stack = new P面试题_0303StackOfPlatesLcci().new StackOfPlates(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.popAt(0));
        System.out.println(stack.popAt(0));
        System.out.println(stack.popAt(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StackOfPlates {
        int cap;
        ArrayList<int[]> stacks;
        ArrayList<Integer> tops;

        public StackOfPlates(int cap) {
            this.cap = cap;
            stacks = new ArrayList<>();
            tops = new ArrayList<>();
        }

        public void push(int val) {
            // 如果堆栈大小为 0 ，直接返回
            if (cap == 0) {
                return;
            }
            // 要操作的堆栈
            int[] curStack;
            if (stacks.size() == 0 || tops.get(tops.size() - 1) == cap - 1) {
                // 如果当前堆栈顺序表为空或者堆栈链表中最后一个堆栈满了，就新增一个堆栈
                curStack = new int[cap];
                stacks.add(curStack);
                tops.add(-1);
            } else {
                // 否则取堆栈顺序表中最后一个堆栈进行操作
                curStack = stacks.get(stacks.size() - 1);
            }
            int top = tops.get(tops.size() - 1);
            curStack[++top] = val;
            tops.set(tops.size() - 1, top);

        }

        public int pop() {
            // 要操作的堆栈
            int[] curStack;
            if (stacks.size() == 0) {
                // 如果堆栈顺序表为空返回 -1
                return -1;
            } else {
                // 否则取堆栈顺序表中最后一个堆栈进行操作
                int index = stacks.size() - 1;
                curStack = stacks.get(index);
                int top = tops.get(index);
                tops.set(index, top - 1);
                // 如果出栈后堆栈空了，就删除之
                if (top == 0) {
                    stacks.remove(index);
                    tops.remove(index);
                }
                return curStack[top];
            }
        }

        public int popAt(int index) {
            // 要操作的堆栈
            int[] curStack;
            if (index >= stacks.size()) {
                // 如果指定堆栈不存在
                return -1;
            } else {
                if (tops.get(index) == -1) {
                    return -1;
                }
                curStack = stacks.get(index);
                int top = tops.get(index);
                tops.set(index, top - 1);
                // 如果出栈后堆栈空了，就删除之
                if (top == 0) {
                    stacks.remove(index);
                    tops.remove(index);
                }
                return curStack[top];
            }
        }
    }

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}