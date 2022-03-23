package ca.bytetube._06_avlTree;

import java.util.Comparator;

public class BinarySearchTree<E> extends BinaryTree<E> {
    private Comparator<E> comparator;

    public BinarySearchTree() { }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }


    public void afterAdd(Node<E> node){}

    public Node<E> createNode(E element,  Node<E> parent){
        return new Node(element,parent);
    }

    /**
     *  add elements
     */
    void add(E element) {
        //1.对元素做非空判断
        elementNotNullCheck(element);
        //2.1添加第一个节点
        if (root == null) {
            root = createNode(element,null);
            size++;
            afterAdd(root);
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
        Node<E> newNode = createNode(element,parent);
        if (cmp > 0)   parent.right = newNode;
        else parent.left = newNode;
        size++;
        afterAdd(newNode);
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


    public Node<E> node(E element) {
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




}
