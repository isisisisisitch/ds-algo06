package ca.bytetube._17_sort.uncmp;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {7,3,5,8,6,7,4,5};
        printArray(arr);
        sort(arr);
        printArray(arr);

    }

    protected static void sort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;
        //1.找到数组中的最大值,最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min  = array[i];
        }

        //2.创建1个数组，用于存储元素出现的次数
        int[] counts = new int[max - min + 1];
        //2.1 统计元素出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i] -min]++;
        }
        //3.累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i-1];
        }

        //4.做一个新的数组用来存储排序后的结果
        int[] newArray = new int[array.length];

        //5.从右向左对array进行遍历，为了保证排序的稳定性
        for (int i = array.length - 1; i >= 0 ; i--) {
           //int index =  counts[array[i] - min]--;
           newArray[-- counts[array[i] - min]] = array[i];
        }

        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }


    }


    protected static void sort0(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) return;

        //1.找到数组中的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }

        //2.用来统计数组中元素出现次数
        int[] counts = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        //3.根据counts数组中的value对原数组进行排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                array[index++] = i;
            }
        }


    }


    public static void printArray(int[] array){
        for (int element:array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}
