package ca.bytetube._17_sort.cmp;

import ca.bytetube._17_sort.Sort;
import ca.bytetube._17_sort.utils.Integers;


public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {

    public static void main(String[] args) {

        Integer[] randomArr = Integers.random(10, 1, 100);
        Integers.println(randomArr);
        new InsertionSort2().sort(randomArr);
        Integers.println(randomArr);
    }

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            T v = array[cur];
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
               // swap(cur, cur - 1);
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }


    }
}
