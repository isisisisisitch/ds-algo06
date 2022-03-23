package ca.bytetube._06_avlTree;

import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {


    private static class AVLNode<E> extends Node<E>{
        int height = 1;
        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor(){
            int leftHeight = this.left == null ? 0 : ((AVLNode<E>)this.left).height ;
            int rightHeight = this.right == null ? 0 : ((AVLNode<E>)this.right).height ;
            return leftHeight - rightHeight;
        }


        public void calculateHeight() {
            int leftHeight = this.left == null ? 0 : ((AVLNode<E>)this.left).height ;
            int rightHeight = this.right == null ? 0: ((AVLNode<E>)this.right).height ;
            height =  Math.max(leftHeight,rightHeight) + 1;
        }

        public Node<E> tallerChild() {
            return null;
        }
    }

    private Comparator<E> comparator;



    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
       this.comparator = comparator;
    }

    @Override
    public void afterAdd(Node<E> node){//leaf node
        while ((node = node.parent) != null){
            if (isBalanced(node)) {
                //计算节点的高度
                ((AVLNode<E>)node).calculateHeight();
            }else {
                rebalance(node);
                break;
            }
        }

    }

    private void rebalance(Node<E> grand) {

        Node<E> parent =  ((AVLNode<E>)grand).tallerChild();
        Node<E> node =  ((AVLNode<E>)parent).tallerChild();

        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) {//LL
                rightRotation(grand);
            }else {//LR

                leftRotation(parent);
                rightRotation(grand);
            }
        }else {//R
            if (node.isLeftChild()) {//RL
                rightRotation(parent);
                leftRotation(grand);
            }else {//RR
                leftRotation(grand);
            }

        }

    }

    private void leftRotation(Node<E> parent) {

    }


    private void rightRotation(Node<E> grand) {
    }

    private boolean isBalanced(Node<E> node) {

        return  Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
    }

    @Override
    public Node<E> createNode(E element,  Node<E> parent){
        return new AVLNode<>(element,parent);
    }
}
