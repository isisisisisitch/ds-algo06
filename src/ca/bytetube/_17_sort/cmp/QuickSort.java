package ca.bytetube._17_sort.cmp;

import ca.bytetube._17_sort.Sort;
import ca.bytetube._17_sort.utils.Integers;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    public static void main(String[] args) {
        Integer[] randomArr = Integers.random(10, 1, 100);
        Integers.println(randomArr);

        new QuickSort().sort(randomArr);
        Integers.println(randomArr);
    }

    @Override
    protected void sort() {
        sort(0, array.length);
    }


    /**
     * 对[begin,end)范围的数据进行排序
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;

        int pivot = pivotIndex(begin, end);
        //对子序列进行排序
        sort(begin, pivot);
        sort(pivot + 1, end);

    }

    private int pivotIndex(int begin, int end) {

        swap(begin, begin + (int) (Math.random() * (end - begin)));//[begin,end - begin)

        //1.备份begin位置上的元素
        T pivot = array[begin];
        end--;
        while (begin < end) {
            //从右向左的过程
            while (begin < end) {

                if (cmp(pivot, array[end]) < 0) end--;//end位置上的元素 > 分界点的值
                else {
                    array[begin++] = array[end];//end位置上的元素 <= 分界点的值
                    break;
                }
            }

            //从左向右的过程
            while (begin < end) {
                //从左向右的过程
                if (cmp(pivot, array[begin]) > 0) begin++;
                else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }


        //将pivot放到最终剩下的位置
        array[begin] = pivot;

        return begin;
    }
}
