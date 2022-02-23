package ca.bytetube._00_leetcode.stack;

import ca.bytetube._00_leetcode.list.ListNode;

import java.util.Stack;

public class IsPalindrome {

    private static class Node{
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    //O(N)
    public static boolean isPalindrome1(Node head){
        if (head == null || head.next == null)  return true;
        if (head.next.next == null)return head.val == head.next.val;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        //匹配
        while(!stack.isEmpty()){
            int temp = stack.pop().val;
            if(temp != head.val) return false;
            head = head.next;
        }
        return true;

    }

    //O(N/2)
    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null)  return true;
        if (head.next.next == null)return head.val == head.next.val;
        Stack<Node> stack = new Stack<>();
        Node slow = head.next;
        Node fast = head;
        //1.找到链表的中心
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow来到中心
        while(slow != null){
            stack.push(slow);
            slow = slow.next;
        }

        //匹配
        while(!stack.isEmpty()){
            int temp = stack.pop().val;
            if(temp != head.val) return false;
            head = head.next;
        }

        return true;


    }

    /**
     * 1.利用快慢指针找到链表的中点
     * 2.反转右半部分
     * 3.分别让左右指针向中间靠近，进行回文判断
     * 4.恢复现场（再次反转右半部分）
     * @param head
     * @return
     */
    public static boolean isPalindrome(Node head){
        if (head == null || head.next == null)  return true;
        if (head.next.next == null)return head.val == head.next.val;

        //1.利用快慢指针找到链表的中点
        Node mid = getMidNode(head);
        //2.反转右半部分
        Node rHead = reverseList(mid.next);
        Node rOldHead = rHead;
        boolean res = true;
        // 3.分别让左右指针向中间靠近，进行回文判断
        Node lHead = head;

        while (rHead != null){
            if (lHead.val != rHead.val) {
                res = false;
                break;
//                return false;
            }
            lHead = lHead.next;
            rHead = rHead.next;
        }

        //4.恢复现场（再次反转右半部分）
        reverseList(rOldHead);
        return res;

    }

    private static Node getMidNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static Node reverseList(Node head){

        Node newHead = null;
        while (head != null){
            Node newNode = head.next;
            head.next = newHead;
            newHead = head;
            head = newNode;
        }

        return newHead;
    }


}
