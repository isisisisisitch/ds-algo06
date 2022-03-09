package ca.bytetube._05_binaryTree;

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

    public void preorderTraversalByRecursion(Node root){
        if (root == null) return;
        System.out.println(root.val);
        preorderTraversalByRecursion(root.left);
        preorderTraversalByRecursion(root.right);

    }


    public static void preorderTraversal(Node root) {
        if (root == null) return;
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                Node pop = stack.pop();
                System.out.println(pop.val);
                if (pop.right != null) stack.push(pop.right);
                if (pop.left != null) stack.push(pop.left);
            }
        }
    }


    public void inorderTraversalByRecursion(Node root){
        if (root == null) return;
        preorderTraversalByRecursion(root.left);
        System.out.println(root.val);
        preorderTraversalByRecursion(root.right);
    }


    public static void inorderTraversal(Node root) {
        if (root == null) return;
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null){
                if (root != null) {//left
                    stack.push(root);
                    root = root.left;
                }else {//right
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }

            }

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

        inorderTraversal(root);

    }

}
