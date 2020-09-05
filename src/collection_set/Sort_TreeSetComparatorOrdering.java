package collection_set;

import java.util.TreeSet;

public class Sort_TreeSetComparatorOrdering {

    // (2)比较器排序
    public static void main(String[] args) {
        // 创建集合对象
        // TreeSet(Comparator<? super E> comparator)
        // 构造一个新的空TreeSet，它根据指定比较器进行排序。
        TreeSet<Student> ts = new TreeSet<Student>(new TreeSetComparator());

        // 创建元素对象
        Student s1 = new Student("zhangsan", 20);
        Student s2 = new Student("lis", 22);
        Student s3 = new Student("wangwu", 24);
        Student s4 = new Student("chenliu", 26);
        Student s5 = new Student("zhangsan", 22);
        Student s6 = new Student("qianqi", 24);

        // 将元素对象添加到集合对象中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        // 遍历
        for (Student s : ts) {
            System.out.println(s.getName() + "-----------" + s.getAge());
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
