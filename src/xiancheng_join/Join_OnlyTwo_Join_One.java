package xiancheng_join;

//两个线程合并成一个线程
public class Join_OnlyTwo_Join_One extends Thread {
    public void run() {
        System.out.println("thread_one start");
        Join_OnlyTwo two = new Join_OnlyTwo();
        two.start();
        try {
//            two.join();//线程2加入到线程1里
            two.join(2000);//就等2000毫秒 超过就不等了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread_one end");
    }
}
