package array;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */

/**
 * @author Administrator
 *
 */
public class Array_Basic {

    public static void main(String[] args) {

//         testArrayInitialization_toString();
//         testArrayCycle();
//         testArray_TurnInto_List_Set();
//        Test_Array_Search();

        // 转换int值为字节数组
        // 缓冲区(Buffer)就是在内存中预留指定大小的存储空间用来对输入/输出(I/O)的数据作临时存储，这部分预留的内存空间就叫做缓冲区
        // 从堆空间中分配一个容量大小为capacity的byte数组作为缓冲区的byte数据存储器
        byte[] bytes = ByteBuffer.allocate(4).putInt(100).array();
        for (byte t : bytes) {
            System.out.format("0x%x ", t); // 0x0 0x0 0x0 0x5a
        }


    }


    private static void testArray_TurnInto_List_Set() {
        String s2[] = {"wyy", "wzz", "wxx", "wxx"};
        List<String> list = new ArrayList<>(Arrays.asList(s2));
        System.out.println(list.toString());
        list.add("whh");
        System.out.println(list.toString());

        Set<String> set = new HashSet<>(Arrays.asList(s2));
        System.out.println(set.toString());
        set.add("wxx");
        System.out.println(set.toString());

        // 首先HashMap和HashSet判断重复都是执行对象的hashcode和equals方法，如果遇到重复值HashMap会用新值替换旧值，而HashSet不会。
        // 也就是说HashMap的旧值会被覆盖（使用put方法会返回旧值），而HashSet的旧值不会被覆盖（遇到重复值会返回false）
        // 通俗的说，Map会覆盖，Set会拒绝
    }

    private static void testArrayCycle() {
        int[] s5 = new int[]{7, 3, 2, 8, 9};
        for (Integer s : s5) {
            System.out.print(s);
        }
        System.out.println();
        for (int i = 0; i < s5.length; i++) {
            System.out.print(s5[i]);
        }
    }

    private static void testArrayInitialization_toString() {
        //Initialization 1
        String[] s1 = new String[4];
        Arrays.fill(s1, "wyy");
        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println(s1.toString());
        System.out.println(Arrays.toString(s1));

        //Initialization 2
//        String s2[] = { "wyy", "wzz", "wxx", "wxx" };
        String[] s2 = {"wyy", "wzz", "wxx", "wxx"};
        System.out.println(Arrays.toString(s2));

        // Initialization 3
        String[] s3 = new String[]{"zyy", "zxx", "zww"};
        System.out.println(Arrays.toString(s3));
    }

    private static void Test_Array_Search() {
        String[] s2 = {"wyy", "wzz", "wxx", "wxx"};
        boolean a = LoopSearch(s2, "wyy");
        boolean b = LoopSearch(s2, "wy");
        boolean c = binarySearch(s2, "wyy");
        boolean d = binarySearch(s2, "wy");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public static boolean LoopSearch(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue))
                return true;
        }
        return false;
    }

    public static boolean binarySearch(String[] arr, String targetValue) {
        //二分法查找先查找数组中间的元素，如果找到就返回数组中该元素的下标，如果没找到就返回-插入点-1
//        比如  int[] a = {1,3,5,7,8,9}; int b = 10; 返回的是-7:（插入点下标为6，返回-6-1 就是-7）
        int j = Arrays.binarySearch(arr, targetValue);
        if (j >= 0) {
            return true;
        } else
            return false;
    }
}
