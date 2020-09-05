package reflect_FanShe;

import java.lang.reflect.Constructor;

public class Reflect_Costructor_MainTest {
    public static void main(String[] args) {
        try {
            //找到Person对应的class
            Class clazz = Reflect_Person_Extends_Animal.class;

            //构造方法
            Constructor con = clazz.getConstructor();//获取无参数构造方法
            Constructor con1 = clazz.getConstructor(String.class);//获取有参数构造方法
            Constructor[] cons = clazz.getConstructors();//获取所有的构造方法
            Constructor conabstract = clazz.getDeclaredConstructor();
            Constructor conabstract1 = clazz.getDeclaredConstructor(String.class);
            Constructor[] conabstracts = clazz.getDeclaredConstructors();

            //执行构造方法
            //相当于调用了Reflect_Person_Extends_Animal 类中默认的无参数构造方法创建对象
            Reflect_Person_Extends_Animal p = (Reflect_Person_Extends_Animal) con.newInstance();
            Reflect_Person_Extends_Animal p1 = (Reflect_Person_Extends_Animal) con1.newInstance("name");
            System.out.println("con.newInstance()  " + p);
            System.out.println("con1.newInstance(\"name\")  " + p1);
            System.out.println("------------------------------------------------");

            int i = con.getModifiers();
            String name = con.getName();
            Class[] parameterTypes = con.getParameterTypes();
            Class[] exceptionTypes = con.getExceptionTypes();
            System.out.println(i);
            System.out.println(name);
            System.out.println(parameterTypes);
            System.out.println(exceptionTypes);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
