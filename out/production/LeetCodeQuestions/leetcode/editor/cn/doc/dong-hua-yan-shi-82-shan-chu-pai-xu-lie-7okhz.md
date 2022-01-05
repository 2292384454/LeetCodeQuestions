# 题目描述：
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
### 示例:
输入: 1->1->1->2->3
输出: 2->3

# 思路分析：
该题目与题目#83的不同之处是，删除所有重复出现的元素。如示例所示，头结点是1，其后结点和其重复，因此也要删除。这时，用解决83题的思路就不合适了。

因此，需要一个虚拟头结点，然后用变量prev指向该虚拟头结点。这样在删除重复结点之后，剩余的结点就可以挂在prev之后继续考察了。具体步骤我们一起看下。

为了方便演示，我将示例给出的链表删减如下：

![image.png](https://pic.leetcode-cn.com/1611929372-ApwrxX-image.png)


首先，增加虚拟头结点dummyHead，其后继指针指向头结点head。

![image.png](https://pic.leetcode-cn.com/1611929386-vhOwlh-image.png)


变量prev指向虚拟头结点dummyHead，用以将删除重复结点之后剩余的链表部分连接起来。

变量cur指向头结点head，表示当前考察的结点。

![image.png](https://pic.leetcode-cn.com/1611929399-ySKgew-image.png)



然后变量difNode指向cur所指向的结点，用以记录和当前考察结点不同的结点位置。

变量curRepeatNum表示和变量cur指向的结点重复的结点个数，初始值为0。

![image.png](https://pic.leetcode-cn.com/1611929413-oXoJDp-image.png)


这时，变量cur和变量difNode指向的是同一个结点，因此curRepeatNum=1。

![image.png](https://pic.leetcode-cn.com/1611929432-JsRXgX-image.png)


接着，将变量difNode向后移动一个位置，看下一个结点和变量cur指向的结点值是否相等。在这里，变量cur和变量difNode指向的结点值相等，因此curRepeatNum=2。

![image.png](https://pic.leetcode-cn.com/1611929447-dwfwYW-image.png)


接着，将变量difNode继续向后移动一个位置，看下一个结点和变量cur指向的结点值是否相等。在这里，变量cur和变量difNode指向的结点值不相等。

![image.png](https://pic.leetcode-cn.com/1611929493-YLBqOK-image.png)




此时curRepeatNum=2，表示cur指向的结点1在链表中出现了2次。接着要做的是将变量prev指向的结点的后继指针指向变量difNode所指向的结点。这样，将就重复结点1从链表中删除了。

![image.png](https://pic.leetcode-cn.com/1611929506-xutOaq-image.png)


最后，要做的是将变量cur指向difNode所指向的结点，进行下一个结点的去重。

![image.png](https://pic.leetcode-cn.com/1611929520-FUCukK-image.png)

<br>

# 动画演示：

![...eetCode82动画演示完整版.mov](02417f9e-b026-4f64-acc2-aef3909eb8cc)

<br>

# 代码实现：

```java
public ListNode deleteDuplicates(ListNode head) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    ListNode prev = dummyHead;
    ListNode cur = prev.next;
    while (cur != null) {
        int curRepeatNum = 0;
        ListNode difNode = cur;
        // 找到和cur指向的结点值不同的结点
        while (difNode != null && difNode.val == cur.val) {
            curRepeatNum++;
             difNode = difNode.next;
         }

        // 如果curRepeatNum的值大于1，则表示cur指向的结点重复出现了
        if (curRepeatNum > 1) {
             prev.next = difNode;
         }else {
            // cur指向的结点没有重复出现，则将变量prev指向cur所指向的结点
             prev = cur;
         }
         cur = difNode;
     }

     return dummyHead.next;
}
```
<br>
感谢您的阅读，觉得不错还请帮忙点个赞，在此谢过

如有错误欢迎留言指出

更多内容关注公众号「编程狂想曲」查看