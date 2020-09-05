package collection_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://blog.csdn.net/yangliangliang2011/article/details/88641600
 */
public class Map_Cycle {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = 1000_0000;
        for (int i = 1; i <= n; i++) {
            map.put(i, i);
        }

        System.out.println("======== 1 entrySet 最常用 ==========");
        entrySetTest(map);
        System.out.println("======== 2 keySet Or Values 取keys或values 时,效率最高 ==========");
        keySetOrValuesTest(map);
        //System.out.println("======== keySetForValueTest ==========");
        keySetForValueTest(map);
        System.out.println("======== 3 iterator Type ==========");
        iteratorTypeTest(map);
        System.out.println("======== 4 forEach java 8 效率最低 ==========");
        forEachTest(map);
        System.out.println("======== 5 stream ForEach java 8 流式 ==========");
        streamForEachTest(map);
    }

    public Map_Cycle() {
    }

    /**
     * 2（1）keySet values
     * 如果只需要键或者值，这个比键值对的要快
     *
     * @param map
     */
    public static void keySetOrValuesTest(Map<Integer, Integer> map) {
        long before = System.currentTimeMillis();
        // 遍历map中的键
        for (Integer key : map.keySet()) {
            //System.out.println("Key = " + key);
        }
        long after = System.currentTimeMillis();
        System.out.println("map.keySet() time=\t" + (after - before));

        before = System.currentTimeMillis();
        // 遍历map中的键
        Iterator<Integer> iteratorKeySet = map.keySet().iterator();
        while (iteratorKeySet.hasNext()) {
            iteratorKeySet.next();
            //System.out.println("key = " + iteratorKeySet.next());
        }
        after = System.currentTimeMillis();
        System.out.println("map.keySet().iterator() time=\t" + (after - before));


        before = System.currentTimeMillis();
        // 遍历map中的值
        for (Integer value : map.values()) {
            //System.out.println("Value = " + value);
        }
        after = System.currentTimeMillis();
        System.out.println("map.values() time=\t" + (after - before));

        before = System.currentTimeMillis();
        // 遍历map中的值
        Iterator<Integer> iteratorValues = map.values().iterator();
        while (iteratorValues.hasNext()) {
            iteratorValues.next();
            //System.out.println("key = " + iterator.next());
        }
        after = System.currentTimeMillis();
        System.out.println("map.values().iterator() time=\t" + (after - before));
    }

    /**
     * 2（2）keySet get
     * 根据键找值，效率很低
     *
     * @param map
     */
    public static void keySetForValueTest(Map<Integer, Integer> map) {
        long before = System.currentTimeMillis();
        //遍历map中的键
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            //System.out.println("Key = " + key + ", Value = " + value);
        }
        long after = System.currentTimeMillis();
        System.out.println("map.keySet() -> map.get(key) time=\t" + (after - before));
    }

    /**
     * 1
     * entrySet 这是最常用的方式，在键值都需要的时候
     *
     * @param map
     */
    public static void entrySetTest(Map<Integer, Integer> map) {
        long before = System.currentTimeMillis();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
            // System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        long after = System.currentTimeMillis();
        System.out.println("map.entrySet() time=\t" + (after - before));
    }

    /**
     * 3（1）iterator type
     * 迭代器 带泛型
     *
     * @param map
     */
    public static void iteratorTypeTest(Map<Integer, Integer> map) {
        long before = System.currentTimeMillis();
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        long after = System.currentTimeMillis();
        System.out.println("map.entrySet().iterator() time=\t" + (after - before));
    }

    /**
     * 4 forEach 遍历的是键值，所以是两个参数
     * forEach java8 lambda
     *
     * @param map
     */
    public static void forEachTest(Map<Integer, Integer> map) {
        long before = System.currentTimeMillis();
        //map.forEach( (key,value) -> {System.out.println("Key = " + key+ ", Value = "+ value);} );
        // 一条语句可以省略{}
        //map.forEach( (key,value) -> System.out.println("Key = " + key+ ", Value = "+ value) );
        map.forEach((key, value) -> {
        });
        long after = System.currentTimeMillis();
        System.out.println("map.forEach time=\t" + (after - before));

    }

    /**
     * 5 stream forEach 遍历的是entry 所以是一个参数
     * stream forEach java8 lambda
     *
     * @param map
     */
    public static void streamForEachTest(Map<Integer, Integer> map) {
        long before = System.currentTimeMillis();
        //map.entrySet().stream().forEach( (entry) -> {System.out.println("Key = " + entry.getKey()+ ", Value = "+ entry.getValue());} );
        // 一个参数可以省略()  一条语句可以省略{}
        //map.entrySet().stream().forEach(entry -> System.out.println("Key = " + entry.getKey()+ ", Value = "+ entry.getValue()) );
        //map.entrySet().stream().forEach( System.out::println);
        map.entrySet().stream().forEach((entry) -> {
        });
        long after = System.currentTimeMillis();
        System.out.println("map.entrySet().stream().forEach time=\t" + (after - before));
    }
}
