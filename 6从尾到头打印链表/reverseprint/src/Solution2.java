import java.util.ArrayList;

/**
 * @Description: 公用常量
 * @Date: 2021/1/4 11:17
 * @Pacakge: PACKAGE_NAME
 * @ClassName: Solution2
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Solution2 {
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
}