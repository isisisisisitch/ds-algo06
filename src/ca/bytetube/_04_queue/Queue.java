package ca.bytetube._04_queue;

import ca.bytetube._04_queue.list.LinkedList;

public class Queue<E> {

    private LinkedList<E> list = new LinkedList<>();

    // Number of elements
    int size() {
        return list.size();
    };


    // Is it empty
    boolean isEmpty() {
        return list.isEmpty();
    };

    // Clear elements
    void clear() {
        list.clear();
    };


    //enQueue
    void enQueue(E element) {
        list.add(element);
    };


    // deQueue
    E deQueue() {
        return list.remove(0);
    };


    //Get the head element of the queue

    E front() {
        return list.get(0);
    };



}
