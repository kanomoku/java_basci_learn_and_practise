package xiancheng_join;

import java.util.Date;

public class Join_Lock_ThreadOne extends Thread {
    public void run(){
        System.out.println("thread_one start:"+ new Date());
        Join_Lock_ThreadTwo two = new Join_Lock_ThreadTwo();
        two.start();
        try {
            two.join(2000);//线程2加入到线程1里
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread_one end:"+ new Date());
    }
}
