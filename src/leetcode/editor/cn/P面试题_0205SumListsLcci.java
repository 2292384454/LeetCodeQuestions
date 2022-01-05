package leetcode.editor.cn;
//Java：链表求和

/**
 * <p>给定两个用链表表示的整数，每个节点包含一个数位。</p>
 *
 * <p>这些数位是反向存放的，也就是个位排在链表首部。</p>
 *
 * <p>编写函数对这两个整数求和，并用链表形式返回结果。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>(7 -&gt; 1 -&gt; 6) + (5 -&gt; 9 -&gt; 2)，即617 + 295
 * <strong>输出：</strong>2 -&gt; 1 -&gt; 9，即912
 * </pre>
 *
 * <p><strong>进阶：</strong>思考一下，假设这些数位是正向存放的，又该如何解决呢?</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>(6 -&gt; 1 -&gt; 7) + (2 -&gt; 9 -&gt; 5)，即617 + 295
 * <strong>输出：</strong>9 -&gt; 1 -&gt; 2，即912
 * </pre>
 * <div><div>Related Topics</div><div><li>递归</li><li>链表</li><li>数学</li></div></div><p><div><li>👍 81</li><li>👎 0</li></div>
 */
public class P面试题_0205SumListsLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0205SumListsLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            int carry = 0;
            ListNode ans = new ListNode();
            ListNode p = l1, q = l2, r = ans;
            while (p != null || q != null) {
                int a = (p == null ? 0 : p.val);
                int b = (q == null) ? 0 : q.val;
                r.next = new ListNode((a + b + carry) % 10);
                carry = (a + b + carry) / 10;
                p = p == null ? null : p.next;
                q = q == null ? null : q.next;
                r = r.next;
            }
            if (carry != 0) {
                r.next = new ListNode(carry);
            }
            return ans.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}