package collection_map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Property_Cycle_MainTest {
    public static void main(String[] args) {
        //Properties 是HashTable的子类 是一个map类型的集合  读取文件中的信息的---->更像是一个流-->高级流
        //读取的文件 文件后缀名.properties
        //文件中的内容是以key  value 的形式存在的
        // Java.util
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src//collection_map//Property.properties"));

            System.out.println("---------（方式一）------------");
            Set<Object> keys = properties.keySet();//返回属性key的集合
            for (Object key : keys) {
                System.out.println(key.toString() + "=" + properties.get(key));
            }
            System.out.println("---------（方式二）------------");
            Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();//返回的属性键值对实体
            for (Map.Entry<Object, Object> entry : entrySet) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
            System.out.println("---------（方式三）------------");
            Set<String> p = properties.stringPropertyNames();
            for (String key : p) {
                System.out.println(key + "=" + properties.getProperty(key));
            }

            System.out.println("---------（方式四）------------");
            Enumeration<?> e = properties.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = properties.getProperty(key);
                System.out.println(key + "=" + value);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


