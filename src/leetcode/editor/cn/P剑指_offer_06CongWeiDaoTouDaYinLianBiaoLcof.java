//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 155 👎 0

package leetcode.editor.cn;

//Java：从尾到头打印链表
public class P剑指_offer_06CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_06CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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
        public int[] reversePrint(ListNode head) {
            int len = 0;
            ListNode virualHead = new ListNode();
            virualHead.next = head;
            ListNode p = head;
            //头插法逆转链表并记录长度
            while (p != null) {
                ListNode next = p.next;
                p.next = virualHead.next;
                virualHead.next = p;
                p = next;
                len++;
            }
            int[] ans = new int[len];
            p = virualHead.next;
            for (int i = 0; i < len; i++) {
                ans[i] = p.val;
                p = p.next;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}