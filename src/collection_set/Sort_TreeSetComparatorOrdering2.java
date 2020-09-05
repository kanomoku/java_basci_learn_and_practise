package collection_set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Administrator
 */
public class Sort_TreeSetComparatorOrdering2{
    public static void main(String[] args) {

        List<Student2> arrayList = new ArrayList<>();
        arrayList.add(new Student2("A", 100));
        arrayList.add(new Student2("B", 95));
        arrayList.add(new Student2("C", 66));
        arrayList.add(new Student2("D", 88));

        //也算是一种比较器排序
        TreeSet<Student2> affectedWsSet = new TreeSet<>(new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return (int) (o1.getScore() - o2.getScore());
            }
        });
        affectedWsSet.addAll(arrayList);
        System.out.println(affectedWsSet);

    }
}

class Student2 {
    private String name;
    private int score;

    public Student2() {
    }

    public Student2(int score) {
        this.score = score;
    }

    public Student2(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int a) {
        score = a;
    }

    public String toString() {
        return "姓名是" + name + "年龄是" + score;
    }
}