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

    /**
     * remove elements
     */
    void remove(E element) {

    }

    /**
     * does it contain an element or not
     */
    boolean contains(E element) {
        return false;
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
    }

}
