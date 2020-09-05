package reflect_FanShe;

import java.lang.reflect.Field;

public class Reflect_Field_MainTest {
    public static void main(String[] args) {
        try {
            Class clazz = Reflect_Person_Extends_Animal.class;

            // 属性
            Field[] fields = clazz.getFields();//可以获取所有公有的属性--包括继承过来的
            for (Field f : fields) {
                System.out.println("公有属性名字：" + f.getName());
            }
            System.out.println("------------------------------------------------");
            Field nameField = clazz.getField("name");//获取属性：这是知道属性名字--所以很局限
            System.out.println("特定公有属性名字：" + nameField.getName());
            System.out.println("------------------------------------------------");
            //以上两个方法只能获取公有的属性--但是包含继承过来的父类的属性
            //如何取得私有的属性呢？

            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field f : declaredFields) {
                System.out.println("私有属性名字：" + f.getName());
            }
            System.out.println("------------------------------------------------");

            Field declaredField = clazz.getDeclaredField("name");
            System.out.println("特定私有属性名字：" + declaredField.getName());
            //如上的两个方法能获取公有的和私有的属性---但是只能获取本类的属性
            System.out.println("------------------------------------------------");

            int modifiers = nameField.getModifiers();//获取属性的修饰符
            System.out.println("获取属性的修饰符:" + modifiers);
            Class fclass = nameField.getType();//获取属性的类型
            System.out.println("获取属性的类型:" + fclass.getName());
            String fname = nameField.getName();//获取属性的名字
            System.out.println("获取属性的名字:" + fname);
            System.out.println("------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}