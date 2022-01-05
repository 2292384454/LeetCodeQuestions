package leetcode.editor.cn;
//Java：链表中的两数相加

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>给定两个 <strong>非空链表</strong> <code>l1</code>和 <code>l2</code>&nbsp;来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。</p>
 *
 * <p>可以假设除了数字 0 之外，这两个数字都不会以零开头。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例1：</strong></p>
 *
 * <p><img alt="" src="https://pic.leetcode-cn.com/1626420025-fZfzMX-image.png" style="width: 302px; " /></p>
 *
 * <pre>
 * <strong>输入：</strong>l1 = [7,2,4,3], l2 = [5,6,4]
 * <strong>输出：</strong>[7,8,0,7]
 * </pre>
 *
 * <p><strong>示例2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
 * <strong>输出：</strong>[8,0,7]
 * </pre>
 *
 * <p><strong>示例3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>l1 = [0], l2 = [0]
 * <strong>输出：</strong>[0]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表的长度范围为<code> [1, 100]</code></li>
 * <li><code>0 &lt;= node.val &lt;= 9</code></li>
 * <li>输入数据保证链表代表的数字无前导 0</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 445&nbsp;题相同：<a href="https://leetcode-cn.com/problems/add-two-numbers-ii/">https://leetcode-cn.com/problems/add-two-numbers-ii/</a></p>
 * <div><div>Related Topics</div><div><li>栈</li><li>链表</li><li>数学</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_025LMSNwu {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_025LMSNwu().new Solution();
        // TO TEST
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        System.out.println(solution.addTwoNumbers(l1, l2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> stack1 = new LinkedList<>();
            Deque<Integer> stack2 = new LinkedList<>();
            ListNode p = l1, q = l2;
            while (p != null) {
                stack1.push(p.val);
                p = p.next;
            }
            while (q != null) {
                stack2.push(q.val);
                q = q.next;
            }
            ListNode next = null;
            int carry = 0;
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                int a = stack1.isEmpty() ? 0 : stack1.pop();
                int b = stack2.isEmpty() ? 0 : stack2.pop();
                ListNode node = new ListNode((a + b + carry) % 10);
                node.next = next;
                next = node;
                carry = (a + b + carry) / 10;
            }
            if (carry != 0) {
                ListNode node = new ListNode(carry);
                node.next = next;
                next = node;
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}