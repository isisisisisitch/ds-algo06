package ca.bytetube._00_leetcode.list;

public class ClassifyList {



    public static ListNode classifyList(ListNode head,int pivot){
        ListNode lessHead = null;//less
        ListNode lessTail = null;

        ListNode equalHead = null;//equal
        ListNode equalTail = null;

        ListNode moreHead = null;//more
        ListNode moreTail = null;

        ListNode next = null;

        while (head != null){
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (lessHead == null) {
                    lessHead = head;
                    lessTail = head;

                }else {
                    lessTail.next = head;
                    lessTail = head;
                }

            }
            else if (head.val == pivot) {
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;

                }else {
                    equalTail.next = head;
                    equalTail = head;
                }


            }else {
                if (moreHead == null) {
                    moreHead = head;
                    moreTail = head;

                }else {
                    moreTail.next = head;
                    moreTail = head;
                }

            }

            head = next;

        }

        //less reconnect equal
        if (lessTail != null) {
            lessTail.next = equalHead;
            equalTail = equalTail == null ? lessTail : equalTail;
        }

        //equal reconnect more
        if (equalTail != null) {
            equalTail.next = moreHead;

        }

        return lessHead != null ? lessHead : equalHead != null ? equalHead : moreHead;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(70);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(-4);
        head1.next.next.next.next.next = new ListNode(11);
        head1.next.next.next.next.next.next = new ListNode(90);
        ListNode newHead = classifyList(head1, 9);


    }
}
