/**
 * @Description: 公用常量
 * @Date: 2021/1/4 10:27
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution2
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution2{
    public static String replaceSpace(StringBuffer s){
        //通过一次遍历获得空格的数量
        int space_counts = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                space_counts++;
            }
        }
        //将字符串扩充到s.length()+space_counts*2的长度
        //提前记录下原始字符串的长度
        int old_length = s.length();
        s.setLength(space_counts*2+old_length);
        int new_length = s.length();
        //因为需要原地置换，所以从后向前遍历
        for(int i = old_length - 1;i >= 0; i--){
            if(s.charAt(i) == ' '){
                s.setCharAt(new_length--,'0');
                s.setCharAt(new_length--,'2');
                s.setCharAt(new_length--,'%');
            }else{
                s.setCharAt(new_length--,s.charAt(i));
            }
        }
        return s.toString();
    }
}
