package basic;

import java.util.ArrayList;
import java.util.Random;

public class RandomCoder_Suijishu {
    public static void main(String[] args) {
        random();
    }

    private static void random() {
        // 调用这个Math.Random()函数能够返回带正号的double值，该值大于等于0.0且小于1.0，即取值范围是[0.0,1.0)的左闭右开区间，返回值是一个伪随机选择的数，在该范围内（近似）均匀分布。
        // 例子如下：
        double random = Math.random();// 产生一个[0，1)之间的随机数
        System.out.println("Math.random():"+random);

        // 可以在构造Random对象的时候指定种子：
        // Random r1 = new Random(20);
        // 或者默认当前系统时间的毫秒数作为种子数:
        // Random r1 = new Random();
        // 种子数只是随机算法的起源数字，和生成的随机数的区间没有任何关系
        Random rand = new Random(25);
        System.out.println("rand.nextInt:"+rand.nextInt(100));// rand.nextInt(100);中的100是随机数的上限,产生的随机数为0-100的整数,不包括100

        // 对于种子相同的Random对象，生成的随机数序列是一样的。
        Random ran1 = new Random(10);
        System.out.println("使用种子为10的Random对象生成[0,10)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran1.nextInt(10) + " ");
        }
        System.out.println();
        Random ran2 = new Random(10);
        System.out.println("使用另一个种子为10的Random对象生成[0,10)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran2.nextInt(10) + " ");
        }
        System.out.println();

        // 在没带参数构造函数生成的Random对象的种子缺省是当前系统时间的毫秒数
        Random r3 = new Random();
        System.out.println("使用种子缺省是当前系统时间的毫秒数的Random对象生成[0,10)内随机整数序列");
        for (int i = 0; i < 10; i++) {
            System.out.print(r3.nextInt(10) + " ");
        }

        // 另外，直接使用Random无法避免生成重复的数字，如果需要生成不重复的随机数序列，需要借助数组和集合类
        ArrayList list = getDiffNO(10);
        System.out.println("产生的n个不同的随机数：" + list);

        Random r = new Random(25);
        // 生成[0,1.0)区间的小数：
        double d1 = r.nextDouble();
        System.out.println("生成[0,1.0)区间的小数："+d1);
        // 生成[0,5.0)区间的小数：
        double d2 = r.nextDouble() * 5;
        System.out.println("生成[0,5.0)区间的小数："+d2);
        // 生成[1,2.5)区间的小数：
        double d3 = r.nextDouble() * 1.5 + 1;
        System.out.println("生成[1,2.5)区间的小数："+d3);
        
        // 生成[0,10)区间的整数：
        int n2 = r.nextInt(10);// 方法一
        System.out.println("生成[0,10)区间的整数:"+n2);
        int n3 = Math.abs(r.nextInt() % 10);// 方法二
        System.out.println(n3);
    }

    /**
     * 生成n个不同的随机数，且随机数区间为[0,10)
     *
     * @param n
     * @return
     */
    private static ArrayList<Integer> getDiffNO(int n) {
        // 生成 [0-n) 个不重复的随机数
        // list 用来保存这些随机数
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;
    }
}