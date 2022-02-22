package ca.bytetube._00_leetcode.list;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * @author dal
 */
public class ReverseLinkedList_206 {

    public ListNode reverseListByRecursion(ListNode head) {
        if (head == null|| head.next == null)  return head;

        ListNode newHead = reverseListByRecursion(head.next);//1
        head.next.next = head;//4->5
        head.next = null;//5->null
        return newHead;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null|| head.next == null)  return head;

        ListNode newHead = null;
        while (head != null){
            ListNode newNode = head.next;
            head.next = newHead;
            newHead = head;
            head = newNode;
        }

        return newHead;
    }



}
