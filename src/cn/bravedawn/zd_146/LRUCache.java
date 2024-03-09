package cn.bravedawn.zd_146;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : depers
 * @date : Created in 2024/3/9 20:29
 *
 * 621.任务调度器（阿里钉钉面试题）
 */
public class LRUCache {

    private final int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        // 如果没有哈希冲突，map的基本操作（put、get、remove、containsKey）平均时间复杂度是O(1)
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Integer result = map.get(key);
        map.remove(key);
        // 重新写入，就是最新的
        map.put(key, result);
        return result;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
            return;
        }

        if(map.size() == capacity){
            // 第一个就是最久没使用的
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);

        System.out.println(lruCache.get(1)); // -1
        System.out.println(lruCache.get(2)); // 2
        System.out.println(lruCache.get(3)); // 3
    }
}
