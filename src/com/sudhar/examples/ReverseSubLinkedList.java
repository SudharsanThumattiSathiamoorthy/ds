package com.sudhar.examples;

public class ReverseSubLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(5);

       // ListNode head = reverseBetween(l1, 2, 4);
        ListNode head = reverseBetween(l2, 1, 2);

        traverseList(head);
    }

    private static void traverseList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        if (m - n == 0) {
            return head;
        }

        if (m == 1) {
            return reverse(head, m, n);
        }

        int count = 1;

        ListNode prev = null, curr = head;

        while (head != null && count < m) {
            prev = head;
            head = head.next;
            count++;
        }

        ListNode temp = reverse(head, m, n);
        prev.next = temp;

        return curr;
    }

    private static ListNode reverse(ListNode head, int m, int n) {
        ListNode curr = head;

        ListNode prev = null, temp = null;

        while (head != null && m <= n) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;

            m++;
        }

        curr.next = head;

        return prev;
    }
}
