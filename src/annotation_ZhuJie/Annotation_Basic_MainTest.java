package annotation_ZhuJie;

import java.util.Date;

/**
 * @Deprecated    //用来说明方法是废弃的
 * @override     //用来做代码的检测（验证） 检测此方法是否是一个重写的方法
 * @SuppressWarnings(信息)--//里面的信息是--Sring[] {"",""}--如果数组内的元素只有一个长度--可以省略大括号
 *   unused //变量定以后未被使用
 *   serial //类实现了序列化接口--不添加序列化ID号
 *   rawtypes //提示集合没有定义泛型
 *   deprecation //方法已废弃--可以不出这个警告了
 *   unchecked //出现了泛型的问题可以不检测 Enumeration en = properties.propertyNames();一直报警告--编码解决不了的问题
 *   all    //包含了以上所有 但是不推荐使用
 *   除了unchecked 别的不推荐使用---从代码完善上去解决
 */
public class Annotation_Basic_MainTest {
    public static void main(String[] args) {
        //做说明 废弃的方法
        Date date1 = new Date(2000, 1, 1);//当前系统日期

        //变量定以后未被使用
        @SuppressWarnings("unused")
        String str = "abd";

    }
}
