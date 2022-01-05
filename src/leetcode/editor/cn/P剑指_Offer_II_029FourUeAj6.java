package leetcode.editor.cn;
//Java：排序的循环链表

/**
 * <p>给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素&nbsp;<code>insertVal</code> ，使这个列表仍然是循环升序的。</p>
 *
 * <p>给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。</p>
 *
 * <p>如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。</p>
 *
 * <p>如果列表为空（给定的节点是 <code>null</code>），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2019/01/19/example_1_before_65p.jpg" style="height: 149px; width: 250px;" /><br />
 * &nbsp;</p>
 *
 * <pre>
 * <strong>输入：</strong>head = [3,4,1], insertVal = 2
 * <strong>输出：</strong>[3,4,1,2]
 * <strong>解释：</strong>在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
 *
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/01/19/example_1_after_65p.jpg" style="height: 149px; width: 250px;" />
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [], insertVal = 1
 * <strong>输出：</strong>[1]
 * <strong>解释：</strong>列表为空（给定的节点是 <code>null</code>），创建一个循环有序列表并返回这个节点。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1], insertVal = 0
 * <strong>输出：</strong>[1,0]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= Number of Nodes &lt;= 5 * 10^4</code></li>
 * <li><code><font face="monospace">-10^6 &lt;= Node.val &lt;= 10^6</font></code></li>
 * <li><code>-10^6 &lt;=&nbsp;insertVal &lt;= 10^6</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 708&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/">https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/</a></p>
 * <div><div>Related Topics</div><div><li>链表</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_029FourUeAj6 {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_029FourUeAj6().new Solution();
        // TO TEST
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public Node insert(Node head, int insertVal) {
            // 要插入的节点
            Node node = new Node(insertVal);
            // 如果链表为空， node 形成自环后返回
            if (head == null) {
                node.next = node;
                return node;
            }
            // 找到真正的头结点，为了避免所有节点值都相等的情况
            // 回到 head 的时候就返回，把 head 作为真正的头结点
            Node cur = head;
            while (cur.val <= cur.next.val) {
                cur = cur.next;
                if (cur.next == head) {
                    break;
                }
            }
            Node realHead = cur.next;
            // 找到要插入的位置
            if (insertVal >= realHead.val) {
                cur = realHead;
                while (cur.next != realHead && cur.next.val < insertVal) {
                    cur = cur.next;
                }
            }
            // 进行插入
            node.next = cur.next;
            cur.next = node;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}