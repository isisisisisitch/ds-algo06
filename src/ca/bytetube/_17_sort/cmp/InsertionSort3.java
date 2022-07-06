package ca.bytetube._17_sort.cmp;

import ca.bytetube._17_sort.Sort;
import ca.bytetube._17_sort.utils.Integers;


public class InsertionSort3<T extends Comparable<T>> extends Sort<T> {

    public static void main(String[] args) {

        Integer[] randomArr = Integers.random(10, 1, 100);
        Integers.println(randomArr);

       new InsertionSort3().sort(randomArr);
        Integers.println(randomArr);

    }

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {

            T v = array[begin];//先备份
            int insertIndex = search(begin);
            for (int i = begin; i > insertIndex ; i--) {
                array[i] = array[i - 1];
            }

            array[insertIndex] = v;
        }

    }

    /**
     * 利用binary search查找v = arr[index] 在数组中的待插入位置
     *
     * @param index [0,index)范围内数组已经有序
     * @return
     */
    public int search(int index) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = index;

        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(array[index] , array[mid])< 0) end = mid;
            else begin = mid + 1;
        }

        return begin;

    }
}
