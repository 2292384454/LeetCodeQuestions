package leetcode.editor.cn;
//Java：删除中间节点

/**
 * <p>若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。</p>
 *
 * <p>假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。</p>
 *
 * <p>例如，传入节点 <code>c</code>（位于单向链表 <code>a->b->c->d->e->f</code> 中），将其删除后，剩余链表为 <code>a->b->d->e->f</code></p>
 *
 * <p> </p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>节点 5 （位于单向链表 4->5->1->9 中）
 * <strong>输出：</strong>不返回任何数据，从链表中删除传入的节点 5，使链表变为 4->1->9
 * </pre>
 *
 * <p> </p>
 * <div><div>Related Topics</div><div><li>链表</li></div></div><p><div><li>👍 113</li><li>👎 0</li></div>
 */
public class P面试题_0203DeleteMiddleNodeLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0203DeleteMiddleNodeLcci().new Solution();
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
        public void deleteNode(ListNode node) {
            ListNode pre = null, p = node;
            while (p.next != null) {
                p.val = p.next.val;
                pre = p;
                p = p.next;
            }
            pre.next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}