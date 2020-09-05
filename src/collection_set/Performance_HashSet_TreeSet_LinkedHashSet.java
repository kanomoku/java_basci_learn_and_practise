package collection_set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class Performance_HashSet_TreeSet_LinkedHashSet {

    // 虽然测试不够准确,但能反映得出，TreeSet要慢得多,因为它是有序的。
    public static void main(String[] args) {

        Random r = new Random();

        HashSet<Dog> hashSet = new HashSet<Dog>();
        testHashSet(r, hashSet);

        TreeSet<Dog> treeSet = new TreeSet<Dog>();
        testTreeSet(r, treeSet);

        LinkedHashSet<Dog> linkedSet = new LinkedHashSet<Dog>();
        testLinkedHashSet(r, linkedSet);
    }

    private static void testLinkedHashSet(Random r, LinkedHashSet<Dog> linkedSet) {
        long startTime;
        long endTime;
        long duration;
        // start time
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedSet.add(new Dog(i));
        }

        // end time
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedHashSet: " + duration);
    }

    private static void testTreeSet(Random r, TreeSet<Dog> treeSet) {
        long startTime;
        long endTime;
        long duration;
        // start time
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            treeSet.add(new Dog(i));
        }
        // end time
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("TreeSet: " + duration);
    }

    private static void testHashSet(Random r, HashSet<Dog> hashSet) {
        // start time
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashSet.add(new Dog(i));
        }

        // end time
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("HashSet: " + duration);
    }

}

class Dog implements Comparable<Dog> {
    int size;

    public Dog(int s) {
        size = s;
    }

    public String toString() {
        return size + "";
    }

    @Override
    public int compareTo(Dog o) {
        // 数值大小比较
        return size - o.size;
    }
}