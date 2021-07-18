####  删除有序链表中重复的元素-I

删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次

```java
import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head==null||head.next==null){
            return head;
        }
        ListNode current =head;
        while(current!=null){
            ListNode next=current.next;
            //去重
            while(next!=null&&next.val==current.val){
                next=next.next;
            }
            current.next=next;
            current=current.next;
        }
        return head;
    }
}
```