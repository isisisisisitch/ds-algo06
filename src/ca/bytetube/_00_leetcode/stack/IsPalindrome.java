package ca.bytetube._00_leetcode.stack;

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
    public static boolean isPalindrome(Node head){
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


}
