package ca.bytetube._13_divide;

public class SmallSum {
    public static void main(String[] args) throws Exception {
        System.out.println(smallSum(new int[]{1,3,4,2,5}));
    }


    public static int smallSum(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) throw new Exception("error data");
        if (arr.length == 1) return 0;

        return mergeSort(arr, 0, arr.length - 1);
    }


    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) return 0;
        int mid = (l + r) >> 1;

        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);

    }

    public static int merge(int[] arr, int l, int m, int r) {
        int p1 = l;
        int p2 = m + 1;
        int[] help = new int[r - l + 1];
        int i = 0;
        int res = 0;
        while (p1 <= m && p2 <= r) {

            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;

            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];

        }

        while (p1 <= m)  help[i++] = arr[p1++];

        while (p2 <= r)  help[i++] = arr[p2++];

        for (int j = 0; j < help.length; j++)  arr[l + j] = help[j];

        return res;

    }
}