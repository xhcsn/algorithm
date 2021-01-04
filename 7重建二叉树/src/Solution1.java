/**
 * @Description: 公用常量
 * @Date: 2021/1/4 19:16
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution1
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution1 {
    public int recursion(int n) {
        int value = 0;
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 1;
        }else{
            value = recursion(n - 1) + recursion(n - 2);
            return value;
        }

    }

    public static void main(String[] args) {
        for(int i = 1; i < 10; i++){
            System.out.println(new Solution1().recursion(i));
        }
    }
}
