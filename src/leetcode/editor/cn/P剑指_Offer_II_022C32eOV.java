package leetcode.editor.cn;
//Java：链表中环的入口节点

/**
 * <p>给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 <code>next</code> 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回&nbsp;<code>null</code>。</p>
 *
 * <p>为了表示给定链表中的环，我们使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 <code>pos</code> 是 <code>-1</code>，则在该链表中没有环。<strong>注意，<code>pos</code> 仅仅是用于标识环的情况，并不会作为参数传递到函数中。</strong></p>
 *
 * <p><strong>说明：</strong>不允许修改给定的链表。</p>
 *
 * <ul>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png" style="height: 97px; width: 300px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [3,2,0,-4], pos = 1
 * <strong>输出：</strong>返回索引为 1 的链表节点
 * <strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
 * </pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png" style="height: 74px; width: 141px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1,2], pos = 0
 * <strong>输出：</strong>返回索引为 0 的链表节点
 * <strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png" style="height: 45px; width: 45px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1], pos = -1
 * <strong>输出：</strong>返回 null
 * <strong>解释：</strong>链表中没有环。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表中节点的数目范围在范围 <code>[0, 10<sup>4</sup>]</code> 内</li>
 * <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * <li><code>pos</code> 的值为 <code>-1</code> 或者链表中的一个有效索引</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>是否可以使用 <code>O(1)</code> 空间解决此题？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 142&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/">https://leetcode-cn.com/problems/linked-list-cycle-ii/</a></p>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>链表</li><li>双指针</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_022C32eOV {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_022C32eOV().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            //快慢指针
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null && slow != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
            if (fast == null || fast.next == null || slow == null) {
                return null;
            }
            //到这里之后fast（slow）指向环中同一个节点，如果把环从这里断开，那么就转换成了找两个找到两个单链表相交的起始节点(leetcode160题)
            ListNode head2 = fast.next, ptr;
            //如果把环从fast(slow)断开后两个链表的长度
            int len1 = 0, len2 = 0;
            ptr = head;
            while (ptr != head2) {
                len1++;
                ptr = ptr.next;
            }
            ptr = head2.next;
            len2++;
            while (ptr != head2) {
                len2++;
                ptr = ptr.next;
            }
            //longList指向较长的链表（如果断开）
            ListNode longList = len1 > len2 ? head : head2;
            ListNode shortList = len1 <= len2 ? head : head2;
            ptr = longList;
            int n = Math.abs(len1 - len2);
            while (n > 0) {
                ptr = ptr.next;
                n--;
            }
            while (ptr != shortList) {
                ptr = ptr.next;
                shortList = shortList.next;
            }
            return ptr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}