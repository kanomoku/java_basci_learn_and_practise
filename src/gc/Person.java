package gc;

public class Person {
    public Person() {
        System.out.println("person被创建了");
    }

    //默认继承Object
    //hashCode equals toString getClass wait notity notifyAll clone
    //finalize OBject类中的一个protected方法
    public void finalize() {
        System.out.println("person对象被回收了");
    }
}
