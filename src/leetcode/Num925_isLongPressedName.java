package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num925_isLongPressedName {
    public static void main(String[] args) {

        Boolean temp = isLongPressedName2("alex", "aaleex");
        System.out.println(temp);
    }


    public static boolean isLongPressedName1(String name, String typed) {
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


    public static boolean isLongPressedName2(String name, String typed) {
        int nameIndex = 0, typedIndex = 0;
        //因为typed的长度肯定大于name，所以外层用typed
        while (typedIndex < typed.length()) {
            if (nameIndex < name.length() && name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                nameIndex++;
                typedIndex++;
            } else if (typedIndex > 0 && typed.charAt(typedIndex) == typed.charAt(typedIndex - 1)) {
                typedIndex++;
            } else {
                return false;
            }
        }
        return nameIndex == name.length();// 防止name  naaaaaa 这种情况
    }


}


