/**
 * @Description: 公用常量
 * @Date: 2021/1/3 21:16
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution3
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }
}
