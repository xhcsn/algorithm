import java.util.Stack;

/**
 * @Description: 公用常量
 * @Date: 2021/1/4 11:10
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution1
 * @Version: v1.0.0
 * @Author: ccc
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution1{
    public int[] reversePrint(ListNode head){
        int value = 0;
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
            value++;
        }
        int[] list1 = new int[value];
        int i = 0;
        while(!stack.isEmpty()){
            list1[i] = stack.pop();
            i++;
        }
        return list1;
    }
}
