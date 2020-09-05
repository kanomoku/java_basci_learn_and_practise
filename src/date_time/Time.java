package date_time;

public class Time {

    public Time() {
    }

    public static void main(String[] args) {

        // 纳秒
        // ns（nanosecond）：纳秒， 时间单位。一秒的10亿分之一，即等于10的负9次方秒。常用作 内存读写速度的单位。
        // 1纳秒=0.000001 毫秒
        // 1纳秒=0.00000 0001秒
        // 1秒=1000毫秒
        // 1毫秒=100,0000纳秒
        //
        // java的System.currentTimeMillis()和System.nanoTime()区别:
        //
        // java中System.nanoTime()返回的是纳秒，nanoTime而返回的可能是任意时间，甚至可能是负数……
        // java中System.currentTimeMillis()返回的毫秒，这个毫秒其实就是自1970年1月1日0时起的毫秒数.
        //
        // 两个方法都不能保证完全精确,精确程度依赖具体的环境.
        long startTime = System.nanoTime();
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
        }
        long endTime = System.nanoTime();
        long endTime1 = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(duration);
        long duration1 = endTime1 - startTime1;
        System.out.println(duration1);
    }
}
