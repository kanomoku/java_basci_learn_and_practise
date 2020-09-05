package reflect_FanShe;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Reflect_Basic_MainTest {

    /**
     *
     */
    public static void main(String[] args) {
        //通过一个Class对象来操作Person.class类文件
        try {
            /**
             * 如何获取Class ----三种方式
             */
            //静态方法
            Class clazz = Class.forName("reflect_FanShe.Reflect_Person_Extends_Animal");
            //类名.class;
            Class c1 = Reflect_Person_Extends_Animal.class;
            //对象.getClass();//Object类中的方法
            Reflect_Person_Extends_Animal c2 = new Reflect_Person_Extends_Animal();
            Class clazz2 = c2.getClass();

            //获取包名
            Package p = clazz.getPackage();
            System.out.println("获取包名:" + p.getName());
            System.out.println("------------------------------------------------");

            //类自己有结构 权限修饰符 特征修饰符 类名字 继承 实现
            int midifiers = clazz.getModifiers();
            System.out.println("修饰符权限：" + midifiers);
            //0开始---0 1 2 4 8 16 32 64 128 256
            //0 默认不写
            //1 public
            //2 private
            //4 protected
            //8 static
            //16 final
            //32 synchronized
            //64 volatile
            //128 transient
            //256 native
            //512 interface
            //1024 abstract

            //获取类名字
            String name = clazz.getName();
            String simpleName = clazz.getSimpleName();
            System.out.println("获取包名+类名:" + name);
            System.out.println("获取类名:" + simpleName);

            //获取当前class 的父类
            ArrayList<String> list = new ArrayList<String>();
            Class clazz1z = list.getClass();
            while (clazz1z != null) {
                System.out.println("list包名+类名：" + clazz1z.getName());
                clazz1z = clazz1z.getSuperclass();
            }
            System.out.println("------------------------------------------------");

            //获取接口
            Class clazz1 = list.getClass();
            Class[] classes = clazz1.getInterfaces();
            for (Class c : classes) {
                System.out.println("list包名+实现的接口名：" + c.getName());
            }
            System.out.println("------------------------------------------------");

            /**
             * 赋值 取值
             */
            Field f = clazz.getDeclaredField("wife");
            Reflect_Person_Extends_Animal p3 = (Reflect_Person_Extends_Animal) clazz.newInstance();
            //赋值
            f.setAccessible(true);
            f.set(p3, "张紫涵");
            //取值
            String value = (String) f.get(p3);
            System.out.println("取出来赋的值：" + value);
            System.out.println("------------------------------------------------");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
