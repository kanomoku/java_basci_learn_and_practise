package annotation_ZhuJie;

import java.io.Serializable;

public class Person_Override extends Animal_Override implements testInterface, Serializable {

//    对象的序列化 和反序列化
//    ObjectInputStream序列化  ObjectOutputStream反序列化
//    private static final long serialVersionID = 0;

//    @Override 会提示报错
    public void eat(String something) {
        System.out.println("perosn 重写的eat方法");
    }

    @Override//用来做代码的检测（验证）
    public void eat() {
        System.out.println("perosn 重写的eat方法");
    }

    @Override
    public void test() {
        System.out.println("perosn 重写的eat方法");
    }
}
