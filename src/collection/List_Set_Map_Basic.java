package collection;

import java.util.*;

/**
 * 集合
 * Collection                                        Map
 * 以value形式存储                                 以key-value形式存在
 * List接口      Queue接口    Set接口
 * 有序可重复   有序可重复    无序不重复            key无序无重复 value无序可重复
 * ArrayList     Deque        HashSet               HashTable
 * Vector        LinkedList   TreeSet               HashMap
 * Stack                      LinkedHashSet         TreeMap
 * LinkedList                                       LinkedHashMap
 * <p>
 * <p>
 * <p>
 * <p>
 * // 如果你知道是Set，但是不知道是哪个Set，就用HashSet。
 * // 如果你知道是List，但是不知道是哪个List，就用ArrayList。
 * // 如果你知道是Collection集合，但是不知道使用谁，就用ArrayList。
 * <p>
 * //有序用List  ArrayList 更适合遍历  LinkedList更适合插入和删除  Stack LIFO
 * //无重复用Set  HashSet找寻块   TreeSet希望存进去自动排序  LinkHashSet  FIFO
 * //快速找寻用Map HashMap找寻快  TreeMap希望存进去key自动排序
 * <p>
 * //什么情形下使用
 * //数组                   集合
 * //如果长度不变 用数组  长度不确定用集合
 */
public class List_Set_Map_Basic {


    public static void main(String[] args) {


        /**
         *        // List 有序可重复；
         *         // ArrayList
         *         // 优点: 底层数据结构是数组，查询快，增删慢。
         *         // 缺点: 线程不安全，效率高
         *
         *         // Vector
         *         // 优点: 底层数据结构是数组，查询快，增删慢。
         *         // 缺点: 线程安全，效率低
         *
         *         // LinkedList
         *         // 优点: 底层数据结构是链表，查询慢，增删快。
         *         // 缺点: 线程不安全，效率高
         *
         *         // 要安全吗?
         *         // 是：Vector
         *         // 否：ArrayList或者LinkedList
         *         // 查询多：ArrayList
         *         // 增删多：LinkedList
         */

        List<String> arrayList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();
        Vector<String> vector = new Vector<String>();
        for (String data : Arrays.asList("S1", "S3", "S4", "S5", "S2", "S2")) {
            arrayList.add(data);
            linkedList.add(data);
            vector.add(data);
        }
        System.out.println("原始值 :" + arrayList);
        System.out.println("Ordering in arrayList :" + arrayList);
        System.out.println("Ordering in linkedList :" + linkedList);
        System.out.println("Ordering in vector :" + vector);
        System.out.println("···························");

        /**
         * Set 无序唯一。
         *         // 针对Collection集合我们到底使用谁呢?(掌握)
         *         // 唯一吗?
         *         // 是：Set
         *         // 排序吗?
         *         // 是：TreeSet或LinkedHashSet
         *         // 否：HashSet
         *
         *         // HashSet
         *         // (底层用HashMap  哈希表--> 数组 + 链表)
         *         Set集合是发现重复的元素拒绝存储
         *
         *         // 无序：我们使用集合存放元素的顺序 集合内取出来的顺序不一致 但是他自己有自己的算法，我们便顺序他也变 集合本身有自己的算法排布顺序
         *
         *         // 如何来保证元素唯一性?
         *         // 1.依赖两个方法：hashCode()和equals()
         *         //   无重复的原则：通过equals方法比较--不仅仅equals这么简单还要hashCode同时起作用--equals且hashcode相等---
         *
         *         //增强for循环JDK1.5以后才出来，所以之前用iterator迭代器来循环，迭代器就两个功能1.判断有没有hasNext 2.有就取出来next
         *
         *         // LinkedHashSet
         *         https://blog.csdn.net/learningcoding/article/details/79983248
         *         // 底层数据结构是链表和哈希表。(FIFO插入有序,唯一)
         *         LinkedHashMap 较之 HashMap 内部多维护了一个双向链表用来维护元素的添加顺序
         *         // 1.由链表保证元素有序
         *         // 2.由哈希表保证元素唯一
         *
         *         // TreeSet
         *         // 底层数据结构是红黑树。(有序，唯一)
         *         // 1. 如何保证元素排序的呢?
         *         // 自然排序
         *         // 比较器排序
         *         // 2.如何保证元素唯一性的呢?
         *         // 根据比较的返回值是否是0来决定
         *
         *         //TreeSet-----底层用TreeMap 二叉树
         *         //            有增删没有修改方法
         *         //无重复原则：compareTo---->String类 按照字母的自然顺序排布(Unicode)
         *         //如果想要把自己写的类型 比如person类对象存入TreeSet集合里  不能随意存储  需要让自己写的类先实现Comparable接口，然后重写compareTo方法
         *
         *
         *         // 重点问题重点分析:
         *         // (一).TreeSet, LinkedHashSet and HashSet 的区别
         *         // 1. 介绍
         *         // TreeSet, LinkedHashSet and HashSet 在java中都是实现Set的数据结构
         *         // TreeSet的主要功能用于排序
         *         // LinkedHashSet的主要功能用于保证FIFO即有序的集合(先进先出)
         *         // HashSet只是通用的存储数据的集合
         *         // 2. 相同点
         *         // 唯一性/Duplicates elements: 因为三者都实现Set interface，所以三者都不包含duplicate elements
         *         // Thread safety: 三者都不是线程安全的，如果要使用线程安全可以Collections.synchronizedSet()
         *         // 3. 不同点
         *         // Performance and Speed:
         *         // HashSet插入数据最快，其次LinkHashSet，最慢的是TreeSet因为内部实现排序
         *         // Ordering:
         *         // HashSet不保证有序，LinkHashSet保证FIFO即按插入顺序排序，TreeSet安装内部实现排序，也可以自定义排序规则
         *         // null:HashSet和LinkHashSet允许存在null数据，但是TreeSet中插入null数据时会报NullPointerException
         */


        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        for (String data : Arrays.asList("1", "E", "D", "C", "A")) {
            hashSet.add(data);
            linkedHashSet.add(data);
            treeSet.add(data);
        }
        System.out.println("原始值:" + Arrays.asList("1", "E", "D", "C", "A"));
        // 不保证有序
        System.out.println("Ordering in HashSet :" + hashSet);
        // FIFO保证安装插入顺序排序
        System.out.println("Order of element in LinkedHashSet :" + linkedHashSet);
        // 内部实现排序
        System.out.println("Order of objects in TreeSet :" + treeSet);

        Set<String> hashSet1 = new HashSet<String>();
        Set<String> linkedHashSet1 = new LinkedHashSet<String>();
        Set<String> treeSet1 = new TreeSet<String>();
        for (String data : Arrays.asList("S1", "S3", "S4", "S5", "S2", "S2")) {
            hashSet1.add(data);
            linkedHashSet1.add(data);
            treeSet1.add(data);
        }
        System.out.println("原始值:" + Arrays.asList("S1", "S3", "S4", "S5", "S2", "S2"));
        System.out.println("HashSet:" + hashSet1);
        System.out.println("LinkedHashSet:" + linkedHashSet1);
        System.out.println("TreeSet:" + treeSet1);
        System.out.println("···························");

        /**
         *    Map
         *         //由key直接定位value值 键值对
         *         //key无序不重复 value无序可重复  无序指的是存入的顺序和取出的顺序不一致
         *         //1.key存储的顺序和取得的顺序不同
         *         //2.不同的key可以取得相同的value
         *         //3.key若有相同的 则将 原有的value覆盖而不是拒绝存入和set相反
         *
         *         //properties
         *
         *         //hashMap
         *         https://blog.csdn.net/wufaliang003/article/details/79997585
         *         //HashMap底层的数据结构存储:散列表的形式  数组+链表
         *
         *         HashTable
         *         https://www.cnblogs.com/aspirant/p/8906018.html
         *        和HashMap一样，Hashtable 也是一个散列表，它存储的内容是键值对(key-value)映射， 都是数组+链表的形式存储数据：
         *
         *
         *         TreeMap 底层结构为红黑树
         *
         *
         *         //Person对象存入HashMap中？ 可以
         *         //hashCode方法-->不同的对象 可以产生相同的hashCode码的.不同的hashCode码--->对应不同的对象
         *
         *         //有序？
         *         是：TreeMap
         *         否：HashTable或HashMap
         *
         *         //HashTable和HashMap区别
         *         // 1.继承的父类不同
         *         // 父类不同：HashTable的父类是Dictionary，HashMap的父类是AbstractMap。但二者都实现了Map接口。
         *
         *         //2.线程安全性不同
         *         // 查看HashTable的源代码就可以发现，除构造函数外，HashTable的所有 public 方法声明中都有synchronized关键字，而HashMap的源码中则没有。
         *         // 如果对同步性或与遗留代码的兼容性没有任何要求，建议使用HashMap。
         *         // HashTable的方法是同步的，HashMap的方法不是同步的。
         *         // HashTable是线程安全的，HashMap不是线程安全的。
         *         // HashTable效率较低，HashMap效率较高，
         *         // 让HashMap线程安全，Map m = Collections.synchronizedMap(new HashMap(...));
         *
         *         //3.key和value是否允许null值
         *         //Hashtable中，key和value都不允许出现null值。，HashMap允许null值（key和value都允许）
         *         // 但是如果在Hashtable中有类似put(null,null)的操作，编译同样可以通过，因为key和value都是Object类型，但运行时会抛出NullPointerException异常，这是JDK的规范规定的。
         *         //HashMap中，null可以作为键，这样的键只有一个；
         *         //可以有一个或多个键所对应的值为null。
         *         // 当get()方法返回null值时，可能是 HashMap中没有该键，也可能使该键所对应的值为null。
         *         // 因此，在HashMap中不能由get()方法来判断HashMap中是否存在某个键， 而应该用containsKey()方法来判断。
         *
         *         //4.是否提供contains方法
         *         //Hashtable保留了contains，containsValue和containsKey三个方法，其中contains和containsValue功能相同。
         *         //HashMap把Hashtable的contains方法去掉了，改成containsValue和containsKey，因为contains方法容易让人引起误解。
         *
         *         //5、两个遍历方式的内部实现上不同
         *         //Hashtable、HashMap都使用了 Iterator。而由于历史原因，Hashtable还使用了Enumeration的方式 。
         *
         *         //6、hash值不同
         *         //哈希值的使用不同。Hashtable不重新计算hash值，直接用key的hashCode()，而HashMap重新计算了key的hash值，
         *         //hashCode是jdk根据对象的地址或者字符串或者数字算出来的int类型的数值。
         *         // Hashtable在求hash值对应的位置索引时，用取模运算，
         *         // 而HashMap在求位置索引时，则用与运算，且这里一般先用hash&0x7FFFFFFF后，再对length取模，&0x7FFFFFFF的目的是为了将负的hash值转化为正值，因为hash值有可能为负数，而&0x7FFFFFFF后，只有符号外改变，而后面的位都不变。
         *
         *         //7、内部实现使用的数组初始化和扩容方式不同
         *         //HashTable在不指定容量的情况下的默认容量为11，而HashMap为16.
         *         //Hashtable扩容时，将容量变为原来的2倍加1，而HashMap扩容时，将容量变为原来的2倍。
         */
        Hashtable ht = new Hashtable();
        ht.put(null, null);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put(null, null);

    }
}
