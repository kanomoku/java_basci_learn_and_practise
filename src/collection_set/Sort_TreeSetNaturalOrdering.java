package collection_set;

import java.util.TreeSet;

public class Sort_TreeSetNaturalOrdering {

    public static void main(String[] args) {
        // 1.排序的引入(以基本数据类型的排序为例)
        testBasicDataType();
        // 如果是引用数据类型呢,比如自定义对象,又该如何排序呢?
        testObject();
    }

    private static void testBasicDataType() {
        // 创建集合对象
        // 自然顺序进行排序
        TreeSet<Integer> ts = new TreeSet<Integer>();
        // 创建元素并添加
        // 20,18,23,22,17,24,19,18,24
        ts.add(20);
        ts.add(18);
        ts.add(23);
        ts.add(22);
        ts.add(17);
        ts.add(24);
        ts.add(19);
        ts.add(18);
        ts.add(24);
        // 遍历
        for (Integer i : ts) {
            System.out.println(i);
        }
    }

    private static void testObject() {
        TreeSet<Student1> ts = new TreeSet<Student1>();
        // 创建元素对象
        Student1 s1 = new Student1("zhangsan", 20);
        Student1 s2 = new Student1("lis", 22);
        Student1 s3 = new Student1("wangwu", 24);
        Student1 s4 = new Student1("chenliu", 26);
        Student1 s5 = new Student1("zhangsan", 22);
        Student1 s6 = new Student1("qianqi", 24);

        // 将元素对象添加到集合对象中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        // 遍历
        for (Student1 s : ts) {
            System.out.println(s.getName() + "-----------" + s.getAge());
        }
    }

}


class Student1 implements Comparable<Student1> {
    private String name;
    private int age;

    public Student1() {
    }

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student1(int age) {
        this.age = age;
    }

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "姓名是" + name + "年龄是" + age;
    }

    // (1).自然排序
    @Override
    public int compareTo(Student1 s) {
        // return -1; //-1表示放在红黑树的左边,即逆序输出
        // return 1; //1表示放在红黑树的右边，即顺序输出
        // return 0; //表示元素相同，仅存放第一个元素
        // 主要条件 姓名的长度,如果姓名长度小的就放在左子树，否则放在右子树
        int num = this.name.length() - s.name.length();
        // 姓名的长度相同，不代表内容相同,如果按字典顺序此String对象位于参数字符串之前，则比较结果为一个负整数。
        // 如果按字典顺序此String对象位于参数字符串之后，则比较结果为一个正整数。
        // 如果这两个字符串相等,则结果为 0
        int num1 = num == 0 ? this.name.compareTo(s.name) : num;
        // 姓名的长度和内容相同，不代表年龄相同，所以还要判断年龄
        int num2 = num1 == 0 ? this.age - s.age : num1;
        return num2;
    }
}