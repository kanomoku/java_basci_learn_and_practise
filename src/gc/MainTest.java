package gc;

public class MainTest {
    public static void main(String[] args) {
        Person p = new Person();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p = null;
        System.gc();//我只是告诉他去回收 至于是不是立刻回收就说的不算了

    }

}
