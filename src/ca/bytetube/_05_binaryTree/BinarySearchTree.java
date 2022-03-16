package ca.bytetube._05_binaryTree;

import ca.bytetube._05_binaryTree.printer.BinaryTreeInfo;

import java.util.Comparator;

public class BinarySearchTree<E> implements BinaryTreeInfo {
    private Node root;
    private int size;

    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     *  number of elements
     */
    int size() {
        return size;

    }

    /**
     *  if it is empty or not
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

    /**
     *  add elements
     */
    void add(E element) {
        //1.对元素做非空判断
        elementNotNullCheck(element);
        //2.1添加第一个节点
        if (root == null) {
            root = new Node(element,null);
            size++;
            return;
        }
        //2.2 不是添加第一个节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null){
            cmp = compare(element,node.element);
            parent = node;
            if (cmp > 0) node = node.right;

           else if (cmp < 0)   node = node.left;
           else {
                node.element = element;
                return;
            }
        }
        //3.确定新节点插入的位置（插入在其父节点的left 还是 right）
        Node<E> newNode = new Node<>(element,parent);
        if (cmp > 0)   parent.right = newNode;
        else parent.left = newNode;
        size++;
    }



    /**
     * remove elements
     */
   public void remove(E element) {
        remove(node(element));
    }


    private void remove(Node<E> node){
        if (node == null) return;
        size--;

        //删除degree = 2
        if (node.hasChildren()) {
            Node<E> s = successor(node);
            node.element = s.element;
            node = s;
        }

        //删除degree = 1
        Node<E> replacement = node.left != null ? node.left : node.right;
        //完成双亲相认
        if (replacement != null) {
            //更新replacement parent
            replacement.parent = node.parent;
            if (node.parent == null) {
                root = replacement;
            }
            if (node == node.parent.left) {
                node.parent.left = replacement;
            }else {
                node.parent.right = replacement;
            }
        }

        //删除degree = 0
        else if (node.parent == null) {
            root = null;
        }else {
            if (node == node.parent.left) {
                node.parent.left = null;
            }else {
                node.parent.right = null;
            }
        }


    }

    /**
     * does it contain an element or not
     */
    boolean contains(E element) {
        return node(element) != null;
    }


    //e1 > e2 ---> >0
    //e1 < e2 ---> <0
    //e1 = e2 ---> 0
    private int compare(E e1, E e2) {
        if (comparator != null)  return comparator.compare(e1,e2);
        return  ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) throw  new IllegalArgumentException("element can not be null !");
    }


    private Node<E> node(E element) {
        Node<E> node = root;
        int cmp = 0;
        while (node != null){
            cmp = compare(element,node.element);

            if (cmp > 0) node = node.right;

            else if (cmp < 0)   node = node.left;
            else {
                node.element = element;
                return node;
            }
        }

        return null;

    }
    public Node<E> predecessor(E element){
       return predecessor(node(element));
    }

    public Node<E> predecessor(Node<E> node){
        if (node == null) return node;

        //1.node.left != null
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null){
                p = p.right;
            }

            return p;
        }
        //2.node.left == null && node.parent!=null
        while (node.parent != null && node == node.parent.left){
            node = node.parent;
        }

        //node.left == null && node == node.parent.right
        return node.parent;
    }



    public Node<E> successor(E element){
        return predecessor(node(element));
    }

    public Node<E> successor(Node<E> node){
        if (node == null) return node;

        //1.node.right != null
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null){
                p = p.left;
            }

            return p;
        }
        //2.node.right == null && node.parent!=null
        while (node.parent != null && node == node.parent.right){
            node = node.parent;
        }

        //node.right == null && node == node.parent.left
        return node.parent;
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

    private static class Node<E> {
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
          return  this.left != null && this.right != null;
        }
    }


}
