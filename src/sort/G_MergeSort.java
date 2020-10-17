package sort;

import java.util.Arrays;

/**
 * 合并排序/归并排序
 */
public class G_MergeSort {
    public static void main(String[] args) {

        int[] array = new int[]{5, 8, 2, 6, 3, 9, 2, 1, 7};
//        sort(array, 0, array.length - 1);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(array));
    }


//    public static void sort(int[] arr, int start, int end) {
//        if (start < end) {
//            int mid = (start + end) / 2;
//            sort(arr, start, mid);
//            sort(arr, mid + 1, end);
//            merge(arr, start, mid, end);
//        }
//
//    }
//
//    public static void merge(int[] arr, int start, int mid, int end) {
//        int[] tempArray = new int[end - start + 1];
//        int p1 = start;
//        int p2 = mid + 1;
//        int p = 0;
//        while (p1 <= mid && p2 <= end) {
//            if (arr[p1] < arr[p2]) {
//                tempArray[p++] = arr[p1++];
//            } else {
//                tempArray[p++] = arr[p2++];
//            }
//        }
//        while (p1 <= mid) {
//            tempArray[p++] = arr[p1++];
//        }
//        while (p2 <= end) {
//            tempArray[p++] = arr[p2++];
//        }
//        for (int i = 0; i < tempArray.length; i++) {
//            arr[start + i] = tempArray[i];
//        }
//    }


}


