package reflect_annotation_spring;


import java.lang.annotation.*;


/**
 * 光定义还不够--还需要做很多细致的说明（需要利用Java提供好的注解来说明 这些就是元注解）
 * 元注解（也是注解 不是拿来使用的 是用来说明的）
 */

/**
 * 1.Target //用来描述当前的这个注解可以放在那里写的
 * 两种引入包的方式
 * 1.import java.lang.annotation.ElementType;
 *
 * @Target({ElementType.FIELD,ElementType.METHOD,ElementType.CONSTRUCTOR}) ;
 * 2.import static java.lang.annotation.ElementType.*;
 * @Target({FIELD,METHOD,CONSTRUCTOR});
 */
//import java.lang.annotation.ElementType;
//@Target({ElementType.FIELD,ElementType.METHOD,ElementType.CONSTRUCTOR})
import static java.lang.annotation.ElementType.*;

@Target({FIELD, METHOD, CONSTRUCTOR})// 英 [ˈtɑːɡɪt]

/**
 *2.@Retention 描述当前的这个注解存在什么作用域中的
 * 	写在源代码文件上(注释只存在这里)---->编译----->字节码文件----->加载----->内存执行
 * 	SOURSE                                         CLASS                     RUNTIME
 */
@Retention(RetentionPolicy.RUNTIME)//美 [rɪˈtenʃn]保持; 维持; 保留

/**
 *3.Inherited 描述当前这个注解是否能被子类对象继承--extends是扩展,这个才是继承
 * @Inhered 这样就能被继承了
 */
@Inherited//美 [ɪnˈherɪtɪd]继承(金钱、财产等); 经遗传获得(品质、身体特征等); 接替(责任等); 继任;

/**
 *说明该注解将被包含在javadoc中
 */
@Documented

@SuppressWarnings("all")//我自己加的 下面线太多 看起来乱

/**
 * 注解中可以携带信息--也可以什么都不携带
 * 信息不能随便写--信息的类型只能是如下的类型
 * 	1.基本数据类型
 * 	2.String类型
 * 	3.枚举类型enum
 * 	4.注解类型
 * 	5.数组类型[]---数组的内部需要时如上的四种类型
 */
public @interface Annotation_ZiDingYi {
    /**
     * 公有的静态的常量属性  可以描述这样描述属性 public static final 这样的属性比较少见
     */
    public static final String test = "mashimin";//静态常量属性

    /**
     * 可以描述公有的抽象的方法/可以描述public abstract的方法
     * 方法要求必须有返回值
     * 返回值的类型是如上那些(基本 String 枚举 注解 数组[数组的内部需要时如上的四种类型])---一般把 public abstract省略
     */
//    public abstract String value1();

    String[] value(); //方法  我们给他的信息传递给别人----->有的地方也叫属性  上面的真属性不常用

    String[] test() default "张紫涵";
}
//问题1.在注解里面描述了一个方法--方法没有参数---方法有返回值的String[],在使用注解的时候却又让我们传递参数,好奇怪.
//        理解为---注解的方法是做事的---将我们传递给他的参数--搬走给了别人---所以方法就要有返回值---把返回值给别人---所以我们传递参数的类型和方法返回值的类型相同
//问题2.为什么使用别人写好的注解不用写方法名--但是我们自己定义的方法必须写名字？
//        如果我们自己定义的注解--只有一个方法--方法名字叫value---在使用的时候就可以省略方法名
//        如果传递的信息是一个数组--数组内只有一个元素--是可以省略大括号的
//        如果方法是两个以上--每一个方法必须写名字