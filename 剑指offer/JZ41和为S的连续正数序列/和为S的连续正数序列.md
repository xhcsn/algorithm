#### 和为S的连续正数序列

小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? 

```java

//滑动窗口
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resp = new ArrayList<>();
        if(sum <= 0){
            return resp;
        }
        int leftP = 1;
        int rightP = 2;
        int sumVal = leftP + rightP;
 
        while(sum > rightP){
            if(sumVal < sum){
                rightP++;
                sumVal += rightP;
            } else if (sumVal > sum){
                sumVal -= leftP;
                leftP++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=leftP; i<=rightP; i++) {
                    list.add(i);
                }
                resp.add(list);
 
                rightP++;
                sumVal += rightP;
            }
        }
 
        return resp;
 
    }
}
```