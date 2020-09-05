package string_buffer_builder;

public class StringBuffer_MainTest {
    public static void main(String[] args) {

        StringBuffer StringBuffer = new StringBuffer();//无参数的构造方法 构建一个默认长度16个空间的对象 char[]
        StringBuffer StringBuffer1 = new StringBuffer(29);//利用给定的参数 构建一个自定义长度空间的对象 char[]
        StringBuffer StringBuffer2 = new StringBuffer("abc");//利用带String参数的构造方法 构建一个默认数组长度=字符串长度+16个


        StringBuffer StringBuffer4 = new StringBuffer("1234");
        System.out.println("StringBuffer4.capacity():" + StringBuffer4.capacity());//20 是16+4
        System.out.println("StringBuffer4.length():" + StringBuffer4.length());//4
        System.out.println("···························");

        StringBuffer StringBuffer5 = new StringBuffer("abcdefg");
        System.out.println("StringBuffer5.length():" + StringBuffer5.length());//7
        System.out.println("StringBuffer5.capacity():" + StringBuffer5.capacity());//23  是16+7
        System.out.println("···························");

        StringBuffer StringBuffer6 = new StringBuffer("abcdefg");
        StringBuffer6.setLength(15);
        System.out.println("StringBuffer6.length():" + StringBuffer6.length());//15
        System.out.println("StringBuffer6.capacity():" + StringBuffer6.capacity());//23
        System.out.println("···························");
        StringBuffer6.trimToSize();
        System.out.println("StringBuffer6.length():" + StringBuffer6.length());//15
        System.out.println("StringBuffer6.capacity():" + StringBuffer6.capacity());//15
        System.out.println("···························");

        StringBuffer StringBuffer7 = new StringBuffer("");
        StringBuffer7.setLength(15);
        System.out.println("StringBuffer7.length():" + StringBuffer7.length());//15
        System.out.println("StringBuffer7.capacity():" + StringBuffer7.capacity());//16
        System.out.println("···························");
        StringBuffer7.trimToSize();
        System.out.println("StringBuffer7.length():" + StringBuffer7.length());//15
        System.out.println("StringBuffer7.capacity():" + StringBuffer7.capacity());//15
        System.out.println("···························");

    }
}
