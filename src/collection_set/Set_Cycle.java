package collection_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * https://blog.csdn.net/yangliangliang2011/article/details/88641922
 */
public class Set_Cycle {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int n = 1000_0000;
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        System.out.println("======== 1 iterator ==========");
        iteratorTest(set);
        System.out.println("======== 2 增强for ==========");
        forBoostTest(set);
        System.out.println("======== 3 forEach 最耗时 java8 ==========");
        forEachTest(set);
        System.out.println("======== 4 stream forEach 比较耗时和增强for差不多 java8 ==========");
        streamForEachTest(set);
    }

    /**
     * 1 iterator
     * 迭代器
     *
     * @param set
     */
    public static void iteratorTest(Set<Integer> set) {
        long before = System.currentTimeMillis();
        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
            iterator.next();
        }
        long after = System.currentTimeMillis();
        System.out.println("set.iterator() for time=\t" + (after - before));

        before = System.currentTimeMillis();
        /**
         * while 循环写法
         */
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        after = System.currentTimeMillis();
        System.out.println("set.iterator() while time=\t" + (after - before));
    }

    /**
     * 2
     * 增强for
     *
     * @param set
     */
    public static void forBoostTest(Set<Integer> set) {
        long before = System.currentTimeMillis();
        for (int item : set) {
            // System.out.println(item);
        }
        long after = System.currentTimeMillis();
        System.out.println("set.for Boost time=\t" + (after - before));
    }

    /**
     * 3 foreach
     * foreach 最慢不推荐 java8 lambda
     *
     * @param set
     */
    public static void forEachTest(Set<Integer> set) {
        long before = System.currentTimeMillis();
        set.forEach(item -> {
            // System.out.println(item);
        });
        long after = System.currentTimeMillis();
        System.out.println("set.forEach time=\t" + (after - before));
    }


    /**
     * 4 stream foreach
     * stream foreach java8 特有
     *
     * @param set
     */
    public static void streamForEachTest(Set<Integer> set) {
        long before = System.currentTimeMillis();
        set.stream().forEach(item -> {
            // System.out.println(item);
        });
        long after = System.currentTimeMillis();
        System.out.println("set.stream().forEach() time=\t" + (after - before));
    }

}
