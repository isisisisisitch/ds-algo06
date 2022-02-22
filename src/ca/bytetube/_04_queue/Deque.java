package ca.bytetube._04_queue;

import ca.bytetube._04_queue.list.LinkedList;

public class Deque<E> {

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
    void enQueueRear(E element) {
        list.add(element);
    };


    void enQueueFront(E element){
        list.add(0,element);
    };

    // deQueue
    E deQueueFront() {
        return list.remove(0);
    };


    E deQueueRear(){
        return list.remove(list.size() - 1);
    };
    //Get the head element of the queue

    E getFirst() {
        return list.get(0);
    };

    E getLast() {
        return list.get(list.size() - 1);
    };

}
