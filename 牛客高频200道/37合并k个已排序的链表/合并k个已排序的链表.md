####  合并k个已排序的链表

合并 k 个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。 


```java
//最小堆比较容易实现
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        
        
        for(ListNode node : lists){
            if(node != null){
                pq.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if(minNode.next != null){
                pq.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }
}
```