package leetcode.editor.cn;
//Java：三合一

/**
 * <p>三合一。描述如何只用一个数组来实现三个栈。</p>
 *
 * <p>你应该实现<code>push(stackNum, value)</code>、<code>pop(stackNum)</code>、<code>isEmpty(stackNum)</code>、<code>peek(stackNum)</code>方法。<code>stackNum</code>表示栈下标，<code>value</code>表示压入的值。</p>
 *
 * <p>构造函数会传入一个<code>stackSize</code>参数，代表每个栈的大小。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>：
 * [&quot;TripleInOne&quot;, &quot;push&quot;, &quot;push&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;isEmpty&quot;]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * <strong> 输出</strong>：
 * [null, null, null, 1, -1, -1, true]
 * <strong>说明</strong>：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：
 * [&quot;TripleInOne&quot;, &quot;push&quot;, &quot;push&quot;, &quot;push&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;peek&quot;]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * <strong> 输出</strong>：
 * [null, null, null, null, 2, 1, -1, -1]
 * </pre>
 * <div><div>Related Topics</div><div><li>栈</li><li>设计</li><li>数组</li></div></div><p><div><li>👍 35</li><li>👎 0</li></div>
 */
public class P面试题_0301ThreeInOneLcci {
    public static void main(String[] args) {
        TripleInOne tripleInOne = new P面试题_0301ThreeInOneLcci().new TripleInOne(1);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TripleInOne {
        int stackSize;
        int[] stack;
        int[] top;

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            stack = new int[3 * stackSize];
            top = new int[]{-1, stackSize - 1, 2 * stackSize - 1};
        }

        public void push(int stackNum, int value) {
            if (top[stackNum] < (stackNum + 1) * stackSize - 1) {
                stack[++top[stackNum]] = value;
            }
        }

        public int pop(int stackNum) {
            if (top[stackNum] < stackNum * stackSize) {
                return -1;
            } else {
                return stack[top[stackNum]--];
            }
        }

        public int peek(int stackNum) {
            if (top[stackNum] < stackNum * stackSize) {
                return -1;
            } else {
                return stack[top[stackNum]];
            }
        }

        public boolean isEmpty(int stackNum) {
            return top[stackNum] == stackNum * stackSize - 1;
        }
    }

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
//leetcode submit region end(Prohibit modification and deletion)

}