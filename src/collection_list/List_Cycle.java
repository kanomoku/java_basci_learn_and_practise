package collection_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://blog.csdn.net/yangliangliang2011/article/details/88640653
 */
public class List_Cycle {

    public List_Cycle() {
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int n = 10000000;
        while (n > 0) {
            list.add(n);
            n--;
        }
        // 1-10 一共10个

//        int n1 = 1000_0000;
//        for (int i = 0; i < n1; i++) {
//            list.add(i);
//        }

        System.out.println("======== 1 fori 推荐 ==========");
        foriTest(list);
        System.out.println("======== 2 iterator ==========");
        iteratorTest(list);
        System.out.println("======== 3 增强for ==========");
        forBoostTest(list);
        System.out.println("======== 4 forEach 最耗时 java8 ==========");
        forEachTest(list);
        System.out.println("======== 5 stream forEach 比较耗时和增强for差不多 java8 ==========");
        streamForEachTest(list);
        System.out.println("======== 6 parallelStream  java8 ==========");
        parallelStreamForEachTest(list);

    }

    /**
     * for循环遍历list 这种方式的问题在于，删除某个元素后，list的大小发生了变化，而你的索引也在变化，所以会导致你在遍历的时候漏掉某些元素。
     * 这种方式可以用在删除特定的一个元素时使用，但不适合循环删除多个元素时使用
     * <p>
     * 普通fori
     * 效率最高，也是java官方推荐的用法
     */
    public static void foriTest(List<Integer> list) {
        long before = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            Integer a = list.get(i);
        }
        long after = System.currentTimeMillis();
        System.out.println("for i time=\t" + (after - before));
    }

    /**
     * 增强for循环
     * <p>
     * 删除元素后继续循环会报错误信息ConcurrentModificationException，因为元素在使用的时候发生了并发的修改，导致异常抛出。
     * 但是删除完毕马上使用break跳出，则不会触发报错
     */
    public static void forBoostTest(List<Integer> list) {
        long before = System.currentTimeMillis();
        for (int i : list) {
            Integer a = i;
        }
        long after = System.currentTimeMillis();
        System.out.println("for Boost time=\t" + (after - before));
    }

    /**
     * iterator遍历 可以正常的循环及删除。但要注意的是，使用iterator的remove方法，
     * 如果用list的remove方法同样会报上面提到的ConcurrentModificationException错误
     * <p>
     * iterator
     * 迭代器
     */
    public static void iteratorTest(List<Integer> list) {
        long before = System.currentTimeMillis();
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            Integer a = (Integer) iterator.next();
        }
        long after = System.currentTimeMillis();
        System.out.println("iterator for time=\t" + (after - before));

        before = System.currentTimeMillis();
        /**
         * while 循环写法
         */
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer a = (Integer) iterator.next();
        }
        after = System.currentTimeMillis();
        System.out.println("iterator while time=\t" + (after - before));
    }
    // 以上3中循环的总结：
    // （1）循环删除list中特定一个元素的，可以使用三种方式中的任意一种，但在使用中要注意上面分析的各个问题。
    // （2）循环删除list中多个元素的，应该使用迭代器iterator方式。

    /**
     * foreach
     * foreach 最慢不推荐 java8 lambda
     */
    public static void forEachTest(List<Integer> list) {
        long before = System.currentTimeMillis();
        list.forEach(item -> {
            Integer a = item;
        });
        long after = System.currentTimeMillis();
        System.out.println("list.forEach time=\t" + (after - before));
    }

    /**
     * stream foreach
     * stream foreach java8 特有
     */
    public static void streamForEachTest(List<Integer> list) {
        long before = System.currentTimeMillis();
        list.stream().forEach(item -> {
            Integer a = item;
        });
        long after = System.currentTimeMillis();
        System.out.println("list.stream().forEach time=\t" + (after - before));
    }

    /**
     * stream foreach
     * stream foreach java8 特有
     */
    public static void parallelStreamForEachTest(List<Integer> list) {
        long before = System.currentTimeMillis();
        list.parallelStream().forEach(item -> {
            Integer a = item;
        });
        long after = System.currentTimeMillis();
        System.out.println("list.parallelStream().forEach time=\t" + (after - before));
    }
}
