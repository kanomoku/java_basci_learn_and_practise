package sort;

import java.util.Arrays;

public class A_BubbleSort {
    public static void main(String[] args) {

        int[] array = new int[]{5, 2, 8, 6, 3, 9, 2, 1, 7};
        sort(array);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(array));
    }

//    public static void sort(int[] arr){
//        for (int i=0;i< arr.length-1;i++){ //N个元素比较N-1轮
//            for(int j=0;j<arr.length-i-1;j++){
//                if(arr[j]>arr[j+1]){
//                    int a = arr[j];
//                    arr[j]= arr[j+1];
//                    arr[j+1]=a;
//                }
//            }
//            System.out.println(Arrays.toString(arr));
//        }
//    }

//    public static void sort(int[] arr){
//        for (int i=0;i< arr.length-1;i++){ //N个元素比较N-1轮
//            boolean isSorteed = true;
//            for(int j=0;j<arr.length-i-1;j++){
//                if(arr[j]>arr[j+1]){
//                    int a = arr[j];
//                    arr[j]= arr[j+1];
//                    arr[j+1]=a;
//                    isSorteed = false;
//                }
//            }
//            if(isSorteed){
//                break;
//            }
//            System.out.println(Arrays.toString(arr));
//        }
//    }

//    public static void sort(int[] arr) {
//        int endIndex = arr.length - 1;//  无界数据边界   因为是所有轮共用的所以拿到外面来
//        int lastIndex = arr.length - 1;
//        for (int i = 0; i < arr.length - 1; i++) { //N个元素比较N-1轮
//            boolean isSorteed = true;
//            for (int j = 0; j < endIndex; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int a = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = a;
//                    isSorteed = false;
//                    lastIndex = j;
//                }
//            }
//            endIndex = lastIndex;
//            if (isSorteed) {
//                break;
//            }
//            System.out.println(Arrays.toString(arr));
//        }
//    }

    public static void sort(int[] arr) {
        int end = arr.length - 1;
        int temp = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    int a = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = a;
                    isSort = false;
                    temp = j;
                }
            }
            if (isSort) {
                break;
            }
            end = temp;
        }
    }

}
