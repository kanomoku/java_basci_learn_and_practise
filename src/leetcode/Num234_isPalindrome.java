package leetcode;

import java.util.*;

public class Num234_isPalindrome {
    private static ListNode frontPointer;

    public static void main(String[] args) {
        System.out.println(isPalindrome3());
    }

    public static boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }
        Boolean res = true;
        for (int i = 0; i < (list.size() / 2); i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                res = false;
            }
        }
        return res;
    }

    public static boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome3() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        Boolean res = true;
        for (int i = 0; i < (list.size() / 2); i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                res = false;
            }
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
