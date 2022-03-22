package ca.bytetube._05_binaryTree;

import ca.bytetube._05_binaryTree.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> implements BinaryTreeInfo {
    protected Node root;
    protected int size;

    /**
     * number of elements
     */
    int size() {
        return size;
    }

    /**
     * if it is empty or not
     */

    boolean isEmpty() {
        return size == 0;
    }

    /**
     * clear all elements
     */

    void clear() {
        root = null;
        size = 0;
    }


    public Node<E> predecessor(Node<E> node) {
        if (node == null) return node;

        //1.node.left != null
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }

            return p;
        }
        //2.node.left == null && node.parent!=null
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        //node.left == null && node == node.parent.right
        return node.parent;
    }


    public Node<E> successor(Node<E> node) {
        if (node == null) return node;

        //1.node.right != null
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }

            return p;
        }
        //2.node.right == null && node.parent!=null
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        //node.right == null && node == node.parent.left
        return node.parent;
    }


    public void preOrderTraversal(Node<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public void inOrderTraversal(Node<E> root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.element + " ");
        inOrderTraversal(root.right);
    }


    public void postOrderTraversal(Node<E> root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.element + " ");
    }


    public void levelOrderTraversal(Node<E> root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print(root.element + " ");
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
    }

    public int height1() {
        return height1(root);
    }

    public int height1(Node<E> node) {
        if (node == null) return 0;

        return 1 + Math.max(height1(node.left), height1(node.right));
    }



    public int height() {
        return height(root);
    }

    public int height(Node<E> node) {
        if (node == null) return 0;
        int height = 0;
        int levelSize = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        levelSize = 1;
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            levelSize--;
            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            }

            if (levelSize == 0) {//意味着即将访问下一层
                height++;
                levelSize = queue.size();
            }
        }

        return height;

    }

    public boolean isComplete(Node<E> root){
        if (root == null) return false;

        boolean leaf = false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            //如果leaf status = true，之后遇到的所有节点必须都是叶节点
            if (leaf && !node.isLeaf()) return false;

            if (node.hasChildren()) {//1
                queue.offer(node.left);
                queue.offer(node.right);
            }
           else if (node.left == null && node.right != null)  return false;//2

            else  if (node.left != null && node.right == null) {//3
                queue.offer(node.left);
                leaf = true;

            }

            //4  node.left == null && node.right == null
            else  leaf = true;


        }

        return true;
    }





    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        BinarySearchTree.Node<E> myNode = ((BinarySearchTree.Node<E>) node);
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.toString();
        }

        return myNode.element + "_p(" + parentString + ")";
    }


    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }


        @Override
        public String toString() {
            return element + "";
        }

        public boolean hasChildren() {
            return this.left != null && this.right != null;
        }

        public boolean isLeaf(){
           return this.left == null && this.right == null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,4,9,2,5,8,11,1,3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        boolean res = bst.isComplete(bst.root);
        System.out.println();
    }
}
