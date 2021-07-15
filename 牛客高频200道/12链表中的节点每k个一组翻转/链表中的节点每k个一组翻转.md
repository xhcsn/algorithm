#### 链表中的节点每k个一组翻转

将给出的链表中的节点每k个一组翻转，返回翻转后的链表
如果链表中的节点数不是k的倍数，将最后剩下的节点保持原样
你不能更改节点中的值，只能更改节点本身。

```java
import java.util.*;

public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k){
        if(head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, temp;
        int len = 0;

        while(head != null) {
            len++;
            head = head.next;
        }
        for(int i = 0; i < len / k; i++){
            for(int j = 1; j < k; j++){
                //这段的代码有点像是将当前节点的下一个节点变成pre的下一个节点，头插法。正是这个原因所有只要交换k - 1次
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
```