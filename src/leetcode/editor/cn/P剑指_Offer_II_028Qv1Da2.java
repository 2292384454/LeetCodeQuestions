package leetcode.editor.cn;
//Java：展平多级双向链表

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。</p>
 *
 * <p>给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * <strong>输出：</strong>[1,2,3,7,8,11,12,9,10,4,5,6]
 * <strong>解释：
 * </strong>
 * 输入的多级列表如下图所示：
 *
 * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/multilevellinkedlist.png" style="height: 363px; width: 640px;" />
 *
 * 扁平化后的链表如下图：
 *
 * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/multilevellinkedlistflattened.png" style="height: 80px; width: 1100px;" />
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1,2,null,3]
 * <strong>输出：</strong>[1,3,2]
 * <strong>解释：
 *
 * </strong>输入的多级列表如下图所示：
 *
 * 1---2---NULL
 * |
 * 3---NULL
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = []
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>如何表示测试用例中的多级链表？</strong></p>
 *
 * <p>以 <strong>示例 1</strong> 为例：</p>
 *
 * <pre>
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL</pre>
 *
 * <p>序列化其中的每一级之后：</p>
 *
 * <pre>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * </pre>
 *
 * <p>为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。</p>
 *
 * <pre>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * </pre>
 *
 * <p>合并所有序列化结果，并去除末尾的 null 。</p>
 *
 * <pre>
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>节点数目不超过 <code>1000</code></li>
 * <li><code>1 &lt;= Node.val &lt;= 10^5</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 430&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/">https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/</a></p>
 * <div><div>Related Topics</div><div><li>深度优先搜索</li><li>链表</li><li>双向链表</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_028Qv1Da2 {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_028Qv1Da2().new Solution();
        // TO TEST
        Node head = new P剑指_Offer_II_028Qv1Da2().new Node();
        head.val = 1;
        Node ch1 = new P剑指_Offer_II_028Qv1Da2().new Node();
        ch1.val = 2;
        head.child = ch1;
        Node ch2 = new P剑指_Offer_II_028Qv1Da2().new Node();
        ch2.val = 3;
        ch1.child = ch2;
        solution.flatten(head);
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node flatten(Node head) {
            if (head == null) {
                return null;
            }
            Node p = head, pre = null, insertNode;
            Deque<Node> stack = new LinkedList<>();
            while (p != null || !stack.isEmpty()) {
                if (p == null) {
                    pre.next = stack.pop();
                    p = pre.next;
                }
                if (p == null) {
                    break;
                }
                if (p.child != null) {
                    insertNode = flatten(p.child);
                    p.child = null;
                    stack.add(p.next);
                    p.next = insertNode;
                }
                p.prev = pre;
                pre = p;
                p = p.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}