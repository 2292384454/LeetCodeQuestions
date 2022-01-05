package leetcode.editor.cn;
//Java：链表随机节点

import java.util.Random;

/**
 * <p>给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点<strong>被选的概率一样</strong>。</p>
 *
 * <p><strong>进阶:</strong><br />
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 * </pre>
 * <div><div>Related Topics</div><div><li>水塘抽样</li><li>链表</li><li>数学</li><li>随机化</li></div></div><p><div><li>👍 141</li><li>👎 0</li></div>
 */
public class P382LinkedListRandomNode {
    public static void main(String[] args) {
        // Solution solution = new P382LinkedListRandomNode().new Solution();
        // TO TEST
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
        ListNode head;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            ListNode cur = head;
            Random r = new Random();
            int count = 0, ret = 0;
            while (cur != null) {
                if (r.nextInt(++count) == 0) {
                    ret = cur.val;
                }
                cur = cur.next;
            }
            return ret;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}