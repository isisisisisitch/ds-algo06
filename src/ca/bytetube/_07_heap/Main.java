package ca.bytetube._07_heap;

import ca.bytetube._05_binaryTree.PersonComparator;
import ca.bytetube._07_heap.printer.BinaryTrees;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Person[] people = {new Person("dal",32,432.5),new Person("ada",31,432.2),
                new Person("ada",35,432.2),new Person("abc",3,432.5),new Person("qqq",91,432.2),
                new Person("qqq",1,432.2), new Person("aaa",62,432.5),
                new Person("ddd",11,432.2),new Person("yyy",71,432.2)};

      BinaryHeap<Person> heap = new BinaryHeap<>(new Comparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
              return o1.getAge() - o2.getAge();
          }
      }, people);
        BinaryTrees.println(heap);
//        BinaryHeap<Integer> heap = new BinaryHeap<>();
//        heap.add(72);
//        heap.add(68);
//        heap.add(50);
//        heap.add(43);
//        heap.add(38);
//        heap.add(47);
//        heap.add(21);
//        heap.add(14);
//        heap.add(40);
//        heap.add(3);
//        BinaryTrees.println(heap);
//        heap.replace(12);
//        System.out.println("===================================");
//        BinaryTrees.println(heap);
//
//        Integer[] arr = {1,2,3,4,5,6};

       // BinaryHeap<Integer> heap2 = new BinaryHeap<>(null,arr);



    }
}
