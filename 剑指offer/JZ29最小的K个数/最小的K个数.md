#### 最小的K个数

给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

```java
import java.util.ArrayList;

public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);
        //根据题意要求，如果K>数组的长度，返回一个空的数组
        if (k > input.length || k == 0)
            return res;
        quickSort(input, res, k, 0, input.length - 1);
        return res;
    }

    private void quickSort(int[] input, ArrayList<Integer> res, int k, int left, int right) {
        //快排的实现方式有多种，我们选择了其中的一种
        int start = left;
        int end = right;
        while (left < right) {
            while (left < right && input[right] >= input[start]) {
                right--;
            }
            while (left < right && input[left] <= input[start]) {
                left++;
            }
            swap(input, left, right);
        }
        swap(input, left, start);
        //注意这里，start是数组中元素的下标。在start之前的元素都是比start指向的元素小，
        //后面的都是比他大。如果k==start，正好start之前的k个元素是我们要找的，也就是
        //数组中最小的k个，如果k>start，说明前k个元素不够，我们还要往后再找找。如果
        //k<start，说明前k个足够了，我们只需要在start之前找k个即可。
        if (left > k) {
            quickSort(input, res, k, start, left - 1);
        } else if (left < k) {
            quickSort(input, res, k, left + 1, end);
        } else {
            //取前面的k个即可
            for (int m = 0; m < k; ++m) {
                res.add(input[m]);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```