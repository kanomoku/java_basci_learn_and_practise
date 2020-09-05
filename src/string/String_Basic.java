package string;

public class String_Basic {

    /**
     * String的不可变性
     * 在类中包含了一个数组--->private final char[] value--->存储String中的每一个字符
     * final--->代表最终的不可改变的--->地址不让动-->只能指向那块内存空间--->数组的长度是本身不可变的--->所以得到变量value指向固定空间且空间长度是固定的
     * private私有的--->当前类中才可以访问--->从类外部获取不到数组的值也没有办法给数组赋值--->数组中的内容也不能改变了
     * 所以不可变性体现在两个方面--->
     * 字符数组长度-final修饰数组--final修饰数组的地址不能变---数组长度本身不变---必须指向一块大小固定的内存----所以长度无法改变--避免了新的内存地址赋值给他
     * 内容---私有修饰符---不能在当前类以外访问--->所以不能操作他---避免了去改变内容
     */
    public static void main(String[] args) {
        String s1 = "abc"; //存储在常量区里
        String s2 = "abc"; //存储在常量区里和上面是一个
        String s3 = new String("abc");//堆内存里创建了一个对象
        String s4 = new String("abc");//堆内存里创建了一个对象
        System.out.println(s1 == s2);//true 因为是常量区里同一个常量
        System.out.println(s1 == s3);//false 不是同一个对象
        System.out.println(s3 == s4);//false 不是同一个对象
        System.out.println(s1.equals(s2));//true String把equal方法重写了--现在比较的是字符值
        System.out.println(s1.equals(s3));//true
        System.out.println(s3.equals(s4));//true
        /**
         * String是类 "abc"是对象
         * ==可以比较基本数据类型也可以比较引用数据类型 (基本数据类型就比值 引用数据类型就比地址)
         * equals (Object类中的方法 默认==) 如果想改变比较规则 可以重写equals方法 比如String Integer
         */
        System.out.println("-------------------------------------------------------");

        /**
         *构造方法
         */
        //*1. String()-- > 其实就是 String s2 = ""
        String s8 = new String();
        String s9 = "";
        //*2. String( byte[] bytes)
        String s5 = new String(new byte[]{65, 97, 48}); //Aa0
        System.out.println(s5);
        //3. String( byte[] bytes, Charset charset)
        //4. String( byte[] ascii, int hibyte)  //Deprecated.
        //5. String( byte[] bytes, int offset, int length)
        //6. String( byte[] bytes, int offset, int length, Charset charset)
        //7. String( byte[] ascii, int hibyte, int offset, int count) //Deprecated.
        //8. String( byte[] bytes, int offset, int length, String charsetName)
        //9. String( byte[] bytes, String charsetName)
        //10. String( char[] value)
        String str = new String(new char[]{'A', 'a', '0'}); //Aa0
        //11. String( char[] value, int offset, int count)
        char[] value = {'A', 'a', '0', '1'};
        String s6 = new String(value, 1, 3); //a01 偏移量--后面的是取得几个
        String s7 = new String(new char[]{'A', 'a', '0'}, 1, 2);//a0
        System.out.println(s7);
        //12. String( int[] codePoints, int offset, int count)
        String s10 = new String(new int[]{65, 97, 48}, 1, 2); //a0
        System.out.println("s10 " + s10);
        //String s12 = new String(new int[]{65, 97, 48}, 1, 3); //java.lang.StringIndexOutOfBoundsException: String index out of range: 4
        //System.out.println("s12" + s12);
        //13. String(String original) //其实就是String s1 = "abc"
        String s11 = new String("abc");
        //14. String(StringBuffer buffer)
        //15. String(StringBuilder builder)
        System.out.println("-------------------------------------------------------");


        String s24 = "abcdefgabc";
        int index = s24.indexOf("a");
        System.out.println(index);
        System.out.println("-------------------------------------------------------");


        String s25 = "张紫涵很美丽，张紫涵很美丽";
        s25 = s25.replace("很", "狠");
        s25 = s25.replace("的", "哈");
        s25 = s25.replace("美丽", "迷人");
        s25 = s25.replaceAll("美丽", "迷人");
        System.out.println(s25);
        System.out.println("-------------------------------------------------------");

        String 时6 = "a-b-c-d";
        String[] value1 = 时6.split("-", 133);
        for (String v : value1) {
            System.out.println(v);// a b-c-d
        }
        System.out.println("-------------------------------------------------------");

        /**
         *         1.boolean = equals(Object obj);继承自Object 但是重写了 重写他的时候通常也重写hashCode
         *           equalsIgnoreCase(String anotherString)忽略大小写
         */
        /**
         *        2. int i = str.hashCode();
         *         继承自Object
         *         "abc"
         *         h = h * 31 + 97-- - (0 * 31 + 97)
         *         h = h * 31 + 98-- - (0 * 31 + 97) * 31 + 98
         *         h = h * 31 + 99-- - ((0 * 31 + 97) * 31 + 98) * 31 + 99
         */

        /**
         *    3.int i = compareTo(String str); 实现自Compare接口 实现了这个方法  按照字典(Unicode编码)索引的顺序进行比较
         * 	    //先找寻两个字符串长度较短的那个作为比较循环的次数
         *         //挨个比较元素 str1[i]-str2[i] 循环内如果有结果就输出结果
         *         //如果循环过后发现所有的字符都一样  length1-length2 用长度去减
         * 		compareToIgnoreCase(String str)
         */
        String s13 = "abc";
        String s12 = "abe";
        System.out.println(s13.compareTo(s12));
        System.out.println("-------------------------------------------------------");

        /**
         *    4.toString();继承自Object
         */
        String_Basic testString = new String_Basic();
        System.out.println(testString); //teststring.TestString@1540e19d
        String str1 = new String("abc");
        System.out.println(str1);//abc
        //理论上应该都是地址 为什么下面会是abc呢？ 明显的是重写了toString()方法
        System.out.println("-------------------------------------------------------");

        /**
         *	5.char c = "abc".charAt(int indes); "abc" //返回给定index对应位置的那个char值
         * 	 int a = "abc".codePointAt(int indes);"abc" //返回给定index对应位置的那个char值所对应的code码(unicode码)
         */
        //加密小例子
        String s14 = "abcdef";
        String result = "";
        String result1 = "";
        for (int i = 0; i < s14.length(); i++) {
            int ii = s14.codePointAt(i);
            result += (char) (ii - 48);//秘钥 U盾
            result1 += ii + "-";
        }
        System.out.println(result);//123456
        System.out.println(result1);//97-98-99-100-101-102
        char c1 = "abc".charAt(0);//a
        System.out.println(c1);
        int a = "abc".codePointAt(0);//97
        System.out.println(a);
        System.out.println("-------------------------------------------------------");

        /**
         *        6.length();返回字符串的长度
         *         数组---length属性
         *         list----size()方法
         *         String--length()方法
         */

        /**
         *7.concat()将给定的字符串拼接到当前的字符串后面
         */
        String s16 = "abcdef";
        s16.concat("g");
        System.out.println(s16);//abcdef 体现String的不可变性
        //要创建一个新的String对象 (字符串常量池) value属性 7个
        //刚才那个String对象value值依次取出来  存入新对象的value属性 g放在后面
        String s17 = s16.concat("g");
        System.out.println(s17);//abcdefg
        System.out.println("-------------------------------------------------------");

        String s18 = "a" + "b" + "c" + "d";
        System.out.println(s18);
        //过程中产生了几个String对象？字符串常量池的话是7个
        // a b ab c abc d abcd
        System.out.println("-------------------------------------------------------");

        //        long time1 = System.currentTimeMillis();
//        String s19 = "a";
//        for (int i = 0; i <= 200000; i++) {
//            s19 += "a";
//
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2 - time1);  //14414
//
//        long time3 = System.currentTimeMillis();
//        String s20 = "a";
//        for (int i = 0; i <= 200000; i++) {
//            s20 = s20.concat("a");
//
//        }
//        long time4 = System.currentTimeMillis();
//        System.out.println(time4- time3);  //7458
//        System.out.println("-------------------------------------------------------");

        /**
         *contains(CharSequence s)//参数可以是String StirngBuffer StringBuilder 判断给定的s是否在字符串中
         */
        String s21 = "abcdefg";
        //判断此字符串里时候含有a
        System.out.println(s21.contains("a"));
        System.out.println("-------------------------------------------------------");

        /**
         *	9.startsWith(String prefix) //判断此字符串是否以什么什么开头
         * 	  endsWith(String suffix) //判断此字符串是否以什么什么结尾
         */
        String s22 = "Java.java";
        System.out.println(s22.startsWith("Java"));
        System.out.println(s22.endsWith(".java"));//电脑上扫描 所有.java后缀名的源文件
        System.out.println("-------------------------------------------------------");

        /**
         *	10.byte[] =getBytes() 将当前字符串转化成数组
         * 	   char[] =toCharArray()
         * 	  "中文的话"  到char[]没有问题  但是byte[]不行 四个中文会变成8个字节 所以需要字符集 有重构的方法 getBytes(Charset charset)
         */
        String s23 = "abcdefg";
        byte[] b = s23.getBytes();
        for (byte v : b) {
            System.out.print(v + "~"); //97~98~99~100~101~102~103~
        }
        System.out.println();

        for (byte v : b) {
            System.out.print((char) v + "~");//a~b~c~d~e~f~g~
        }
        System.out.println();

        char[] c = s23.toCharArray();
        for (char v : c) {
            System.out.print(v + "~");//a~b~c~d~e~f~g~
        }
        System.out.println();

        for (char v : c) {
            System.out.print((int) v + "~");//97~98~99~100~101~102~103~
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");


        /**
         *	11.
         *     	int = indexOf(int ch) //indexOf(98) 找寻给定的元素在字符串中第一次出现的索引的位置  找不到就返回-1
         * 	         indexOf(int ch, int fromIndex) //indexOf(98, 3) 从第fromIndex号索引开始找包含fromIndex位置  不管从哪里开始寻找 返回的index都是相对于整个String的
         * 			 indexOf(String str) //indexOf("abc")
         * 			 indexOf(String str, int fromIndex) //indexOf("a", 3)
         * 		    lastIndexOf(int ch) //找寻给定元素在字符串中最后出现的位置 若不存在则返回-1
         * 			lastIndexOf(int ch, int fromIndex)
         * 			lastIndexOf(String str)
         * 			lastIndexOf(String str, int fromIndex)
         */

        /**
         *	12.isEmpty()  判断当前字符串是否为空  是否为""  也就是说.length()==0
         * 	   String str = null； 这是空引用
         * 	   注意与null之间的区别
         */
        /**
         *	13.
         *     replace(char oldChar, char newChar) //str = str.replace("很","狠"); 将给定的字符串替换成另外的字符串
         * 	   replace(CharSequence target, CharSequence replacement)  //str = str.replace("美丽","迷人");
         * 	   replaceAll(String regex, String replacement)
         * 	   replaceFirst(String regex, String replacement) //只能换第一次出现的那个元素
         */
        /**
         *	14.split(String regex)限度 界限 方法是按照给定的表达式将原来的字符串拆分开的"a-b-c-d" "-" regex 表示可以添加正则的表达式 有规律的 表达式   regular expression
         * 	   split(String regex, int limit)
         */
        String s26 = "a-b-c-d";
        String[] value2 = s26.split("-");
        for (String v : value2) {
            System.out.println(v);// a b c d
        }
        System.out.println();

        String s27 = "a-b-c-d";
        String[] value3 = s27.split("-",3);// 最多可以拆成4块 不管写多少都只能拆成最多的那个
        for (String v : value3) {
            System.out.println(v);// a b-c-d
        }
        System.out.println();
        /**
         *	15.substring(int beginIndex) 当前字符串截取一部分 从这开始到末尾
         * 	   substring(int beginIndex, int endIndex) 从这开始都哪里结束 左闭右开区间
         */
        /**
         *	16.toLowerCase() 当前的字符串全部转大写
         * 	   toUpperCase() 当前的字符串全部转小写
         */
        /**
         *	17.trim() 去掉字符串前面和后面的多余的空格 中间的不行
         */
        /**
         *	18.
         *     valueOf(boolean b)
         * 	   valueOf(char c)
         * 	   valueOf(char[] data)
         * 	   valueOf(char[] data, int offset, int count)
         * 	   valueOf(double d)
         * 	   valueOf(float f)
         * 	   valueOf(int i)
         * 	   valueOf(long l)
         * 	   valueOf(Object obj)
         */
        /**
         *19.boolean = match(String regex);
         */

    }
}
