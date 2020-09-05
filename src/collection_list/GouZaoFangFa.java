package collection_list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Administrator
 */
public class GouZaoFangFa {
    public static void main(String[] args) {

        List<ComparatorStudent> arrayList = new ArrayList<>();
        arrayList.add(new ComparatorStudent("A", 100));
        arrayList.add(new ComparatorStudent("B", 95));
        arrayList.add(new ComparatorStudent("C", 66));
        arrayList.add(new ComparatorStudent("D", 88));

        TreeSet<ComparatorStudent> affectedWsSet = new TreeSet<>(new Comparator<ComparatorStudent>() {
            @Override
            public int compare(ComparatorStudent o1, ComparatorStudent o2) {
                return (int) (o1.getScore() - o2.getScore());
            }
        });
        affectedWsSet.addAll(arrayList);
        System.out.println(affectedWsSet);


        //TreeSet 转 List
        List<ComparatorStudent> list2 = new ArrayList<ComparatorStudent>(affectedWsSet);
        System.out.println(list2);
        //新包装一个list
        List<ComparatorStudent> list1 = new ArrayList<ComparatorStudent>(arrayList);
        System.out.println(list1);

    }
}

class ComparatorStudent {
    private String name;
    private int score;

    public ComparatorStudent() {
    }

    public ComparatorStudent(int score) {
        this.score = score;
    }

    public ComparatorStudent(String name, int score) {
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