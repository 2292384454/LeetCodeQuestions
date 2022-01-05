package leetcode.editor.cn;
//Java：分割链表

/**
 * <p>编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于&ldquo;右半部分&rdquo;即可，其不需要被置于左右两部分之间。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> head = 3-&gt;5-&gt;8-&gt;5-&gt;10-&gt;2-&gt;1, <em>x</em> = 5
 * <strong>输出:</strong> 3-&gt;1-&gt;2-&gt;10-&gt;5-&gt;5-&gt;8
 * </pre>
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><p><div><li>👍 65</li><li>👎 0</li></div>
 */
public class P面试题_0204PartitionListLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0204PartitionListLcci().new Solution();
        // TO TEST
        System.out.println(solution.partition(new ListNode(new int[]{1, 4, 3, 2, 5, 2}), 3));
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
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return null;
            }
            ListNode v1 = new ListNode(), v2 = new ListNode();
            ListNode p = v1, q = v2;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val < x) {
                    p.next = cur;
                    p = p.next;
                } else {
                    q.next = cur;
                    q = q.next;
                }
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
            }
            p.next = v2.next;
            return v1.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}