package ca.bytetube._07_heap;


import ca.bytetube._07_heap.printer.BinaryTreeInfo;
import java.util.Comparator;


public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {

    private E[] elements = (E[]) new Object[DEFAULT_CAPACITY];

    private static final int DEFAULT_CAPACITY = 15;


    public BinaryHeap(Comparator<E> comparator, E[] elements) {
//        super(comparator);
//        this.elements = elements;
    }

    public BinaryHeap() { }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }


    @Override
    public E replace(E element) {
        emptyCheck();
        E root = elements[0];
        elements[0] = element;
        siftDown(0);
        return root;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);

    }


    @Override
    public E remove() {
        emptyCheck();

        E root = elements[0];
        int lastIndex = --size;
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);

        return root;
    }



    private void siftDown(int index) {
        int half = size >> 1;
        E element = elements[index];
        //必须保证index位置是非叶节点
        while (index < half) {//当遇到第一个叶节点下标时停止
            //index所对应的节点只有2种情况
            //1.只有left
            //2.left，right都有
            //规定默认与left比较
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];
            int rightIndex = childIndex + 1;

            //选出左右孩子中最大值
            if (rightIndex < size && compare(elements[rightIndex], child) > 0) {//细节：需要先判断rightIndex < size，防止rightIndex越界
                child = elements[childIndex = rightIndex];
            }

            //代码能来到这里，一定找到了左右孩子中的最大值
            if (compare(element, child) >= 0) break;
            elements[index] = child;
            index = childIndex;

        }
        elements[index] = element;
    }

    private void emptyCheck() {

        if (isEmpty()) {
            throw new RuntimeException("heap is empty!");
        }

    }


    private void siftUp(int index) {
        E e = elements[index];
        int parentIndex = (index - 1) >> 1;

        while (index > 0) {
            E parent = elements[parentIndex];

            //2.node.val <= parent.val
            if (compare(e, parent) <= 0) break;

            //1.node.val > parent.val
            elements[index] = parent;
            index = parentIndex;//目的：为了让siftUp不断地向上

        }

        //找到元素的插入点
        elements[index] = e;


    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;//size
        if (oldCapacity >= capacity) {
            return;
        } else {
            //当前容量已经不够了，需要扩容
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            E[] newElements = (E[]) new Object[newCapacity];

            //数据的迁移
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) throw new IllegalArgumentException("element can not be null !");
    }


    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
       int index = ((int)node << 1) + 1;

        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int)node << 1) + 2;

        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {

        return elements[(int)node];
    }
}
