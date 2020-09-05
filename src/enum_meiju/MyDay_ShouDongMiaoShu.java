package enum_meiju;

public class MyDay_ShouDongMiaoShu {//描述星期
    //类似单例模式的想法
    //构造方法私有
    private MyDay_ShouDongMiaoShu(){}
    //所有对象都是属性
    public static final MyDay_ShouDongMiaoShu MONDAY = new MyDay_ShouDongMiaoShu();
    public static final MyDay_ShouDongMiaoShu TUESDAY = new MyDay_ShouDongMiaoShu();
    public static final MyDay_ShouDongMiaoShu WEDNESDAY = new MyDay_ShouDongMiaoShu();
    public static final MyDay_ShouDongMiaoShu THURSDAY = new MyDay_ShouDongMiaoShu();
    public static final MyDay_ShouDongMiaoShu FRIDAY = new MyDay_ShouDongMiaoShu();
    public static final MyDay_ShouDongMiaoShu SATURDAY = new MyDay_ShouDongMiaoShu();
    public static final MyDay_ShouDongMiaoShu SUNDAY = new MyDay_ShouDongMiaoShu();

    //一般的属性 方法随便设计 这里只是控制只有这7个对象
}
