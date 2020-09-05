package basic;

public class Runtime_Memory {
    public static void main(String[] args) {

//        Runtime r = new Runtime();
//        发现会报错
//        分析原因：
//        1.抽象类 或者 接口 2.无参数的构造方法没有 3构造方法私有了(单例模式 自己写的枚举类)
//        发现Runtime是个饿汉式的单例模式

        Runtime r = Runtime.getRuntime();
        long max = r.maxMemory();//整个堆内存空间 = 保留的+ 可用的+空闲的
        long total = r.totalMemory();//可以用的
        long free = r.freeMemory();//空闲的
        System.out.println("整个堆内存空间maxMemory" + max);
        System.out.println("可以用的totalMemory" + total);
        System.out.println("空闲的freeMemory" + free);
        System.out.println("```````````````````````````");

        byte[] b = new byte[10000000];
        long max1 = r.maxMemory();
        long total1 = r.totalMemory();
        long free1 = r.freeMemory();
        System.out.println("整个堆内存空间maxMemory:" + max1);
        System.out.println("可以用的totalMemory:" + total1);
        System.out.println("空闲的freeMemory:" + free1);
        System.out.println("```````````````````````````");

//        byte[] b1 = new byte[(int) max / 2];
        byte[] b1 = new byte[114191752];
        long max2 = r.maxMemory();
        long total2 = r.totalMemory();
        long free2 = r.freeMemory();
        System.out.println("整个堆内存空间maxMemory :" + max2);
        System.out.println("可以用的totalMemory :" + total2);
        System.out.println("空闲的freeMemory :" + free2);
        System.out.println("```````````````````````````");

//        byte[] b2 = new byte[(int) max / 2];
//        long max3 = r.maxMemory();
//        long total3 = r.totalMemory();
//        long free3 = r.freeMemory();
//        System.out.println("整个堆内存空间" + max3);
//        System.out.println("可以用的" + total3);
//        System.out.println("空闲的" + free3);
    }

}
