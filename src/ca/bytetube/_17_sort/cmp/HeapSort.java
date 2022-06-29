package ca.bytetube._17_sort.cmp;

import ca.bytetube._17_sort.Sort;
import ca.bytetube._17_sort.utils.Integers;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {


    public static void main(String[] args) {
        Integer[] randomArr = Integers.random(10, 1, 100);
        Integers.println(randomArr);
        new HeapSort().sort(randomArr);
        Integers.println(randomArr);
    }

    private int heapSize;


    @Override
    protected void sort() {
        //① heapify
        heapSize = array.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }

        //2.Swap the top and tail elements of the heap, Decrease the number of elements
        //Decrease the number of elements in the heap by 1
        //Then do siftDown operation on the 0 position

        while (heapSize > 1) {
            swap(0, --heapSize);
            siftDown(0);
        }


    }

    private void siftDown(int index) {
        int half = heapSize >> 1;
        T element = array[index];
        //必须保证index位置是非叶节点
        while (index < half) {//当遇到第一个叶节点下标时停止
            //index所对应的节点只有2种情况
            //1.只有left
            //2.left，right都有
            //规定默认与left比较
            int childIndex = (index << 1) + 1;
            T child = array[childIndex];
            int rightIndex = childIndex + 1;

            //选出左右孩子中最大值
            if (rightIndex < heapSize && cmp(array[rightIndex], child) > 0) {//细节：需要先判断rightIndex < size，防止rightIndex越界
                child = array[childIndex = rightIndex];
            }

            //代码能来到这里，一定找到了左右孩子中的最大值
            if (cmp(element, child) >= 0) break;
            array[index] = child;
            index = childIndex;

        }
        array[index] = element;
    }
}
