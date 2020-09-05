package string_buffer_builder;

public class StringBuilder_MainTest {

    /**
     * 知识总结
     * 1.StringBuilder类不一定需要 是为了避免String频繁拼接修改字符串信息的时候才用的 底层数组是可变的  提高了性能
     * 2.常用方法
     * 与String不同的独有的方法
     * append  insert  delete deleteCharAt reverse
     * 与String相同的方法
     * length charAt codePointAt indexOf lastIndexOf substring replace只是名字相同用法不同
     * 不是很常用的方法
     * capacity  ensureCapacity setLength  timeToSize setCharAt
     * 3.String家族笔试中的考察的知识点
     *      1.String的包 继承 接口
     *      2.String构建方式
     *      3.String对象内存结构
     *           字符串常量区 new堆内存对象
     *           ==  和  equals 区别
     *           "a"+"b"+"c"
     *     4.String不可变性
     *       长度及内容
     *     5.String中常用的方法----与StringBuilder的区别
     *       独有的方法 concat toUpperCase
     *     6.String和StringBuilder/StringBuffer区别
     *         String不可变字符串
     *        JKD1.0版本
     *        有一个接口Compare
     *        不可变体现在长度和内容
     *        有一些方法StringBuilder/StringBuffer没有 concat compareTo toUpperCase
     *
     *        StringBuilder可变字符串
     *        JDK1.5版本
     *        有一个接口Appendable
     *        可变字符串 没有final修饰 底层可以进行数组扩容
     *        有一些方法String没有 append insert delete reverseAndConcate
     *
     *     7.StringBuffer和StringBuilder的区别
     *     StringBuffer 1.0版 StringBuilder 1.5版本出来的 方法几乎一致
     *     早期版本 线程同步  安全性比较高  执行效率相对较低
     *     后期版本 线程异步  安全性比较低  执行效率相对较高
     */
    public static void main(String[] args) {
        /**
         *构造方法
         */
        StringBuilder stringBuilder = new StringBuilder();//无参数的构造方法 构建一个默认长度16个空间的对象 char[]
        StringBuffer sb2 = new StringBuffer("def");
        StringBuilder stringBuilder3 = new StringBuilder(sb2);
        StringBuilder sb0 = new StringBuilder("def");
        StringBuilder stringBuilder8 = new StringBuilder(sb0);
        StringBuilder stringBuilder1 = new StringBuilder(29);//利用给定的参数 构建一个自定义长度空间的对象 char[]
        StringBuilder stringBuilder2 = new StringBuilder("abc");//利用带String参数的构造方法 构建一个默认数组长度=字符串长度+16个

        /**
         *length 和 容量
         */
        StringBuilder stringBuilder4 = new StringBuilder("1234");
        System.out.println("stringBuilder4.capacity():" + stringBuilder4.capacity());//20 是16+4
        System.out.println("stringBuilder4.length():" + stringBuilder4.length());//4
        System.out.println("···························");
        StringBuilder stringBuilder5 = new StringBuilder("abcdefg");
        System.out.println("stringBuilder5.length():" + stringBuilder5.length());//7
        System.out.println("stringBuilder5.capacity():" + stringBuilder5.capacity());//23  是16+7
        System.out.println("···························");

        StringBuilder stringBuilder6 = new StringBuilder("abcdefg");
        stringBuilder6.setLength(15);
        System.out.println("stringBuilder6.length():" + stringBuilder6.length());//15
        System.out.println("stringBuilder6.capacity():" + stringBuilder6.capacity());//23
        System.out.println("···························");
        stringBuilder6.trimToSize();
        System.out.println("stringBuilder6.length():" + stringBuilder6.length());//15
        System.out.println("stringBuilder6.capacity():" + stringBuilder6.capacity());//15
        System.out.println("···························");

        StringBuilder stringBuilder7 = new StringBuilder("");
        stringBuilder7.setLength(15);
        System.out.println("stringBuilder7.length():" + stringBuilder7.length());//15
        System.out.println("stringBuilder7.capacity():" + stringBuilder7.capacity());//16
        System.out.println("···························");
        stringBuilder7.trimToSize();
        System.out.println("stringBuilder7.length():" + stringBuilder7.length());//15
        System.out.println("stringBuilder7.capacity():" + stringBuilder7.capacity());//15
        System.out.println("···························");

        /**
         *        1.append
         *        StringBuilder append(int i)
         *        StringBuilder append(long lng)
         *        StringBuilder append(float f)
         *        StringBuilder append(double d)
         *        StringBuilder	append(boolean b)
         *        StringBuilder	append(char c)
         *        StringBuilder	append(char[] str)
         *        StringBuilder	append(char[] str, int offset, int len)
         *        StringBuilder	append(CharSequence s)
         *        StringBuilder	append(CharSequence s, int start, int end)
         *        StringBuilder append(Object obj)
         *        StringBuilder append(String str)
         */
        StringBuilder sb = new StringBuilder("abc").append("--");
        sb.append(5).append("--");//append(int i)
        sb.append(55L).append("--");//append(long i)
        sb.append(60.9F).append("--");//append(float i)
        sb.append(60.9D).append("--");//append(double i)
        sb.append(false).append("--");//append(boolean b)
        sb.append('d').append("--");//append(char c)
        sb.append(new char[]{'d', 'd', 'd', 'd'}).append("--");//append(char[] str)
        sb.append(new char[]{'d', 'e', 'f', 'g'}, 0, 3).append("--"); //append(char[] str, int offset, int len),从第0号索引开始取3个单位长度
        StringBuffer sb3 = new StringBuffer("ikl").append("--");
        sb.append(sb3).append("--");//append(CharSequence s)
        StringBuilder sb4 = new StringBuilder("edc");
        sb.append(sb4).append("--");//append(CharSequence s)
        StringBuffer sb5 = new StringBuffer("yhnm");
        sb.append(sb5, 1, 3).append("--"); //append(CharSequence s, int start, int end) 范围是左闭右开区间
        StringBuilder_MainTest aa = new StringBuilder_MainTest();
        sb.append(aa).append("--");//append(Object obj)
        sb.append("字符串");//append(String str)
        System.out.println(sb.toString());
        System.out.println("···························");

        /**
         *	2.
         *	int = capacity() //返回底层数组的容量
         * 	int = length() //字符串有效元素个数
         * 	void = setLength(int newLength) //设置字符串有效字符个数
         * 	ensureCapacity(int minimumCapacity) //确保底层数组容量够用
         */


        /**
         *	3.
         * 	void = setCharAt(int index, char ch) //将给定index位置的字符改成给定的ch
         *	charAt(int index)
         * 	StringBuilder = deleteCharAt(int index) //String中没有的方法 将给定index位置的某一个字符删除掉
         * 	codePointAt(int index)
         * 	String = substring(int start)
         * 	String = substring(int start, int end) //左闭右开区间 注意需要接受返回值
         * 	indexOf(String str)
         * 	indexOf(String str, int fromIndex)
         * 	lastIndexOf(String str)
         * 	lastIndexOf(String str, int fromIndex)
         * 	StringBuilder = delete(int start, int end) //左闭右开区间 StringBuilder独有的方法 String中是没有的   将start和end之间的字符串删除 不用接收返回值就可以看到效果了
         */
        StringBuilder s1 = new StringBuilder("abcdefg");
        s1.setCharAt(0, 'z');//void = setCharAt(int index, char ch)
        System.out.println(s1.toString());
        System.out.println(s1.charAt(1));//charAt(int index)
        System.out.println(s1.deleteCharAt(1));//StringBuilder = deleteCharAt(int index)
        System.out.println(s1.codePointAt(1));//codePointAt(int index)
        System.out.println("···························");
        s1 = new StringBuilder("abcdefg");
        System.out.println(s1.substring(1));//String = substring(int start)
        System.out.println(s1.substring(1, 4));//String = substring(int start, int end)左闭右开
        System.out.println(s1.delete(2, 4));//StringBuilder = delete(int start, int end)左闭右开
        System.out.println("AA···························");
        s1 = new StringBuilder("abcdefg");
        System.out.println(s1.indexOf("bc"));//indexOf(String str)
        System.out.println(s1.indexOf("bcc"));//indexOf(String str)
        System.out.println(s1.indexOf("de", 2));//indexOf(String str, int fromIndex)
        System.out.println(s1.indexOf("de", 3));//indexOf(String str, int fromIndex)
        System.out.println(s1.indexOf("de", 4));//indexOf(String str, int fromIndex)
        System.out.println("A············");
        s1 = new StringBuilder("abcdefgf");
        System.out.println(s1.lastIndexOf("f"));//lastIndexOf(String str)
        System.out.println(s1.lastIndexOf("fe"));//lastIndexOf(String str)
        System.out.println(s1.lastIndexOf("ef"));//lastIndexOf(String str)
        System.out.println("············");
        s1 = new StringBuilder("123456789");
        System.out.println(s1.lastIndexOf("678"));//lastIndexOf(String str)
        System.out.println(s1.lastIndexOf("678", 4));//lastIndexOf(String str, int fromIndex)
        System.out.println(s1.lastIndexOf("678", 5));//lastIndexOf(String str, int fromIndex)
        System.out.println("···························");

        /**
         *	4.
         * 	insert(int offset, int i)
         * 	insert(int offset, long l)
         * 	insert(int offset, float f)
         * 	insert(int offset, double d)
         *	insert(int offset, boolean b)  返回值都是StringBuilder
         * 	insert(int offset, char c)
         * 	insert(int offset, char[] str)
         * 	insert(int index, char[] str, int offset, int len)
         * 	insert(int dstOffset, CharSequence s)
         * 	insert(int dstOffset, CharSequence s, int start, int end)
         * 	insert(int offset, Object obj)
         * 	insert(int offset, String str)
         */
        StringBuilder sb1 = new StringBuilder("abc").insert(0, "--");
        sb1.insert(0, 5).insert(0, "--");//insert(int i)
        sb1.insert(0, 55L).insert(0, "--");//insert(long i)
        sb1.insert(0, 60.9F).insert(0, "--");//insert(float i)
        sb1.insert(0, 60.9D).insert(0, "--");//insert(double i)
        sb1.insert(0, false).insert(0, "--");//insert(boolean b)
        sb1.insert(0, 'd').insert(0, "--");//insert(char c)
        sb1.insert(0, new char[]{'d', 'd', 'd', 'd'}).insert(0, "--");//insert(char[] str)
        sb1.insert(0, new char[]{'d', 'e', 'f', 'g'}, 0, 3).insert(0, "--"); //insert(char[] str, int offset, int len),从第0号索引开始取3个单位长度
        StringBuffer sb6 = new StringBuffer("ikl");
        sb1.insert(0, sb6).insert(0, "--");//insert(CharSequence s)
        StringBuilder sb7 = new StringBuilder("edc");
        sb1.insert(0, sb7).insert(0, "--");//insert(CharSequence s)
        StringBuffer sb8 = new StringBuffer("yhnm");
        sb1.insert(0, sb8, 1, 3).insert(0, "--"); //insert(CharSequence s, int start, int end) 范围是左闭右开区间
        StringBuilder_MainTest aaa = new StringBuilder_MainTest();
        sb1.insert(0, aaa).insert(0, "--");//insert(Object obj)
        sb1.insert(0, "字符串");//insert(String str)
        System.out.println(sb1.toString());
        System.out.println("···························");
        /**
         *        5.StringBuilder 	replace(int start, int end, String str)  //start到end的部分替换成str
         */
        StringBuilder sb10 = new StringBuilder("0123456789");
        sb10.replace(1, 3, "abcd");//左闭右开
        System.out.println(sb10);//0abcd3456789
        /**
         *6.StringBuilder = reverse()
         */

        StringBuilder sb11 = new StringBuilder("0123456789");
        sb11.reverse();
        System.out.println(sb11);//9876543210
        /**
         *7.String = toString() //将StringBuilder对象构建成String对象
         */

        /**
         *8.void = trimToSize() //将数组中无用的容量去掉 -- 变成length长度的数组
         */
    }
}
