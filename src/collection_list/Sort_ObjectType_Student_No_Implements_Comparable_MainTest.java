package collection_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("all")
public class Sort_ObjectType_Student_No_Implements_Comparable_MainTest {
    public static void main(String[] args) {
        List<Sort_Bean_Student_No_Implements_Comparable> studentList = new ArrayList<>();
        studentList.add(new Sort_Bean_Student_No_Implements_Comparable(23, 90, "张三"));
        studentList.add(new Sort_Bean_Student_No_Implements_Comparable(22, 97, "李四"));
        studentList.add(new Sort_Bean_Student_No_Implements_Comparable(23, 95, "王五"));
        studentList.add(new Sort_Bean_Student_No_Implements_Comparable(24, 91, "赵六"));
        studentList.add(new Sort_Bean_Student_No_Implements_Comparable(21, 98, "赵六"));
        studentList.add(new Sort_Bean_Student_No_Implements_Comparable(21, 98, "赵五"));
        studentList.add(new Sort_Bean_Student_No_Implements_Comparable(21, 99, "赵七"));
        System.out.println("排序之前的list：");
        studentList.stream().forEach(System.out::println);

        //自定义排序1
        Collections.sort(studentList, (o1, o2) -> {
            //先按照年龄排序
            Integer i = o1.getAge().compareTo(o2.getAge());
            if (i == 0) {
                //如果年龄相等，则按照分数排序
                i = o1.getScore().compareTo(o2.getScore());
                if (i == 0) {
                    //如果分数相等，则按照姓名排序
                    i = o1.getName().compareTo(o2.getName());
                }
            }
            return i;
        });
        //自定义排序2
        studentList.sort((o1, o2) -> {
            //先按照年龄排序
            Integer i = o1.getAge().compareTo(o2.getAge());
            if (i == 0) {
                //如果年龄相等，则按照分数排序
                i = o1.getScore().compareTo(o2.getScore());
                if (i == 0) {
                    //如果分数相等，则按照姓名排序
                    i = o1.getName().compareTo(o2.getName());
                }
            }
            return i;
        });
        System.out.println("排序之后的list：");
        studentList.stream().forEach(System.out::println);

        //只按照姓名排序方式一：
        Collections.sort(studentList, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        //只按照姓名排序方式二：
        Collections.sort(studentList, Comparator.comparing(Sort_Bean_Student_No_Implements_Comparable::getName));
        //只按照姓名排序方式三：
        Collections.sort(studentList, Comparator.comparing(e -> e.getName()));
        //只按照姓名排序方式四：
        studentList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        //只按照姓名排序方式五：
        studentList.sort(Comparator.comparing(Sort_Bean_Student_No_Implements_Comparable::getName));
        //只按照姓名排序方式六：
        studentList.sort(Comparator.comparing(e -> e.getName()));

        //只按照年龄排序方式一：
        Collections.sort(studentList, (e1, e2) -> e1.getAge().compareTo(e2.getAge()));
        //只按照年龄排序方式二：
        Collections.sort(studentList, Comparator.comparingInt(Sort_Bean_Student_No_Implements_Comparable::getAge));
        System.out.println("只按照年龄排序之后的list：");
        studentList.stream().forEach(System.out::println);

    }
}
