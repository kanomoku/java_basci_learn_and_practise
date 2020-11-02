package sort;

import com.sun.corba.se.impl.interceptors.SlotTableStack;

import java.io.StreamCorruptedException;
import java.util.*;

public class E_QuickSort {
    public static void main(String[] args) {

        int[] array = new int[]{5, 8, 2, 6, 3, 9, 2, 6, 1, 7};
        System.out.println("原始数据：");
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length - 1);
        System.out.println("最终结果：");
        System.out.println(Arrays.toString(array));
    }

//    public static void sort(int[] arr, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//        int povotIndex = partition(arr, start, end);
//        sort(arr, start, povotIndex - 1);
//        sort(arr, povotIndex + 1, end);
//    }

//    public static void sort(int[] arr, int start, int end) {
//        Stack<Map<String, Integer>> stack = new Stack<Map<String, Integer>>();
//        Map rootParam = new HashMap();
//        rootParam.put("start", start);
//        rootParam.put("end", end);
//        stack.push(rootParam);
//        while (!stack.isEmpty()) {
//            Map<String, Integer> param = stack.pop();
//            int pivotIndex = partition(arr, param.get("start"), param.get("end"));
//            if (param.get("start") < pivotIndex - 1) {
//                Map<String, Integer> leftParam = new HashMap<String, Integer>();
//                leftParam.put("start", param.get("start"));
//                leftParam.put("end", pivotIndex - 1);
//                stack.push(leftParam);
//            }
//            if (pivotIndex + 1 < param.get("end")) {
//                Map<String, Integer> rightParam = new HashMap<String, Integer>();
//                rightParam.put("start", pivotIndex + 1);
//                rightParam.put("end", param.get("end"));
//                stack.push(rightParam);
//            }
//        }
//    }

    /**
     * 挖坑法
     */
//    public static int partition(int[] arr, int start, int end) {
//        int left = start;
//        int right = end;
//        int index = start;
//        int pivot = arr[start];
//        while (left<right){
//            while (left<right){
//                if(arr[right]< pivot){
//                    arr[left] = arr[right];
//                    index=right;
//                    left++;
//                    break;
//                }
//                right--;
//            }
//            while (left<right){
//                if (arr[left]>pivot){
//                    arr[right]=arr[left];
//                    index=left;
//                    right--;
//                    break;
//                }
//                left++;
//            }
//        }
//        arr[index] = pivot;
//        System.out.println(Arrays.toString(arr));
//        return index;
//    }

    /**
     * 指针交换法
     */
//    public static int partition(int[] arr, int start, int end) {
//        int left = start;
//        int right = end;
//        int pivot = arr[start];
//        while (left < right) {
//            while (left < right && arr[right] > pivot) {
//                right--;
//            }
//            while (left < right && arr[left] <= pivot) {
//                left++;
//            }
//            if (left < right) {
//                int a = arr[left];
//                arr[left] = arr[right];
//                arr[right] = a;
//            }
//        }
//        int b = arr[left];
//        arr[left] = arr[start];
//        arr[start] = b;
//        System.out.println(Arrays.toString(arr));
//        return left;
//    }
    public static void sort(int[] arr, int start, int end) {

        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end);
        stack.push(map);
        while (!stack.isEmpty()) {
            Map<String, Integer> map1 = stack.pop();
            int povit = partition(arr, map1.get("start"), map1.get("end"));
            if (map1.get("start") < povit) {
                Map<String, Integer> map2 = new HashMap<>();
                map2.put("start", map1.get("start"));
                map2.put("end", povit-1);
                stack.push(map2);
            }
            if (map1.get("end") > povit) {
                Map<String, Integer> map3 = new HashMap<>();
                map3.put("start", povit + 1);
                map3.put("end", map1.get("end"));
                stack.push(map3);
            }
        }
    }

    public static int partition(int[] arr, int start, int end) {

        int left = start;
        int right = end;
        int temp = arr[start];
        while (left < right) {
            while (left < right && arr[right] > temp) {
                right--;
            }
            while (left < right && arr[left] <= temp) {
                left++;
            }
            if (left < right) {
                int a = arr[left];
                arr[left] = arr[right];
                arr[right] = a;
            }
        }
        int a = arr[start];
        arr[start] = arr[left];
        arr[left] = a;
        return left;
    }

}