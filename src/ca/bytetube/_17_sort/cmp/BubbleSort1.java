package ca.bytetube._17_sort.cmp;

import ca.bytetube._17_sort.utils.Integers;

public class BubbleSort1 {

    public static void main(String[] args) {
        Integer[] randomArr = Integers.random(10, 1, 100);
        Integers.println(randomArr);
        bubbleSort(randomArr);
        Integers.println(randomArr);
    }


    public static void bubbleSort(Integer[] arr) {
        if (arr == null || arr.length == 0||arr.length == 1) return;

        for (int end = arr.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (arr[begin] < arr[begin - 1]) {
                    int temp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = temp;
                }
            }
        }


    }

}
