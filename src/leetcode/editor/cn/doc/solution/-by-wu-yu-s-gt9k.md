

```java

class Solution {
    ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
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

```