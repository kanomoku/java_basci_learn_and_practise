package xiancheng_synchronized;
public class Synchronized_Object_ThreadC extends Thread {
    private Synchronized_Object_ObjectService objectService;

    public Synchronized_Object_ThreadC(Synchronized_Object_ObjectService objectService) {
        super();
        this.objectService = objectService;
    }
    @Override
    public void run() {
        objectService.methodC();
    }
}
