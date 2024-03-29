//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 125 👎 0

package leetcode.editor.cn;

//Java：合并两个排序的链表
public class P剑指_offer_25HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_25HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode preAns = new ListNode();
            ListNode p = l1, q = l2, r = preAns;
            while (p != null && q != null) {
                if (p.val < q.val) {
                    r.next = p;
                    p = p.next;
                } else {
                    r.next = q;
                    q = q.next;
                }
                r = r.next;
            }
            r.next = (p != null ? p : q);
            return preAns.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}