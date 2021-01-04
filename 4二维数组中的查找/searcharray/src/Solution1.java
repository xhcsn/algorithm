/**
 * @Description: 公用常量
 * @Date: 2021/1/3 21:47
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution1
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution1 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int hang = 0;
        int lie = matrix[0].length-1;
        while(hang<matrix.length && lie>=0){
            if(matrix[hang][lie] == target){
                return true;
            }else if(matrix[hang][lie] > target){
                lie--;
            }else{
                hang++;
            }
        }
        return false;
    }
}
