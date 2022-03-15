package ca.bytetube._05_binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

    private static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public void preOrderTraversalByRecursion(Node root){
        if (root == null) return;
        System.out.print(root.val+" ");
        preOrderTraversalByRecursion(root.left);
        preOrderTraversalByRecursion(root.right);

    }


    public static void preOrderTraversal(Node root) {
        if (root == null) return;
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                Node pop = stack.pop();
                System.out.print(pop.val+" ");
                if (pop.right != null) stack.push(pop.right);
                if (pop.left != null) stack.push(pop.left);
            }
        }
    }


    public void inOrderTraversalByRecursion(Node root){
        if (root == null) return;
        inOrderTraversalByRecursion(root.left);
        System.out.print(root.val+" ");
        inOrderTraversalByRecursion(root.right);
    }


    public static void inOrderTraversal(Node root) {
        if (root == null) return;
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null){
                if (root != null) {//left
                    stack.push(root);
                    root = root.left;
                }else {//right
                    root = stack.pop();
                    System.out.print(root.val+" ");
                    root = root.right;
                }

            }

        }
    }


    public void postOrderTraversalByRecursion(Node root){
        if (root == null) return;
        postOrderTraversalByRecursion(root.left);
        postOrderTraversalByRecursion(root.right);
        System.out.print(root.val+" ");
    }


    public static void postOrderTraversal(Node root) {
        if (root == null) return;
        if (root != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()){
                Node pop = stack1.pop();
                stack2.push(pop);

                if (pop.left != null) stack1.push(pop.left);
                if (pop.right != null) stack1.push(pop.right);

            }

            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().val+" ");
            }
        }
    }


    public static void levelOrderTraversal(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.print(poll.val+" ");
            if (poll.left != null)  queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
    }


    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(3);
        levelOrderTraversal(root);


    }

}
