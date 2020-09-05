package collection_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort_BasicType_MainTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(1);
        /**
         * Collections工具类，升序排:
         */
        Collections.sort(list);
        System.out.println(list);
        System.out.println("Collections工具类，升序排:·················");

        /**
         *Collections工具类，降序排:
         */
        Collections.reverse(list);
        System.out.println(list);
        System.out.println("Collections工具类，降序排:·················");

        /**
         *java8新特性，升序排:
         */
        System.out.println(list);
        list.sort(Integer::compareTo);
        System.out.println(list);
        list.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::print);
        System.out.println();
        list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::print);
        System.out.println();
        System.out.println(list);
        System.out.println("ava8新特性，升序排:·················");

        /**
         *java8新特性，降序排:
         */
        System.out.println(list);
        list.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::print);
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println(list);
        System.out.println("java8新特性，降序排:·················");

        /**
         *也可以使用自定义排序如下，效果一样，不过不够简洁
         */
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println("·················");

        /**
         *自定义排序，降序排:
         */
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("·················");
    }
}
