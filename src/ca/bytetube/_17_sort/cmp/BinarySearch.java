package ca.bytetube._17_sort.cmp;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {10,32,45,78,90,90,90,100,532};
        System.out.println(search(array,90));
    }

    /**
     * 查找v在有序数组array中的下标
     *
     * @param array
     * @param v
     * @return
     */
    public static int indexOf(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;

        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v == array[mid]) return mid;
            else if (v < array[mid]) end = mid;
            else begin = mid + 1;
        }

        return -1;

    }

    /**
     * 查询v在有序数组中的插入位置
     * @param array
     * @param v
     * @return
     */
    public static int search(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;

        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v < array[mid]) end = mid;
            else begin = mid + 1;
        }

        return begin;

    }
}
