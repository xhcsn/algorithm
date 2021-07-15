#### 寻找第K大

有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。

给定一个整数数组a,同时给定它的大小n和要找的K(1<=K<=n)，请返回第K大的数(包括重复的元素，不用去重)，保证答案存在。


典型的快排或者分治

```java
import java.util.*;

public class Solution {
    public int findKth(int[] a, int n, int K) {
        // write code here
        return findK(a, 0, n - 1, K);
    }
    
    private static int findK(int[] a, int left, int right, int k){
        if(left > right){
            return -1;
        }
        int pivot = partition(a, left, right);
        if(pivot == k - 1){
            return a[pivot];
        }else if(pivot > k - 1){
            return findK(a, left, pivot - 1, k);
        }else{
            return findK(a, pivot + 1, right, k);
        }
    }
    
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
 
        while (left < right) {
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
```