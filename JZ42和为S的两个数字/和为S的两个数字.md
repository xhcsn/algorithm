#### 和为S的两个数字

输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，返回两个数的乘积最小的，如果无法找出这样的数字，返回一个空数组即可。

```java
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        //边界条件
        if(array==null||array.length<=1){
            return result;
        }
        int smallIndex=0;
        int bigIndex=array.length-1;
        while(smallIndex<bigIndex){
            //如果相等就放进去
             if((array[smallIndex]+array[bigIndex])==sum){
                result.add(array[smallIndex]);
                result.add(array[bigIndex]);
                 //最外层的乘积最小，别被题目误导
                 break;
        }else if((array[smallIndex]+array[bigIndex])<sum){
                 smallIndex++;
             }else{
                 bigIndex--;
             }
        }
        return result;
    }
}
```