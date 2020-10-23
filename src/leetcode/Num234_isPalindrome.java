package leetcode;

import java.util.*;

public class Num234_isPalindrome {
    private static ListNode frontPointer;

    public static void main(String[] args) {
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

    private static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
