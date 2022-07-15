package ca.bytetube._17_sort;

import ca.bytetube._01_complexity.Times;
import ca.bytetube._17_sort.cmp.*;
import ca.bytetube._17_sort.utils.Asserts;
import ca.bytetube._17_sort.utils.Integers;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        Integer[] array = Integers.random(30000, 1, 30000);
        testSorts(array,
                new InsertionSort3(),
                new ShellSort(),
                new QuickSort(),
                new HeapSort(),
                new MergeSort(),
                new SelectionSort());
////        Integer[] array = Integers.tailAscOrder(1, 100000, 2000);
//        Integer[] array = Integers.random(1000, 1, 10000);
////        Integers.println(array);
////        BubbleSort3.bubbleSort(array);
////        Integers.println(array);
//
//        //Integers.println(array);
//
//        Integer[] array2 = Integers.copy(array);
//
//        Integer[] array3 = Integers.copy(array);
//
//        Times.test("BubbleSort1", new Times.Task() {
//            @Override
//            public void execute() {
//                BubbleSort1.bubbleSort(array);
//            }
//        });
//
//        Times.test("BubbleSort2", new Times.Task() {
//            @Override
//            public void execute() {
//                BubbleSort2.bubbleSort(array2);
//            }
//        });
//
//        Times.test("BubbleSort3", new Times.Task() {
//            @Override
//            public void execute() {
//                BubbleSort3.bubbleSort(array3);
//            }
//        });
//
//        Times.test("BubbleSort3", new Times.Task() {
//            @Override
//            public void execute() {
//                BubbleSort3.bubbleSort(array3);
//            }
//        });

    }

    public static void testSorts(Integer[] array, Sort... sorts){
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));

        }

        Arrays.sort(sorts);
        for (Sort sort:sorts) {
            System.out.println(sort);
        }

    }
}
