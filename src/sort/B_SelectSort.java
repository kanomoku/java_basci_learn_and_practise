package sort;

import java.util.Arrays;

public class B_SelectSort {
    public static void main(String[] args) {

        int[] array = new int[]{5, 2, 8, 6, 3, 9, 2, 1, 7};
//        sort(array);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(array));
    }

//    public static void sort(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            int minIndex = i;
//            for (int j = arr.length - 1; j > i; j--) {
//                if (arr[j] < arr[minIndex]) {
//                    tempIndex = j;
//                }
//            }
//            int temp = arr[i];
//            arr[i] = arr[minIndex];
//            arr[minIndex] = temp;
//            System.out.println(Arrays.toString(arr));
//        }
//    }

    //    public static void sort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            int temp = arr[i];
//            arr[i] = arr[minIndex];
//            arr[minIndex] = temp;
//            System.out.println(Arrays.toString(arr));
//        }
//    }

}
