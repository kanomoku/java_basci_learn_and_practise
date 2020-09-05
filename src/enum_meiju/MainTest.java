package enum_meiju;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {

//        自己手动描述的类
        MyDay_ShouDongMiaoShu day = MyDay_ShouDongMiaoShu.SATURDAY;//day类中访问了一个对象 7个
        //枚举类
        Day day1 = Day.Friday;
//        day1--->枚举类型对象 默认继承Object
//        除了继承Object类的方法外 还有一些 compareTo getDeClearingClass name 说明还默认继承了别的类---Enum
//        我们自己定义的每一个enum类型 都会默认继承Enum Enum继承Object 所以间接继承Object

        Day d = day1.valueOf("Monday");
        System.out.println(d.name() + d.ordinal()+d.getName()+d.getIndex());

        Day[] ds = Day.values();
        for (Day dd : ds) {
            System.out.println(dd.name() + dd.ordinal());
        }

        //输入一个字符串monday  输出对应信息
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个星期的单词");
        String key = input.nextLine();
        Day day2 = Day.valueOf(key);
        switch (day2) {//1.5之前 int byte short char 1.6增加了enum 1.7增加了String
            case Monday:
                System.out.println("星期一");
                break;
            case Tuesday:
                System.out.println("星期二");
                break;
            default:
                System.out.println("默认值");
        }
    }
}
