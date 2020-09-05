package reflect_annotation_spring;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
//美 [ˌænəˈteɪʃn注解; 评注; 注文; 释文
public class Annotation_ZiDingYi_MainTest {
    public static void main(String[] args) {
        try {
            //解析Person类  属性上面的注解信息 需要用到反射的技术
            //1.获取Person对应的Class
            Class clazz = Annotation_ZiDingYi_Person.class;
            //2.通过clazz获取里面的属性
            Field field = clazz.getDeclaredField("name");

            //正常的对象的调用的方式
            //3.通过field获取上面的注解对象
            Annotation_ZiDingYi a = (Annotation_ZiDingYi) field.getAnnotation(Annotation_ZiDingYi.class);
            //4.利用a对象 执行一下value方法  帮我们搬运过来
            String[] values = a.value();
            for (String value : values) {
                System.out.println("A  " + value);
            }

            //3.通过field获取上面的注解对象
            Annotation annotation = field.getAnnotation(Annotation_ZiDingYi.class);
            //4.利用反射执行annotation的value方法
            Class aclazz = annotation.getClass();//对象去获取它对应的class
            //5.通过aclazz获取里面的value方法
            Method amethod = aclazz.getMethod("value");
            //6.执行value的方法， 获取传递的信息
            String[] avalues = (String[]) amethod.invoke(annotation);
            //7.展示一下values里面的信息
            for (String value : values) {
                System.out.println("B  " + value);
            }

            //获取Person类中 方法上面的注解的信息
            Class mclazz = Class.forName("reflect_annotation_spring.Annotation_ZiDingYi_Person");
            Method method = mclazz.getMethod("eat");
            Annotation annotation1 = method.getAnnotation(Annotation_ZiDingYi.class);
            Class class1 = annotation1.getClass();
            Method method1 = class1.getMethod("value");
            String[] valuess = (String[]) method1.invoke(annotation1);
            for (String s : valuess) {
                System.out.println("C  " + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
