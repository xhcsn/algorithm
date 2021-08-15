#### JZ1 二维数组中的查找
----
在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

```Java
//从左下角的数字开始进行比较，若相等则返回，否则判断当前值与target的值的大小关系，若当前值大于target，row--；若当前值小于target，则col++；

public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length - 1;
        int col = 0;
        while(row >= 0 && col <= array[0].length - 1){
            if(array[row][col] == target){
                return true;
            }else if(array[row][col] > target){
                row--;
            }else{
                col++;
            }
        }
        return false;
    }
}
```


#### JZ2 替换空格
----
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

```Java
//遍历每个字符，如果字符为空格则添加“%20”，否则添加当前字符
import java.util.*;

public class Solution {
    public String replaceSpace (String s) {
        // write code here
        StringBuilder sb = new StringBuilder();
        char[] schar = s.toCharArray();
        for(char c : schar){
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```


#### JZ3 从尾到头打印链表
----
输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。

```Java
//先将链表翻转，再将翻转后的链表打印出来，递归法翻转
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        ListNode newHead = reverse(listNode);
        ListNode cur = newHead;
        while(cur != null){
            ans.add(cur.val);
            cur = cur.next;
        }
        return ans;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

///////////////////////////////////////////////////////////////////////////////
//先将链表翻转，再将翻转后的链表打印出来，迭代法翻转
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        ListNode newHead = ReverseList(listNode);
        ListNode cur = newHead;
        while(cur != null){
            ans.add(cur.val);
            cur = cur.next;
        }
        return ans;
    }
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode reverse = ReverseList(next);
        next.next = head;
        head.next = null;
        return reverse;
    }
}
```

#### JZ4 重建二叉树
----
给定某二叉树的前序遍历和中序遍历，请重建出该二叉树并返回它的头结点。

```Java
import java.util.Arrays;

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        if(pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        int index = 0;
        for(int i = 0; i < vin.length; i++){
            if(pre[0] == vin[i]){
                index = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(vin, 0, index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(vin, index + 1, vin.length));
        return root;
    }
}
```

#### JZ5 用两个栈实现队列
----
用两个栈来实现一个队列，分别完成在队列尾部插入整数(push)和在队列头部删除整数(pop)的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。

```Java
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            if(stack1.isEmpty()){
                return -1;
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());   
                }
            }
        }
        return stack2.pop();
    }
}
```