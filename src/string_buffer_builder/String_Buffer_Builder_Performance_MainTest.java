package string_buffer_builder;

public class String_Buffer_Builder_Performance_MainTest {
    public static void main(String[] args) {
        int totalcount = 100000;
        long time1 = System.currentTimeMillis();
        String str = "a";
        for (int i = 0; i <= totalcount; i++) {
            str += "a";
        }
        long time2 = System.currentTimeMillis();
        System.out.println("String+=:" + (time2 - time1));  //14012

        long time3 = System.currentTimeMillis();
        String str1 = "a";
        for (int i = 0; i <= totalcount; i++) {
            str1 = str1.concat("a");
        }
        long time4 = System.currentTimeMillis();
        System.out.println("str1.concat:" + (time4 - time3));  //6552

        StringBuilder stringBuilder3 = new StringBuilder();
        long time5 = System.currentTimeMillis();
        String str2 = "a";
        for (int i = 0; i <= totalcount; i++) {
            stringBuilder3.append("a");
        }
        stringBuilder3.toString();
        long time6 = System.currentTimeMillis();
        System.out.println("stringBuilder3:" + (time6 - time5));//15

        StringBuffer stringBuffer = new StringBuffer();
        long time7 = System.currentTimeMillis();
        String str3 = "a";
        for (int i = 0; i <= totalcount; i++) {
            stringBuffer.append("a");
        }
        stringBuffer.toString();
        long time8 = System.currentTimeMillis();
        System.out.println("stringBuffer:" + (time8 - time7));//16
    }
}
//理论上StringBuffer是比StringBuilder更快的