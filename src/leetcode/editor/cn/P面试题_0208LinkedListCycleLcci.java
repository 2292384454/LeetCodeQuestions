package leetcode.editor.cn;
//Java：环路检测

/**
 * <p>给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。</p>
 *
 * <p>如果链表中有某个节点，可以通过连续跟踪 <code>next</code> 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 <code>pos</code> 是 <code>-1</code>，则在该链表中没有环。<strong>注意：<code>pos</code> 不作为参数进行传递</strong>，仅仅是为了标识链表的实际情况。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png" style="height: 97px; width: 300px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [3,2,0,-4], pos = 1
 * <strong>输出：</strong>tail connects to node index 1
 * <strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png" style="height: 74px; width: 141px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1,2], pos = 0
 * <strong>输出：</strong>tail connects to node index 0
 * <strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png" style="height: 45px; width: 45px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1], pos = -1
 * <strong>输出：</strong>no cycle
 * <strong>解释：</strong>链表中没有环。</pre>
 *
 * <p> </p>
 *
 * <p><strong>进阶：</strong></p>
 *
 * <ul>
 * <li>你是否可以不用额外空间解决此题？</li>
 * </ul>
 *
 * <p> </p>
 * <div><div>Related Topics</div><div><li>哈希表</li><li>链表</li><li>双指针</li></div></div><p><div><li>👍 78</li><li>👎 0</li></div>
 */
public class P面试题_0208LinkedListCycleLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0208LinkedListCycleLcci().new Solution();
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
            if (head == null) {
                return null;
            }
            // 快慢指针判断有没有环
            ListNode p = head, q = head.next;
            while (p != null && q != null && q.next != null && p != q) {
                p = p.next;
                q = q.next.next;
            }
            if (p == q) {
                // 如果有环，此时 p 和 q 共同指向环中的同一个节点
                // 把环从此处断开，转成 "链表相交"，找公共节点
                ListNode headB = p.next;
                p.next = null;
                // 先取得两个链表的长度
                int lenA = 0, lenB = 0;
                p = head;
                q = headB;
                while (p != null) {
                    p = p.next;
                    lenA++;
                }
                while (q != null) {
                    q = q.next;
                    lenB++;
                }
                // 转换成 "Y" 形
                ListNode longer = lenA > lenB ? head : headB;
                ListNode shorter = lenA > lenB ? headB : head;
                int sub = Math.abs(lenA - lenB);
                p = longer;
                q = shorter;
                while (sub > 0) {
                    p = p.next;
                    sub--;
                }
                // 同步遍历找公共结点
                while (p != null && q != null) {
                    if (p == q) {
                        return p;
                    }
                    p = p.next;
                    q = q.next;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}