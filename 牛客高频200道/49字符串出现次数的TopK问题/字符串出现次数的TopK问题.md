#### 字符串出现次数的TopK问题

给定一个字符串数组，再给定整数k，请返回出现次数前k名的字符串和对应的次数。

```java
import java.util.*;

public class Solution {

    public String[][] topKstrings (String[] strings, int k) {
        // 统计字符串频数
        HashMap<String, Integer> stringCount = new HashMap<>();
        for (int i = 0;i < strings.length;i++) {
            stringCount.put(strings[i], stringCount.getOrDefault(strings[i], 0)+1);
        }
        
        // 建立大小为k的小顶堆，堆排序
        PriorityQueue<String> heap = new PriorityQueue<String>(
            (w1, w2) -> stringCount.get(w1).equals(stringCount.get(w2)) ?
            w2.compareTo(w1) : stringCount.get(w1) - stringCount.get(w2) );

        for (String word: stringCount.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        String[][] res = new String[k][2];
        int j = k-1;
        while (!heap.isEmpty()) {
            String tmp = heap.poll();
            res[j][0] = tmp;
            res[j][1] = stringCount.get(tmp) + "";
            j--;
        }
        
        return res;
    }
}
```