/**
 * @Description: 公用常量
 * @Date: 2021/1/4 10:06
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution1
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution1 {
    public String replaceSpace(String s) {
        //声明一个新的字符串
        StringBuffer res = new StringBuffer(s.length());
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == ' '){
                res.append("%20");
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
