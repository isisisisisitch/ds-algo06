package ca.bytetube._07_heap;

public interface Heap<E> {
    // the number of elements
    int size();

    // is it empty
    boolean isEmpty();

    // clear elements
    void clear();

    // add elements
    void add(E element);

    // get the top element of the heap
    E get();

    // delete the top element of the heap
    E remove();

    // insert a new element while deleting the top element of the heap
    E replace(E element);


}
