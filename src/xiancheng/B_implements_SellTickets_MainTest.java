package xiancheng;

public class B_implements_SellTickets_MainTest {
    public static void main(String[] args) {
        B_implements_SellTickets myThread = new B_implements_SellTickets();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();

//        B_implements_SellTickets myThread1 = new B_implements_SellTickets();
//        B_implements_SellTickets myThread2 = new B_implements_SellTickets();
//        new Thread(myThread1).start();
//        new Thread(myThread2).start();
    }
}
