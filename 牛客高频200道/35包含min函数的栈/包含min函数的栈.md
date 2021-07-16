#### 包含min函数的栈

定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数

```java
import java.util.Stack;

public class Solution {
    
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();
    
    public void push(int node) {
        stack.push(node);
        if(minstack.isEmpty()){
            minstack.push(node);
        }else{
            if(minstack.peek() > node){
                minstack.push(node);
            }else{
                minstack.push(minstack.peek());
            }
        }
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return minstack.peek();
    }
}
```