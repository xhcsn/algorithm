/**
 * @Description: 公用常量
 * @Date: 2021/1/3 19:27
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution1
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution1 {
    public int findRepeatNumber(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[index]){
                break;
            }else{
                index++;
            }
        }
        return nums[index];
    }
    public static int subSort(int[] arr, int low, int high){
        //两个指针
        int i = low;
        int j = high;
        //基准值
        int value = arr[low];
        while(i < j){
            while(value < arr[j] && i < j){
                j--;
            }
            if(i < j){
                arr[i] = arr[j];
                i++;
            }
            while(value > arr[i] && i < j){
                i++;
            }
            if(i < j){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = value;
        return i;
    }
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int index = subSort(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }
}
