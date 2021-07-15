##### 最小的K个数

给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

```java
import java.util.ArrayList;

public class Solution{
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k > input.length || k == 0) return res;
        quickSort(input, res, k, 0, input.length - 1);
        return res;
    }

    private void quickSort(int[] input, ArrayList<Integer> res, int k, int left, int right){
        int start = left;
        int end = right;
        while (left < right) {
            while (left < right && input[right] >= input[start]){
                right--;
            }
            while (left < right && input[left] <= input[end]){
                left++;
            }
            swap(input, left, right);
        }
        swap(input, left, start);
        if(left > k) {
            quickSort(input, res, k, start, left - 1);
        }else if(left < k){
            quickSort(input, res, k, left + 1, end);
        }else{
            for(int m = 0; m < k; m++){
                res.add(input[m]);
            }
        }
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```