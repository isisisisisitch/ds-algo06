package ca.bytetube._00_leetcode.list;

import ca.bytetube._02_list.List;

public class FindFirstInsertNode {

    public static ListNode findFirstInsertNode(ListNode head1,ListNode head2){
        if (head1 == null || head2 == null) return null;

        ListNode cycleNode1 = getCycleNode(head1);
        ListNode cycleNode2 = getCycleNode(head2);
        if (cycleNode1 == null && cycleNode2 == null) {//2个无环链表的相交问题
           return noCycle(head1,head2);
        }
        if (cycleNode1 != null && cycleNode2 != null) {//2个有环链表的相交问题
            return twoCycle(head1,cycleNode1,head2,cycleNode2);
        }

        return null;//1个无环链表和1个有环聊表的相交问题

    }
        //2个有环链表的相交问题
    private static ListNode twoCycle(ListNode head1, ListNode cycleNode1,ListNode head2, ListNode cycleNode2) {
        ListNode cur1 = null;
        ListNode cur2 = null;

        if (cycleNode1 == cycleNode2) {//第二种情况
            cur1 = head1;
            cur2 = head2;
            int difference = 0;//2个链表的长度差
            while (cur1.next != cycleNode1){
                difference++;
                cur1 = cur1.next;
            }
            while (cur2.next != cycleNode2){
                difference--;
                cur2 = cur2.next;
            }

            cur1 = difference > 0 ? head1 : head2;//cur1指向长链表
            cur2 = cur1 == head1 ? head2 : head1;//cur2指向短链表

            difference = Math.abs(difference);

            while (difference != 0){
                difference--;
                cur1 = cur1.next;
            }

            while (cur1 != cur2){//长短链表一起出发，当再次相遇时，就是第一个相交节点
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            return cur1;
        }else {//情况1/3
            cur1 = cycleNode1.next;
            while (cur1 != cycleNode1){
                if (cur1 == cycleNode2) {//情况3
                    return cycleNode1;
                }
                cur1 = cur1.next;
            }

            return null;//情况1
        }



    }

    private static ListNode noCycle(ListNode head1, ListNode head2) {
            ListNode cur1 = head1;
            ListNode cur2 = head2;
            int difference = 0;//2个链表的长度差
            while (cur1.next != null){
                difference++;
                cur1 = cur1.next;
            }
        while (cur2.next != null){
            difference--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2)  return null;

        cur1 = difference > 0 ? head1 : head2;//cur1指向长链表
        cur2 = cur1 == head1 ? head2 : head1;//cur2指向短链表

        difference = Math.abs(difference);

        while (difference != 0){
            difference--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2){//长短链表一起出发，当再次相遇时，就是第一个相交节点
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    public static ListNode getCycleNode(ListNode head){

        ListNode slow = head.next;

        ListNode fast = head.next.next;

        while (slow != fast){
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;

        }

        fast = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }


        return slow;
    }

    public static void main(String[] args) {

        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);

        // 0->9->8->6->7->null
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(findFirstInsertNode(head1, head2).val);

        // 1->2->3->4->5->6->7->4...
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(findFirstInsertNode(head1, head2).val);

        // 0->9->8->6->4->5->6..
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(findFirstInsertNode(head1, head2).val);
    }
}
