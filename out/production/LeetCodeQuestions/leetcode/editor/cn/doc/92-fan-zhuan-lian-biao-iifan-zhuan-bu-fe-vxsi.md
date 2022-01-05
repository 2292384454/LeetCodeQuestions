### 解题思路
对于待反转的链表段，通过循环的手段操作指针调整其中元素的顺序即可，结合画分析更佳。
进阶题目：[25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/) 参考题解：[25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/25-k-ge-yi-zu-fan-zhuan-lian-biao-by-cel-tcgp/)

### 复杂度分析
- 时间复杂度：O(N)。
- 空间复杂度：O(1)。

### 代码

```java
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //找到正数第left个节点的前驱节点pre
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        //正数第left节点即pre.next
        ListNode cur = pre.next;
        //迭代调换位置
        for(int i = left; i < right; i++){
            ListNode next = cur.next;
            //当前节点的后驱变为当前节点后驱的后驱
            cur.next = next.next;
            //当前节点原后驱节点的后驱指向left位置的前驱的后驱
            next.next = pre.next;
            //left-1位置节点的后驱变为原left位置节点的原后驱
            pre.next = next;
        }
        return dummy.next;
    }
}


```