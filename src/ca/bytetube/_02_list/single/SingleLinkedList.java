package ca.bytetube._02_list.single;

import ca.bytetube._02_list.AbstractList;
import ca.bytetube._02_list.List;

public class SingleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;

    }

    @Override
    public void clear() {
        first = null;
        size = 0;

    }


    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //头部的add
        if (index == 0) first = new Node<>(element, first);
        else {
            //普通位置和尾部的add
            Node<E> preNode = node(index - 1);
            //int i = 10;//赋值操作 --->从等号的右边向左边看
            preNode.next = new Node<>(element, preNode.next);//指向操作--->从等号的左边向右边看
        }


        size++;
    }


    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> node = node(index);

        E oldElement = node.element;

        node.element = element;
        return oldElement;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        //头部的remove
        Node<E> removed = first;
        if (index == 0) first = first.next;


            //普通位置和尾部的remove
        else {
            Node<E> preNode = node(index - 1);
            removed = preNode.next;
            preNode.next = removed.next;
        }


         size--;

        return removed.element;


    }


    @Override
    public int indexOf(E element) {

        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }

        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }


        return ELEMENT_NOT_FOUND;
    }



    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size: ").append(size).append(",{");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            sb.append(node.element);
            node = node.next;
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("}");

        return sb.toString();
    }


    public static void main(String[] args) {

        List<Integer> list = new SingleLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(2, 100);
        // System.out.println(list.size());
        list.set(2, 1000);
        System.out.println(list.get(2));
        System.out.println(list);
        //System.out.println(list.remove(0));

        System.out.println(list.indexOf(1000));
        System.out.println(list.contains(300));
    }
}
