package ca.bytetube._17_sort.cmp;

import ca.bytetube._17_sort.Sort;
import ca.bytetube._17_sort.utils.Integers;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

    public static void main(String[] args) {
        Integer[] randomArr = Integers.random(10, 1, 100);
        Integers.println(randomArr);
        new SelectionSort().sort(randomArr);
        Integers.println(randomArr);
    }



    @Override
    protected void sort() {
        if (array == null || array.length == 0 || array.length == 1) return;

        for (int end = array.length - 1; end > 0; end--) {
            int maxIdx = 0;
            for (int begin = 1; begin <= end ; begin++) {
                if (cmp(maxIdx,begin) < 0) {
                    maxIdx = begin;
                }
            }
           swap(maxIdx,end);

        }
    }
}
