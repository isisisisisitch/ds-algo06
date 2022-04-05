package ca.bytetube._07_heap;

import ca.bytetube._07_heap.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(72);
        heap.add(68);
        heap.add(50);
        heap.add(43);
        heap.add(38);
        heap.add(47);
        heap.add(21);
        heap.add(14);
        heap.add(40);
        heap.add(3);
        BinaryTrees.println(heap);
        heap.replace(12);
        System.out.println("===================================");
        BinaryTrees.println(heap);

        Integer[] arr = {1,2,3,4,5,6};

        BinaryHeap<Integer> heap2 = new BinaryHeap<>(null,arr);

    }
}
