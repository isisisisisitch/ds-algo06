package ca.bytetube.list;

public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;


    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;


        public Node( Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }


    private Node<E> node(int index) {
        rangeCheck(index);
        if (index < (size >> 1)) {//index 在前半部分
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else {//index 在后半部分

            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }


    }

    @Override
    public void clear() {
        first = null;
        last = null;
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
        //尾部添加
        if (index == size) {
            Node<E> oldLast = last;//null
            Node<E> newLast = new Node<>(oldLast, element, null);
            last = newLast;
            if (size == 0) {
                first = newLast;
            }
            else   oldLast.next = newLast;
        }
        else {
            //普通和0位置添加
            Node<E> nextNode = node(index);
            Node<E> preNode = nextNode.prev;

            Node<E> node = new Node<>(preNode, element, nextNode);
            nextNode.prev = node;
            if (index == 0) first = node;
            else  preNode.next = node;

        }

        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        //普通位置和尾部位置和0位置
        Node<E> node = node(index);
        Node<E> preNode = node.prev;//1
        Node<E> nextNode = node.next;//3

        if (index == 0) first = nextNode;
        else preNode.next = nextNode;

        if (nextNode == null)  last = preNode;
        else nextNode.prev = preNode;

        size--;

        return node.element;
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

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(1,66);

    }


}
