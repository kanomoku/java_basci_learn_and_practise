package sort;

import java.util.Arrays;

public class F_HeapSort {
    public static void main(String[] args) {

        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 2};
        System.out.println("原始：");
        System.out.println(Arrays.toString(array));
//        downBuildHeap(array);
        System.out.println("构建二叉堆：");
        System.out.println(Arrays.toString(array));
        System.out.println("堆排序：");
//        for (int i = array.length - 1; i > 0; i--) {
//            int a = array[0];
//            array[0] = array[i];
//            array[i] = a;
//            System.out.println("hsh :" + Arrays.toString(array));
//            downAjust(array, 0, i);
//            System.out.println(Arrays.toString(array));
//        }


    }


//    public static void downBuildHeap(int[] arr) {
//        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
//            downAjust(arr, i, arr.length);
//        }
//    }
//    public static void downAjust(int[] arr, int parentIndex, int length) {
//        int childIndex = 2 * parentIndex + 1;
//        int tempValue = arr[parentIndex];
//        while (childIndex < length) {
//            if (childIndex < length - 1 && arr[childIndex] > arr[childIndex + 1]) {
//                childIndex++;
//            }
//            if (tempValue < arr[childIndex]) {
//                break;
//            }
//            arr[parentIndex] = arr[childIndex];
//            parentIndex = childIndex;
//            childIndex = 2 * parentIndex + 1;
//        }
//        arr[parentIndex] = tempValue;
//    }
}
