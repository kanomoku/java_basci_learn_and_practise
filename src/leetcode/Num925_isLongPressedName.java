package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num925_isLongPressedName {
    public static void main(String[] args) {

        Boolean temp = isLongPressedName("alex", "aaleex");
        System.out.println(temp);
    }


    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {// 判断条件遇到+1,-1等时候一定要注意边界处理
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}


