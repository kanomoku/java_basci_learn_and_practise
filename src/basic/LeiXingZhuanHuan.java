package basic;

public class LeiXingZhuanHuan {
    public static void main(String[] args) {

        // String--> Int
        int i = Integer.parseInt("123");
        System.out.println(i);

        int i1 = Integer.valueOf("123").intValue();
        System.out.println(i1);

        int i2 = Integer.valueOf("123");
        System.out.println(i2);

        // Int --> String
        String str = String.valueOf(123);
        System.out.println(str);

        String str1 = Integer.toString(123);
        System.out.println(str1);

        String str2 = "" + i;
        System.out.println(str2);
    }
}