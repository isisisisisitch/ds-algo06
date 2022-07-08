package ca.bytetube._17_sort.cmp;

import ca.bytetube._17_sort.Sort;
import ca.bytetube._17_sort.utils.Integers;

public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    public static void main(String[] args) {

        Integer[] randomArr = Integers.random(10, 1, 100);
        Integers.println(randomArr);

        new MergeSort().sort(randomArr);
        Integers.println(randomArr);

    }

    private T[] leftArray;

    @Override
    protected void sort() {

        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(0, array.length);

    }

    /**
     * 对[begin,end) 范围内的数据进行归并排序
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;

        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);

        merge(begin, mid, end);

    }

    /**
     * 将[begin,mid),[mid,end)范围内的有序数据合并成一个有序数组
     */
    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;


        //1.备份左半数组
        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }

        //merge leftArray and rightArray

        while (li < le){
            if (ri < re &&  cmp(array[ri],leftArray[li]) < 0) {//array[ri] < array[li]
                array[ai++] = array[ri++];

            }else {//array[ri] > array[li]
                array[ ai++] = leftArray[li++];

            }

        }

    }


}
