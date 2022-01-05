//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 链表 
// 👍 225 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：复杂链表的复制
public class P剑指_offer_35FuZaLianBiaoDeFuZhiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_35FuZaLianBiaoDeFuZhiLcof().new Solution();
        // TO TEST
    }


    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            HashMap<Node, Node> map = new HashMap<>();
            Node ans = new Node(head.val);
            map.put(head, ans);
            Node p = ans, q = head;
            while (q.next != null) {
                p.next = new Node(q.next.val);
                p = p.next;
                q = q.next;
                map.put(q, p);
            }
            p = ans;
            q = head;
            while (q != null) {
                p.random = map.get(q.random);
                p = p.next;
                q = q.next;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}