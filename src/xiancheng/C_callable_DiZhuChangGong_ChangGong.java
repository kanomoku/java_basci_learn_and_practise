package xiancheng;

import java.util.concurrent.Callable;

// 长工类：
// 长工类实现了Callable接口，线程运行完成后返回一个Integer值。
public class C_callable_DiZhuChangGong_ChangGong implements Callable<Integer> {

    private int hours = 3;
    private int amount;

    @Override
    public Integer call() throws Exception {
        while (hours > 0) {
            System.out.println(Thread.currentThread().getName() + " I'm still working on it......");
            amount++;
            hours--;
            Thread.sleep(1000);
        }
        return amount;
    }
}