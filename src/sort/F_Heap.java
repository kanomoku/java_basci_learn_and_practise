package sort;

import java.util.Arrays;

public class F_Heap {
    public static void main(String[] args) {

        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 2};
        upAdjust(array);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(array));
        int[] array1 = new int[]{5, 8, 6, 3, 9, 2, 1, 2};
        downAjust(array1);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(array1));
    }


    public static void upAdjust(int[] arr) {
        int childIndex = arr.length-1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = arr[childIndex];
        while (childIndex > 0 && arr[parentIndex] > temp) {
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        arr[childIndex] = temp;
    }

    //    public static void build(int[] arr){
//        for(int i=arr.length/2;i>=0;i--){
//            downAjust(arr,i,arr.length-1);
//        }
//    }
//    public static void downAjust(int[] arr,int parentIndex,int length) {
//        int tempValue = arr[parentIndex];
//        int childIndex = 2 * parentIndex + 1;
//            while (childIndex < length) {
//                if (childIndex < length - 1 && arr[childIndex] > arr[childIndex + 1]) {
//                    childIndex++;
//                }
//                if (tempValue <= arr[childIndex]) {
//                    break;
//                }
//                arr[parentIndex] = arr[childIndex];
//                parentIndex = childIndex;
//                childIndex = 2 * parentIndex + 1;
//            }
//            arr[parentIndex] = tempValue;
//    }
    public static void downAjust(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            int parentIndex = i;
            int childIndex = 2 * i + 1;
            int tempValue = arr[i];
            while (childIndex < arr.length) {
                if (childIndex + 1 < arr.length && arr[childIndex] > arr[childIndex + 1]) {
                    childIndex++;
                }
                if (tempValue < arr[childIndex]) {
                    break;
                }
                arr[parentIndex] = arr[childIndex];
                parentIndex = childIndex;
                childIndex = 2 * parentIndex + 1;
            }
            arr[parentIndex] = tempValue;
        }
    }

}
