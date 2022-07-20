package ca.bytetube._17_sort.uncmp;

import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {
        double[] arr = {0.34,0.47,0.29,0.84,0.67,0.54,0.89,0.43};
        printArray(arr);
        sort(arr);
        printArray(arr);

    }

    /**
     * 1.创建一定数量的桶(array,list...)
     * 2.按照一定的规则，将序列中的元素尽可能均匀的分配到不用的桶
     * 3.分别去对每个桶进行单独的排序
     * 4.将所有非空桶的元素合并起来
     *
     * 0
     * 1
     * 2 0.34,0.29
     * 3 0.47,0.43
     * 4 0.54
     * 5 0.67
     * 6 0.84
     * 7 0.89
     */
    protected static void sort(double[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;
        List<Double>[] buckets = new List[array.length];
        for (int i = 0; i < array.length; i++) {
          int bucketIndex = (int) (array[i] * array.length);
           List<Double> bucket = buckets[bucketIndex];
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[bucketIndex] = bucket;
            }
            bucket.add(array[i]);
        }
        //对每个桶单独进行排序
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            buckets[i].sort(null);
            for (Double d : buckets[i]) {
                array[index++] = d;
            }
        }
    }


    public static void printArray(double[] array){
        for (double element:array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}
