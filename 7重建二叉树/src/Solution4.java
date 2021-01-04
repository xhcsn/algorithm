/**
 * @Description: 公用常量
 * @Date: 2021/1/4 21:14
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution4
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution4{
    public int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().fib(30));
    }
}