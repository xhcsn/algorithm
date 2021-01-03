import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 公用常量
 * @Date: 2021/1/3 20:45
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution2
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution2 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
