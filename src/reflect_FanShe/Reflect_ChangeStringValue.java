package reflect_FanShe;

import java.lang.reflect.Field;

public class Reflect_ChangeStringValue {
    public static void main(String[] args) throws Exception {
        String str = "abc";
        System.out.println( str );

        // 取得类
        Class clazz = str.getClass();
        //取得属性
        Field field = clazz.getDeclaredField( "value" );
        //设置私有属性可以被操作
        field.setAccessible( true );
        //修改属性
        //获取属性值 获取value 属性里面的值(内存地址)
        // private final char[] value = { 'a','b','c'}
        char[] temp = (char[]) field.get( str );
        //通过temp的地址引用 找到真实String对象中的数组  修改数字内的每一个元素
        temp[0] = '麻';
        temp[1] = '诗';
        temp[2] = '民';
        System.out.println( str );


    }
}
