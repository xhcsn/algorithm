#### 跳台阶扩展问题
```java
public class Solution {
    public int jumpFloorII(int target) {
        //设dp[n]为该青蛙跳上一个n级台阶总共有的跳法；
        //dp[n] = dp[n - 1] + dp[n - 2] + ... + dp[1];
        //dp[n - 1] = dp[n - 2] + ... + dp[1];
        //作差： dp[n] = 2*dp[n - 1];
        return (int) Math.pow(2, target - 1);
    }
}
```