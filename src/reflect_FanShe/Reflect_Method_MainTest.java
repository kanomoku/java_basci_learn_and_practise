package reflect_FanShe;

import java.lang.reflect.Method;

public class Reflect_Method_MainTest {
    public static void main(String[] args) {
        try {
            //获取Reflect_Person_Extends_Animal对应的Class
            Class clazz = Reflect_Person_Extends_Animal.class;

            //获取Class中的方法:通过clazz获取方法--通过方法名字定位方法--通过方法参数类型对应的Class来确定具体的方法
            Method m = clazz.getMethod("eat", String.class);//获取一个String类型参数的公有方法(自己类+父类)
            Method m1 = clazz.getMethod("eat");//获取无参数的公有方法(自己类+父类)
            Method[] ms = clazz.getMethods();//获取所有公有的方法(自己类+父类)
            //以上方法只能获取公有的方法--但是包含继承过来的父类的方法
            //如何取得私有方法呢？
            Method m2 = clazz.getDeclaredMethod("drink", String.class);//获取一个有String类型参数的公有/私有方法(自己类)
            Method m3 = clazz.getDeclaredMethod("drink");//获取一个无参数的公有/私有方法(自己类)
            Method[] ms4 = clazz.getDeclaredMethods();//获取全部的公有/私有方法(自己类)
            //如上的方法能获取公有和私有的方法---但是只能获取本类的方法
            //获取的方法包含方法的全部信息----包含方法的  权限修饰符  特征修饰符 返回值类型 方法名 参数 异常

            int mm = m.getModifiers();//获取修饰符--权限--特征
            Class mr = m.getReturnType();//获取返回值数据类型的
            String mn = m.getName();//获取方法的名字
            Class[] mpts = m.getParameterTypes();//获取方法参数列表的类型
            Class[] mets = m.getExceptionTypes();//获取方法抛出异常的类型
            System.out.println("获取方法修饰符--权限--特征:" + mm);
            System.out.println("获取方法返回值数据类型的:" + mr);
            System.out.println("获取方法的名字:" + mn);
            System.out.println("获取方法参数列表的类型:" + mpts);
            System.out.println("获取方法抛出异常的类型:" + mets);
            System.out.println("------------------------------------------------");

            //执行方法
            Reflect_Person_Extends_Animal person = (Reflect_Person_Extends_Animal) clazz.newInstance();
            m1.invoke(person);//执行无参数方法
            String s = (String) m.invoke(person, "娃哈哈");//执行有参数的方法
            System.out.println("------------------------------------------------");

//            Method sleep = clazz.getMethod("sleep");//找不到就会抛出异常 IllegalArgumentException
//            m.invoke(person);

            Method testPrivate = clazz.getDeclaredMethod("testPrivate");// 获取一个的方法（权限 + 特征）
            System.out.println(testPrivate.getName());
            testPrivate.setAccessible(true);//若方法是私有的--不允许操作---可以设置方法的使用权
            testPrivate.invoke(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
