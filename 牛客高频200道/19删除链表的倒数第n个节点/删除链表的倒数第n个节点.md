#### 删除链表的倒数第n个节点


给定一个链表，删除链表的倒数第 nn 个节点并返回链表的头指针

```java
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for(int i = 0; i < n; i++)
            first = first.next;
        //如果n的值等于链表的长度,直接返回去掉头结点的链表
        if(first == null)
            return head.next;
        while(first.next != null)   //同时移动两个指针
        {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
}
```