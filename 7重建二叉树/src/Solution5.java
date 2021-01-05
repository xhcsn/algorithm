/**
 * @Description: 公用常量
 * @Date: 2021/1/5 16:08
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution5
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution5 {
    public static int getSum(int n){
        if(n == 0){
            return 0;
        }
        if(n < 10){
            return n;
        }else{
            return n % 10 + getSum(n/10);
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution5.getSum(0));
    }
}
