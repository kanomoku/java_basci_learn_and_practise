package sevenThunils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class EncodingTest {

    public static void read() throws Exception {
        String file = "D:/stream.txt";
        String charset = "UTF-8";
        OutputStreamWriter writer = null;
        // 写字符换转成字节流
        FileOutputStream outputStream = new FileOutputStream(file);
        writer = new OutputStreamWriter(outputStream, charset);
        writer.write("这是要保存的中文字符");
        writer.close();
        // 读取字节转换成字符
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuffer buffer = new StringBuffer();
        char[] buf = new char[64];
        int count = 0;
        try {
            while ((count = reader.read(buf)) != -1) {
                buffer.append(buf, 0, count);
            }
            System.out.println(buffer.toString());
        } finally {
            reader.close();
        }
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void encode() {
        String name = "I am 君山";
        System.out.println(name.toCharArray());
        try {
            byte[] iso8859 = name.getBytes("ISO-8859-1");
            System.out.println("iso8859: " + bytesToHexString(iso8859));
            byte[] gb2312 = name.getBytes("GB2312");
            System.out.println("GB2312: " + bytesToHexString(gb2312));
            byte[] gbk = name.getBytes("GBK");
            System.out.println("GBK: " + bytesToHexString(gbk));
            byte[] utf16 = name.getBytes("UTF-16");
            System.out.println("UTF-16: " + bytesToHexString(utf16));
            byte[] utf8 = name.getBytes("UTF-8");
            System.out.println("UTF-8: " + bytesToHexString(utf8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
//            read();
            encode();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
