import java.util.Arrays;

/**
 * @Description: 公用常量
 * @Date: 2021/1/3 19:38
 * @Pacakge: PACKAGE_NAME
 * @ClassName: QuickSort
 * @Version: v1.0.0
 * @Author: ccc
 */
public class QuickSort {
    //arr是待排序的数组，low为初始位置的值，high为末端位置的值
    public static int subregion(int[] arr, int low, int high){
        int i = low;
        int j = high;
        //将第一个数作为基准值
        int x = arr[low];
        //利用循环实现分区操作
        while(i < j){
            //将j向左移动，直到找到第一个小于基准值的值
            while (arr[j] > x && i < j){
                j--;
            }
            //将右侧找到小于基准数的值加入到左边的坑的位置，左指针向右移动一格
            if(i < j){
                arr[i] = arr[j];
                i++;
            }
            while (arr[i] < x && i < j){
                i++;
            }
            if(i < j){
                arr[j] = arr[i];
                j--;
            }
        }
        //使用基准值填在空下来的位置
        arr[i] = x;
        return i;
    }
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int index = subregion(arr,low,high);
            quickSort(arr, low, index-1);
            quickSort(arr, index+1,high);
        }
    }
    public static void quickSort(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }

    public static void main(String[] args) {
        //给出无序数组
        int[] arr = {72,6,57,88,60,42,83,73,48,85};

        //输出无序数组
        System.out.println(Arrays.toString(arr));
        //快速排序
        quickSort(arr);
        //partition(arr,0,arr.length-1);
        //输出有序数组
        System.out.println(Arrays.toString(arr));
    }
}
