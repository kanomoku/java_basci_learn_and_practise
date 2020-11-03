package sort;

import java.util.Arrays;

public class D_ShellSort {
    public static void main(String[] args) {

        int[] array = new int[]{5, 8, 2, 6, 3, 9, 2, 1, 7};
//        sort(array);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(array));
    }

//    public static void sort(int[] arr) {
//        for (int d = arr.length / 2; d > 0; d /= 2) {
//            for (int w = 0; w < d; w++) {
//                for (int i = w + d; i < arr.length; i += d) {
//                    int temp = arr[i];
//                    int j = i - d;
//                    for (; j >= 0 && arr[j] > temp; j -= d) {
//                        arr[j + d] = arr[j];
//                    }
//                    arr[j + d] = temp;
//                    System.out.println(Arrays.toString(arr));
//                }
//            }
//        }
//    }

//    public static void sort(int[] arr) {
//        int d = arr.length;
//        while (d > 1) {
//            d /= 2;
//            for (int w = 0; w < d; w++) {
//                for (int i = w + d; i < arr.length; i += d) {
//                    int temp = arr[i];
//                    int j = i - d;
//                    for (; j >= 0 && arr[j] > temp; j -= d) {
//                        arr[j + d] = arr[j];
//                    }
//                    arr[j + d] = temp;
//                    System.out.println(Arrays.toString(arr));
//                }
//            }
//        }
//    }
}
