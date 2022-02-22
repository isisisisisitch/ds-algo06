package ca.bytetube._02_list.single;

import ca.bytetube._02_list.AbstractList;

public class CircularLinkedList<E> extends AbstractList<E> {

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
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //头部的add
        //这种写法是错误的，忽略了空链表的时插入第一个节点的情况
        if (index == 0) {
//            first = new Node<>(element, first);
//            Node<E> last = node(size - 1);
//            last.next = first;

            Node<E> newFirst = new Node<>(element, first);

            Node<E> last = (size == 0) ? newFirst : node(size - 1);

            last.next = newFirst;

            first = newFirst;
        } else {
            //普通位置和尾部的add
            Node<E> preNode = node(index - 1);
            //int i = 10;//赋值操作 --->从等号的右边向左边看
            preNode.next = new Node<>(element, preNode.next);//指向操作--->从等号的左边向右边看
        }


        size++;
    }


    @Override
    public E remove(int index) {
        //头部的remove
        rangeCheck(index);

        Node<E> removed = first;
        if (index == 0) {
            if (size == 1) first = null;
            else {
                first = first.next;
                Node<E> last = node(size - 1);
                last.next = first;
            }
        }
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
        CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();
        circularLinkedList.add(0, 10);
        circularLinkedList.add(1, 20);
        circularLinkedList.add(2, 30);
        circularLinkedList.add(3, 40);
        circularLinkedList.add(4, 50);

        System.out.println(circularLinkedList);

//        while (circularLinkedList.size > 0){
//            circularLinkedList.remove(circularLinkedList.size - 1 );
//            System.out.println(circularLinkedList);
//        }

        int size = circularLinkedList.size;
        for (int i = 0; i < size; i++) {
            circularLinkedList.remove(circularLinkedList.size - 1 );
            System.out.println(circularLinkedList);
        }

    }

}
