//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 239 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：用两个栈实现队列
public class P剑指_offer_09YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        CQueue cQueue = new P剑指_offer_09YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        //进行插入的栈
        Deque<Integer> stack1;
        //进行删除的栈
        Deque<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            // 如果第二个栈为空，就把第一个栈的所有元素转移到第二个栈，顺序逆转
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            //如果此时第二个栈依旧为空，说明队列空
            if (stack2.isEmpty()) {
                return -1;
            } else {
                //否则就从第二个栈顶pop出要删除的元素，即队头
                return stack2.pop();
            }
        }
    }
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
}