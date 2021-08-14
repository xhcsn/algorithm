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

####