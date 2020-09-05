package xiancheng_join;

import java.util.Date;

public class Join_Lock_ThreadTwo extends Thread {
    public void run() {
        System.out.println("thread_two start:"+ new Date());
        Join_Lock_ThreadThree three = new Join_Lock_ThreadThree(this);
        three.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread_two end:"+ new Date());
    }
}
