package collection_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort_ObjectType_Student_Implements_Comparable_MainTest {
    public static void main(String[] args) {
        List<Sort_Bean_Student_Implements_Comparable> studentImplementsComparableList = new ArrayList<>();
        studentImplementsComparableList.add(new Sort_Bean_Student_Implements_Comparable(23, 90, "张三"));
        studentImplementsComparableList.add(new Sort_Bean_Student_Implements_Comparable(22, 97, "李四"));
        studentImplementsComparableList.add(new Sort_Bean_Student_Implements_Comparable(23, 95, "王五"));
        studentImplementsComparableList.add(new Sort_Bean_Student_Implements_Comparable(24, 91, "赵六"));
        studentImplementsComparableList.add(new Sort_Bean_Student_Implements_Comparable(21, 98, "赵六"));
        studentImplementsComparableList.add(new Sort_Bean_Student_Implements_Comparable(21, 98, "赵五"));
        studentImplementsComparableList.add(new Sort_Bean_Student_Implements_Comparable(21, 99, "赵七"));
        System.out.println("排序之前的list：");
        studentImplementsComparableList.stream().forEach(System.out::println);

        System.out.println("---------（Collections.sort）------------");
        System.out.println("排序之后的list：");
        Collections.sort(studentImplementsComparableList);//升序
        Collections.reverse(studentImplementsComparableList);//降序
        studentImplementsComparableList.stream().forEach(System.out::println);

        System.out.println("---------（使用lambda表达式排序之后）------------");
        studentImplementsComparableList.sort(Sort_Bean_Student_Implements_Comparable::compareTo);
        studentImplementsComparableList.stream().forEach(System.out::println);

        studentImplementsComparableList.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);//升序
        studentImplementsComparableList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);//降序

        studentImplementsComparableList.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);//升序
        studentImplementsComparableList.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);//升序

    }
}
