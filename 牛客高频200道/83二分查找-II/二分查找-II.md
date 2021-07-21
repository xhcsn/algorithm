#### 二分查找-II
请实现有重复数字的升序数组的二分查找
```java
import java.util.*;
public class Solution {
    public int search(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target){
                while(mid != 0 && nums[mid - 1] == nums[mid]){
                    mid--;
                }
            }
        }
    }
}
```