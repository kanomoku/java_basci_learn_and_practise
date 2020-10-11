package sort;

import java.util.Arrays;

public class C_InsertSort {
    public static void main(String[] args) {

        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        sort(array);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }


}
