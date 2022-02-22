package ca.bytetube._00_leetcode.list;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * @author dal
 */
public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;//address

        }


        return false;
    }

}
