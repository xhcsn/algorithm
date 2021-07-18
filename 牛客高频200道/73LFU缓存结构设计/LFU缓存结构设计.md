#### LFU缓存结构设计

一个缓存结构需要实现如下功能。

set(key, value)：将记录(key, value)插入该结构

get(key)：返回key对应的value值

但是缓存结构中最多放K条记录，如果新的第K+1条记录要加入，就需要根据策略删掉一条记录，然后才能把新记录加入。这个策略为：在缓存结构的K条记录中，哪一个key

从进入缓存结构的时刻开始，被调用set或者get的次数最少，就删掉这个key的记录；

如果调用次数最少的key有多个，上次调用发生最早的key被删除

这就是LFU缓存替换算法。实现这个结构，K作为参数给出


```java
/*

LFU算法：least frequently used，最近最不经常使用算法

如果一个数据在最近一段时间很少被访问到，那么可以认为在将来它被访问的可能性也很小。因此，当空间满时，最小频率表访问的数据最先被淘汰。

- set(key, value)：将记录(key, value)插入该结构， 将访问频率最低的数据置换掉
- get(key)：返回key对应的value值

一般会维护两个数据结构：
- 哈希：用来提供对外部的访问，查询效率更高；
- 双向链表或者队列，维护了对元素访问次数的排序

缓存操作导致链表发生的变化

添加新元素：新元素访问次数为1，放到队尾
缓存淘汰：从队尾开始淘汰，因为队尾元素的访问次数最少
访问缓存：访问缓存会增加元素的访问次数，所以元素在队列或双向链表的位置会重新排序
*/


//-----------------------------解法：使用双哈希表---------------------------------

import java.util.*;


public class Solution {
    /**
     * lfu design
     * @param operators int整型二维数组 ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LFU (int[][] operators, int k) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        // int[] 是一个长度为3的数组,第一个元素用来存储value，第二个元素用来存储访问次数
        //，第三个元素记录上次调用的时间
        HashMap<Integer, int[]> map = new HashMap<>(); 

        int counter = 0; // 计时器

        for (int[] operator : operators) {
            if (operator[0] == 1) {
                if (!map.containsKey(operator[1])) {
                    // 如果size等于k, 就要删除一个元素, 此处可以独立出来写一个函数
                    if (map.size() == k) {
                        int rm = 0;
                        int min = Integer.MAX_VALUE;
                        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                            if (min > entry.getValue()[1]) {
                                rm = entry.getKey();
                                min = entry.getValue()[1];
                            } else {
                                if (entry.getValue()[1] == min) {
                                    if (entry.getValue()[2] < map.get(rm)[2]) {
                                        rm = entry.getKey();
                                    }
                                }
                            }
                        }
                       map.remove(rm);
                    }
                    map.put(operator[1], new int[] {operator[2], 1, counter++});
                } else {
                    map.put(operator[1], new int[] {operator[2], map.get(operator[1])[1] + 1, counter++});
                }
            } else {
                if (map.containsKey(operator[1])) {
                    list.add(map.get(operator[1])[0]);
                    map.get(operator[1])[1]++;
                    map.get(operator[1])[2] = counter++;
                } else {
                    list.add(-1);
                }
            }
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
```