import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 公用常量
 * @Date: 2021/1/5 16:33
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution1
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution1 {
    public int movingCount(int m, int n, int k) {
        //确定机器人的坐标是从(0,0)开始移动于是开始递归；
        //标记机器人走过的格子数量
        Map<String,Integer> RobotMap = new HashMap<>();
        int start_row = 0;
        int start_lie = 0;
        //递归一个方法，使得其返回值为机器人能够到达的格子。
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                RobotMap.put(i+""+j,0);
            }
        }
        int result = searchRobot(0, 0, k, m, n, RobotMap);
        return result;
    }
    //定义一个获取数位和的方法
    public int getSum(int n){
        if(n == 0){
            return 0;
        }else if(n < 10){
            return n;
        }else{
            return n % 10 + getSum(n/10);
        }
    }
    public int searchRobot(int i, int j, int k,int m, int n, Map<String,Integer> RobotMap){
        //标记机器人到的地方的个数
        int index = 0;
        if(RobotMap.get(i+""+j) == null||RobotMap.get(i+""+j) != 0){
            return index;
        }
        if(i<0 || i>m-1 || j<0 || j>n-1){
            return index;
        }
        if(getSum(i)+getSum(j) <= k){
            RobotMap.replace(i+""+j,0,-1);
            index++;
            index = index + searchRobot(i+1, j, k, m,  n, RobotMap);
            index = index + searchRobot( i-1,  j,  k, m,  n,  RobotMap);
            index = index + searchRobot( i,  j+1,  k, m,  n,  RobotMap);
            index = index + searchRobot( i,  j-1,  k, m,  n,  RobotMap);
        }

        return index;

    }

    public static void main(String[] args) {
        System.out.println(new Solution1().movingCount(10,10,5));
    }
}
