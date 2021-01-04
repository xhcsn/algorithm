/**
 * @Description: 公用常量
 * @Date: 2021/1/4 19:27
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution2
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution2 {
    public int recursion(int n){
        int value = 0;
        if(n == 1){
            return 1;
        }else{
            value = n * recursion(n - 1);
            n--;
            return value;
        }
    }

    public static void main(String[] args) {
        for(int i=1; i<10;i++){
            System.out.println(new Solution2().recursion(i));
        }
    }
}
