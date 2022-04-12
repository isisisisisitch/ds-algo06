package ca.bytetube._07_heap;

import ca.bytetube._05_binaryTree.PersonComparator;
import ca.bytetube._07_heap.printer.BinaryTrees;
import com.sun.source.tree.BinaryTree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        test();

//        Person[] people = {new Person("dal",32,432.5),new Person("ada",31,432.2),
//                new Person("ada",35,432.2),new Person("abc",3,432.5),new Person("qqq",91,432.2),
//                new Person("qqq",1,432.2), new Person("aaa",62,432.5),
//                new Person("ddd",11,432.2),new Person("yyy",71,432.2)};
//
//      BinaryHeap<Person> heap = new BinaryHeap<>(new Comparator<Person>() {
//          @Override
//          public int compare(Person o1, Person o2) {
//              return o1.getAge() - o2.getAge();
//          }
//      }, people);
//        BinaryTrees.println(heap);
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

    //前k小的数
    public static void topK(int[] data, int k){
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>();
        for (int i = 0; i < data.length; i++) {
           // System.out.println(binaryHeap.size());
            if (binaryHeap.size < k)  binaryHeap.add(data[i]);
            else if (data[i] < binaryHeap.get()) {
                binaryHeap.replace(data[i]);
            }
        }
        BinaryTrees.println(binaryHeap);

    }

    private static int[] getRandArr(int size ,int bound){
        int[] randArr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randNum = random.nextInt(bound) - random.nextInt(bound);
            randArr[i] = randNum;
        }

        return randArr;
    }

    private static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void test(){
        int[] randArr = new int[]{ -318, 786, 163, -24, -511, -132, 172, 303, 474, 87, 282, 135,
                732, -500, 183 };
        printArray(randArr);
        topK(randArr,4);


    }


}
